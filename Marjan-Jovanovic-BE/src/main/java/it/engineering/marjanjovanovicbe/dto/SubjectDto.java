package it.engineering.marjanjovanovicbe.dto;

import it.engineering.marjanjovanovicbe.entity.ProfessorEntity;
import it.engineering.marjanjovanovicbe.util.Semester;

import javax.persistence.*;
import java.util.List;

public class SubjectDto implements MyDto {

    private Long id;
    private String name;
    private String description;
    private Long noOfEsp;
    private Long YearOfStudy;
    private Semester semester;
    private List<ProfessorEntity> professors;

    public SubjectDto() {
    }

    public SubjectDto(Long id, String name, String description, Long noOfEsp, Long yearOfStudy, Semester semester, List<ProfessorEntity> professors) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.noOfEsp = noOfEsp;
        YearOfStudy = yearOfStudy;
        this.semester = semester;
        this.professors = professors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getNoOfEsp() {
        return noOfEsp;
    }

    public void setNoOfEsp(Long noOfEsp) {
        this.noOfEsp = noOfEsp;
    }

    public Long getYearOfStudy() {
        return YearOfStudy;
    }

    public void setYearOfStudy(Long yearOfStudy) {
        YearOfStudy = yearOfStudy;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public List<ProfessorEntity> getProfessors() {
        return professors;
    }

    public void setProfessors(List<ProfessorEntity> professors) {
        this.professors = professors;
    }

    @Override
    public String toString() {
        return "SubjectDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", noOfEsp=" + noOfEsp +
                ", YearOfStudy=" + YearOfStudy +
                ", semester=" + semester +
                ", professors=" + professors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectDto)) return false;

        SubjectDto that = (SubjectDto) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (noOfEsp != null ? !noOfEsp.equals(that.noOfEsp) : that.noOfEsp != null) return false;
        if (YearOfStudy != null ? !YearOfStudy.equals(that.YearOfStudy) : that.YearOfStudy != null) return false;
        if (semester != that.semester) return false;
        return professors != null ? professors.equals(that.professors) : that.professors == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (noOfEsp != null ? noOfEsp.hashCode() : 0);
        result = 31 * result + (YearOfStudy != null ? YearOfStudy.hashCode() : 0);
        result = 31 * result + (semester != null ? semester.hashCode() : 0);
        result = 31 * result + (professors != null ? professors.hashCode() : 0);
        return result;
    }
}
