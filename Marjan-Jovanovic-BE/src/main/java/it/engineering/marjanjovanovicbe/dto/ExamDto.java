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

    @Override
    public String toString() {
        return "ExamDto{" +
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
        if (!(o instanceof ExamDto)) return false;

        ExamDto examDto = (ExamDto) o;

        if (id != null ? !id.equals(examDto.id) : examDto.id != null) return false;
        if (examPeriodDto != null ? !examPeriodDto.equals(examDto.examPeriodDto) : examDto.examPeriodDto != null)
            return false;
        if (subject != null ? !subject.equals(examDto.subject) : examDto.subject != null) return false;
        if (professor != null ? !professor.equals(examDto.professor) : examDto.professor != null) return false;
        return date != null ? date.equals(examDto.date) : examDto.date == null;
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
