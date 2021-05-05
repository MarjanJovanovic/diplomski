package it.engineering.marjanjovanovicbe.dto;


import java.time.LocalDate;
import java.util.List;

public class ExamDtoWithStudents implements MyDto{

    private Long id;
    private ExamPeriodDto examPeriodDto;
    private SubjectDto subject;
    private ProfessorDto professor;
    private LocalDate date;
    private List<StudentDto> students;

    public ExamDtoWithStudents() {
    }

    public ExamDtoWithStudents(Long id, ExamPeriodDto examPeriodDto, SubjectDto subject, ProfessorDto professor, LocalDate date, List<StudentDto> students) {
        this.id = id;
        this.examPeriodDto = examPeriodDto;
        this.subject = subject;
        this.professor = professor;
        this.date = date;
        this.students = students;
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

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "ExamDtoWithStudents{" +
                "id=" + id +
                ", examPeriodDto=" + examPeriodDto +
                ", subject=" + subject +
                ", professor=" + professor +
                ", date=" + date +
                ", students=" + students +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExamDtoWithStudents)) return false;

        ExamDtoWithStudents that = (ExamDtoWithStudents) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (examPeriodDto != null ? !examPeriodDto.equals(that.examPeriodDto) : that.examPeriodDto != null)
            return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        if (professor != null ? !professor.equals(that.professor) : that.professor != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return students != null ? students.equals(that.students) : that.students == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (examPeriodDto != null ? examPeriodDto.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (professor != null ? professor.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (students != null ? students.hashCode() : 0);
        return result;
    }
}
