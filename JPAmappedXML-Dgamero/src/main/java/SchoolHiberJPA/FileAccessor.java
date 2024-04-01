package SchoolHiberJPA;

import SchoolHiberJPA.Entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.io.*;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class FileAccessor {

    private String dbname;
    private String host;
    private String port;
    private String user;
    private String passwd;
    private String schema;
    Connection connection = null;

    public void init() {
        Properties prop = new Properties();
        InputStream propStream = this.getClass().getClassLoader().getResourceAsStream("SchoolHiberJPA/db.properties");

        try {
            prop.load(propStream);
            this.host = prop.getProperty("host");
            this.port = prop.getProperty("port");
            this.dbname = prop.getProperty("dbname");
            this.user = prop.getProperty("user");
            this.passwd = prop.getProperty("passwd");
            this.schema = prop.getProperty("schema");
        } catch (IOException e) {
            String message = "ERROR: db.properties file could not be found";
            System.err.println(message);
            throw new RuntimeException(message, e);
        }
    }
    public static void cargarDatos(EntityManager em) {
        cargarDatosFromFile(em, "groups.txt", FileAccessor::loadGroupsFromFile);
        cargarDatosFromFile(em, "subjects.txt", FileAccessor::loadSubjectsFromFile);
        cargarDatosFromFile(em, "sessions.txt", FileAccessor::loadSessionsFromFile);
        cargarDatosFromFile(em, "departments.txt", FileAccessor::loadDepartmentsFromFile);
        cargarDatosFromFile(em, "teachers.txt", FileAccessor::loadTeachersFromFile);
    }

    private static void cargarDatosFromFile(EntityManager em, String filename, DataLoader loader) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                loader.load(em, line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private interface DataLoader {
        void load(EntityManager em, String[] data);
    }

    private static void loadGroupsFromFile(EntityManager em, String[] data) {
        Group group = new Group();
        group.setCode(data[0]);
        group.setCurriculum(data[1]);
        group.setCourse(Integer.parseInt(data[2]));
        persistEntity(em, group);
    }

    private static void loadSubjectsFromFile(EntityManager em, String[] data) {
        Subject subject = new Subject(data[0], data[1]);
        persistEntity(em, subject);
    }

    private static void loadSessionsFromFile(EntityManager em, String[] data) {
        Session session = new Session();
        session.setWeekDay(data[0]);
        // Suponiendo que los campos de hora en el archivo están en formato "HH:mm:ss"
        Time startTime = Time.valueOf(data[1]);
        Time finishTime = Time.valueOf(data[2]);
        session.setStarts(startTime);
        session.setFinishes(finishTime);
        // Suponiendo que los datos de teacher, subject y group se almacenan como códigos en el archivo
        Teacher teacher = em.find(Teacher.class, Integer.parseInt(data[3]));
        session.setTeacher(teacher);
        session.setSubjectCode(data[4]);
        session.setGroupCode(data[5]);
        persistEntity(em, session);    }

    private static void loadDepartmentsFromFile(EntityManager em, String[] data) {
        Department department = new Department(Integer.parseInt(data[0]), data[1], data[2]);
        persistEntity(em, department);
    }

    private static void loadTeachersFromFile(EntityManager em, String[] data) {
        Teacher teacher = new Teacher(Integer.parseInt(data[0]), data[1], data[2], data[3], Integer.parseInt(data[4]));
        persistEntity(em, teacher);
    }


    private static void persistEntity(EntityManager em, Object entity) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(entity);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    static void printGroups(EntityManager em) {
        List<Group> groups = em.createQuery("SELECT g FROM Group g", Group.class).getResultList();
        System.out.println("Groups:");
        for (Group group : groups) {
            System.out.println(group);
        }
    }

    static void printSubjects(EntityManager em) {
        List<Subject> subjects = em.createQuery("SELECT s FROM Subject s", Subject.class).getResultList();
        System.out.println("Subjects:");
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
    }

    static void printSessions(EntityManager em) {
        List<Session> sessions = em.createQuery("SELECT s FROM Session s", Session.class).getResultList();
        System.out.println("Sessions:");
        for (Session session : sessions) {
            System.out.println(session);
        }
    }

    static void printDepartments(EntityManager em) {
        List<Department> departments = em.createQuery("SELECT d FROM Department d", Department.class).getResultList();
        System.out.println("Departments:");
        for (Department department : departments) {
            System.out.println(department);
        }
    }

    static void printTeachers(EntityManager em) {
        List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
        System.out.println("Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }


    public void sortir() throws SQLException {
        System.out.println("ADÉU!");
        connection.close();
    }
}