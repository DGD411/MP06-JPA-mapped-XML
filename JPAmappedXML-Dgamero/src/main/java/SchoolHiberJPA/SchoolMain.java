package SchoolHiberJPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

public class SchoolMain {
    public static void main(String[] args) throws IOException, SQLException, ParseException {
        Menu menu = new Menu();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();

        FileAccessor.printGroups(em);
        FileAccessor.printSubjects(em);
        FileAccessor.printSessions(em);
        FileAccessor.printDepartments(em);
        FileAccessor.printTeachers(em);

        em.close();
        emf.close();
        int option;
        FileAccessor fileAccessor= new FileAccessor();
        option = menu.menuPral();
        while (option > 0 && option < 7) {
            switch (option) {
                case 1:
                    fileAccessor.printDepartments(em);
                    break;

                case 2:
                    fileAccessor.printGroups(em);
                    break;

                case 3:
                    fileAccessor.printSessions(em);
                    break;

                case 4:
                    fileAccessor.printSessions(em);
                    break;

                case 5:
                    fileAccessor.printTeachers(em);
                    break;

                case 6:
                    fileAccessor.cargarDatos(em);
                    break;

                case 0:
                    fileAccessor.sortir();


                default:
                    System.out.println("Introdueixi una de les opcions anteriors");
                    break;

            }
            option = menu.menuPral();
        }

    }

}
