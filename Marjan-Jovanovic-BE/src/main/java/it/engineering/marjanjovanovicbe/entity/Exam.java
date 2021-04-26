package it.engineering.marjanjovanovicbe.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ExamPeriod examPeriod;

    @ManyToOne
    private SubjectEntity subject;

    @ManyToOne
    private ProfessorEntity professor; //Professor has to be working on the selected subject

    @ManyToMany
    @JoinTable(name = "student_exam", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "exam_id"))
    private List<StudentEntity> students;

    private LocalDate date;

    public Exam() {
    }

    public Exam(Long id, ExamPeriod examPeriod, SubjectEntity subject, ProfessorEntity professor, List<StudentEntity> students, LocalDate date) {
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

    public ExamPeriod getExamPeriod() {
        return examPeriod;
    }

    public void setExamPeriod(ExamPeriod examPeriod) {
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
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", examPeriod=" + examPeriod +
                ", subject=" + subject +
                ", professor=" + professor +
                ", students=" + students +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exam)) return false;

        Exam exam = (Exam) o;

        if (id != null ? !id.equals(exam.id) : exam.id != null) return false;
        if (examPeriod != null ? !examPeriod.equals(exam.examPeriod) : exam.examPeriod != null) return false;
        if (subject != null ? !subject.equals(exam.subject) : exam.subject != null) return false;
        if (professor != null ? !professor.equals(exam.professor) : exam.professor != null) return false;
        if (students != null ? !students.equals(exam.students) : exam.students != null) return false;
        return date != null ? date.equals(exam.date) : exam.date == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (examPeriod != null ? examPeriod.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (professor != null ? professor.hashCode() : 0);
        result = 31 * result + (students != null ? students.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
