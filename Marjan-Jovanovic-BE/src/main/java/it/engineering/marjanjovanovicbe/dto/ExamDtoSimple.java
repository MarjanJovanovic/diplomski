package it.engineering.marjanjovanovicbe.dto;

import java.time.LocalDate;
import java.util.List;

public class ExamDtoSimple implements MyDto{

    private Long id;
    private ExamPeriodDtoSimple examPeriodDto;
    private SubjectDtoSimple subject;
    private ProfessorDtoSimple professor;
    private LocalDate date;

    public ExamDtoSimple() {
    }

    public ExamDtoSimple(Long id, ExamPeriodDtoSimple examPeriodDto, SubjectDtoSimple subject, ProfessorDtoSimple professor, LocalDate date) {
        this.id = id;
        this.examPeriodDto = examPeriodDto;
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

    public ExamPeriodDtoSimple getExamPeriodDto() {
        return examPeriodDto;
    }

    public void setExamPeriodDto(ExamPeriodDtoSimple examPeriodDto) {
        this.examPeriodDto = examPeriodDto;
    }

    public SubjectDtoSimple getSubject() {
        return subject;
    }

    public void setSubject(SubjectDtoSimple subject) {
        this.subject = subject;
    }

    public ProfessorDtoSimple getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorDtoSimple professor) {
        this.professor = professor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ExamDtoSimple{" +
                "id=" + id +
                ", examPeriodDto=" + examPeriodDto +
                ", subject=" + subject +
                ", professor=" + professor +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExamDtoSimple)) return false;


        ExamDtoSimple that = (ExamDtoSimple) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (examPeriodDto != null ? !examPeriodDto.equals(that.examPeriodDto) : that.examPeriodDto != null)
            return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        if (professor != null ? !professor.equals(that.professor) : that.professor != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (examPeriodDto != null ? examPeriodDto.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (professor != null ? professor.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
