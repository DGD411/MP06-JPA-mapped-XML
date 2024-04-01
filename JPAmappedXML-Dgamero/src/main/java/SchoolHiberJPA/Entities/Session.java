package SchoolHiberJPA.Entities;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @Column(name = "week_day")
    private String weekDay;

    @Column(name = "starts")
    private Time starts;

    @Column(name = "finishes")
    private Time finishes;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Column(name = "subject_code")
    private String subjectCode;

    @Column(name = "group_code")
    private String groupCode;

    // Constructor, getters, and setters
    public Session() {
    }

    public Session(String weekDay, Time starts, Time finishes, Teacher teacher, String subjectCode, String groupCode) {
        this.weekDay = weekDay;
        this.starts = starts;
        this.finishes = finishes;
        this.teacher = teacher;
        this.subjectCode = subjectCode;
        this.groupCode = groupCode;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public Time getStarts() {
        return starts;
    }

    public void setStarts(Time starts) {
        this.starts = starts;
    }

    public Time getFinishes() {
        return finishes;
    }

    public void setFinishes(Time finishes) {
        this.finishes = finishes;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
}
