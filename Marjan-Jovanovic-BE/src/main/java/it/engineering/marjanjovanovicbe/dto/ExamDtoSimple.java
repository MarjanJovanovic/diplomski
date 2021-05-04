package it.engineering.marjanjovanovicbe.dto;

import java.time.LocalDate;
import java.util.List;

public class ExamDtoSimple {

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
}
