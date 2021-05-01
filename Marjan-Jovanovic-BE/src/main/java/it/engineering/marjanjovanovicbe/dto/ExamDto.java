package it.engineering.marjanjovanovicbe.dto;


import java.time.LocalDate;

public class ExamDto implements MyDto{

    private Long id;
    private ExamPeriodDto examPeriodDto;
    private SubjectDto subject;
    private ProfessorDto professor;
    private LocalDate date;

    public ExamDto() {
    }

    public ExamDto(Long id, ExamPeriodDto examPeriodDto, SubjectDto subject, ProfessorDto professor, LocalDate date) {
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

    public ExamPeriodDto getExamPeriodDto() {
        return examPeriodDto;
    }

    public void setExamPeriodDto(ExamPeriodDto examPeriodDto) {
        this.examPeriodDto = examPeriodDto;
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


}
