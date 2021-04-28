package it.engineering.marjanjovanovicbe.dto;

import it.engineering.marjanjovanovicbe.entity.ExamPeriodEntity;
import it.engineering.marjanjovanovicbe.entity.ProfessorEntity;
import it.engineering.marjanjovanovicbe.entity.StudentEntity;
import it.engineering.marjanjovanovicbe.entity.SubjectEntity;

import java.time.LocalDate;
import java.util.List;

public class ExamDto implements MyDto{

    private Long id;
    private ExamPeriodEntity examPeriodEntity;
    private SubjectEntity subject;
    private ProfessorEntity professor;
    private List<StudentEntity> students;
    private LocalDate date;

    public ExamDto() {
    }

    public ExamDto(Long id, ExamPeriodEntity examPeriodEntity, SubjectEntity subject, ProfessorEntity professor, List<StudentEntity> students, LocalDate date) {
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

    public ExamPeriodEntity getExamPeriodEntity() {
        return examPeriodEntity;
    }

    public void setExamPeriodEntity(ExamPeriodEntity examPeriodEntity) {
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
        return "ExamDto{" +
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
        if (!(o instanceof ExamDto)) return false;

        ExamDto examDto = (ExamDto) o;

        if (id != null ? !id.equals(examDto.id) : examDto.id != null) return false;
        if (examPeriodEntity != null ? !examPeriodEntity.equals(examDto.examPeriodEntity) : examDto.examPeriodEntity != null)
            return false;
        if (subject != null ? !subject.equals(examDto.subject) : examDto.subject != null) return false;
        if (professor != null ? !professor.equals(examDto.professor) : examDto.professor != null) return false;
        if (students != null ? !students.equals(examDto.students) : examDto.students != null) return false;
        return date != null ? date.equals(examDto.date) : examDto.date == null;
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
