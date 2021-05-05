package it.engineering.marjanjovanovicbe.dto;

import java.time.LocalDate;
import java.util.List;

public class ExamDtoWithProfessor implements MyDto{

    private Long id;
    private ExamPeriodDto examPeriodDto;
    private SubjectDto subject;
    private ProfessorDto professor;
    private List<StudentDto> students;
    private LocalDate date;

    public ExamDtoWithProfessor() {
    }

    public ExamDtoWithProfessor(Long id, ExamPeriodDto examPeriodDto, SubjectDto subject, ProfessorDto professor, List<StudentDto> students, LocalDate date) {
        this.id = id;
        this.examPeriodDto = examPeriodDto;
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

    @Override
    public String toString() {
        return "ExamDtoWithProfessor{" +
                "id=" + id +
                ", examPeriodDto=" + examPeriodDto +
                ", subject=" + subject +
                ", professor=" + professor +
                ", students=" + students +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExamDtoWithProfessor)) return false;

        ExamDtoWithProfessor that = (ExamDtoWithProfessor) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (examPeriodDto != null ? !examPeriodDto.equals(that.examPeriodDto) : that.examPeriodDto != null)
            return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        if (professor != null ? !professor.equals(that.professor) : that.professor != null) return false;
        if (students != null ? !students.equals(that.students) : that.students != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (examPeriodDto != null ? examPeriodDto.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (professor != null ? professor.hashCode() : 0);
        result = 31 * result + (students != null ? students.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
