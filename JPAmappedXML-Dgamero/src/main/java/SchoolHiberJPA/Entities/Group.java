package SchoolHiberJPA.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    private String code;
    private String curriculum;
    private int course;

    // Constructor
    public Group() {

    }

    public Group(String code, String curriculum, int course) {
        this.code = code;
        this.curriculum = curriculum;
        this.course = course;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}
