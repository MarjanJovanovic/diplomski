package it.engineering.marjanjovanovicbe.entity;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "exam")
public class ExamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private ExamPeriodEntity examPeriod;

    @NotNull
    @ManyToOne
    private SubjectEntity subject;

    @NotNull
    @ManyToOne
    private ProfessorEntity professor;

    @ManyToMany
    @JoinTable(name = "student_exam", joinColumns = @JoinColumn(name = "exam_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<StudentEntity> students;

    @NotNull
    @FutureOrPresent
    private LocalDate date;

    public ExamEntity() {
    }

    public ExamEntity(Long id, ExamPeriodEntity examPeriod, SubjectEntity subject, ProfessorEntity professor, List<StudentEntity> students, LocalDate date) {
        this.id = id;
        this.examPeriod = examPeriod;
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
        return examPeriod;
    }

    public void setExamPeriod(ExamPeriodEntity examPeriod) {
        this.examPeriod = examPeriod;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamEntity that = (ExamEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(examPeriod, that.examPeriod) && Objects.equals(subject, that.subject) && Objects.equals(professor, that.professor) && Objects.equals(students, that.students) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, examPeriod, subject, professor, students, date);
    }

    @Override
    public String toString() {
        return "ExamEntity{" +
                "id=" + id +
                ", examPeriod=" + examPeriod +
                ", subject=" + subject +
                ", professor=" + professor +
                ", students=" + students +
                ", date=" + date +
                '}';
    }
}
