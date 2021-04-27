package it.engineering.marjanjovanovicbe.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "exam")
public class ExamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ExamPeriodEntity examPeriodEntity;

    @ManyToOne
    private SubjectEntity subject;

    @ManyToOne
    private ProfessorEntity professor; //Professor has to be working on the selected subject

    @ManyToMany
    @JoinTable(name = "student_exam", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "exam_id"))
    private List<StudentEntity> students;

    private LocalDate date;

    public ExamEntity() {
    }

    public ExamEntity(Long id, ExamPeriodEntity examPeriodEntity, SubjectEntity subject, ProfessorEntity professor, List<StudentEntity> students, LocalDate date) {
        this.id = id;
        this.examPeriodEntity = examPeriodEntity;
        this.subject = subject;
        this.professor = professor;
        this.students = students;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExamPeriodEntity getExamPeriod() {
        return examPeriodEntity;
    }

    public void setExamPeriod(ExamPeriodEntity examPeriodEntity) {
        this.examPeriodEntity = examPeriodEntity;
    }

    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }

    public ProfessorEntity getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorEntity professor) {
        this.professor = professor;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ExamEntity{" +
                "id=" + id +
                ", examPeriodEntity=" + examPeriodEntity +
                ", subject=" + subject +
                ", professor=" + professor +
                ", students=" + students +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExamEntity)) return false;

        ExamEntity examEntity = (ExamEntity) o;

        if (id != null ? !id.equals(examEntity.id) : examEntity.id != null) return false;
        if (examPeriodEntity != null ? !examPeriodEntity.equals(examEntity.examPeriodEntity) : examEntity.examPeriodEntity != null) return false;
        if (subject != null ? !subject.equals(examEntity.subject) : examEntity.subject != null) return false;
        if (professor != null ? !professor.equals(examEntity.professor) : examEntity.professor != null) return false;
        if (students != null ? !students.equals(examEntity.students) : examEntity.students != null) return false;
        return date != null ? date.equals(examEntity.date) : examEntity.date == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (examPeriodEntity != null ? examPeriodEntity.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (professor != null ? professor.hashCode() : 0);
        result = 31 * result + (students != null ? students.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
