package it.marjanjovanovicbe.dto;


import java.time.LocalDate;
import java.util.Objects;

public class ExamDto implements MyDto{

    private Long id;
    private ExamPeriodDto examPeriod;
    private SubjectDto subject;
    private ProfessorDto professor;
    private LocalDate date;

    public ExamDto() {
    }

    public ExamDto(Long id, ExamPeriodDto examPeriod, SubjectDto subject, ProfessorDto professor, LocalDate date) {
        this.id = id;
        this.examPeriod = examPeriod;
        this.subject = subject;
        this.professor = professor;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExamPeriodDto getExamPeriod() {
        return examPeriod;
    }

    public void setExamPeriod(ExamPeriodDto examPeriod) {
        this.examPeriod = examPeriod;
    }

    public SubjectDto getSubject() {
        return subject;
    }

    public void setSubject(SubjectDto subject) {
        this.subject = subject;
    }

    public ProfessorDto getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorDto professor) {
        this.professor = professor;
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
        ExamDto examDto = (ExamDto) o;
        return Objects.equals(id, examDto.id) && Objects.equals(examPeriod, examDto.examPeriod) && Objects.equals(subject, examDto.subject) && Objects.equals(professor, examDto.professor) && Objects.equals(date, examDto.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, examPeriod, subject, professor, date);
    }

    @Override
    public String toString() {
        return "ExamDto{" +
                "id=" + id +
                ", examPeriod=" + examPeriod +
                ", subject=" + subject +
                ", professor=" + professor +
                ", date=" + date +
                '}';
    }
}
