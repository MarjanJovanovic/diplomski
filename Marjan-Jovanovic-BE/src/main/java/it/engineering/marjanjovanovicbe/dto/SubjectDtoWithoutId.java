package it.engineering.marjanjovanovicbe.dto;

import it.engineering.marjanjovanovicbe.util.Semester;

public class SubjectDtoWithoutId {


    private String name;
    private String description;
    private Long noOfEsp;
    private Long yearOfStudy;
    private Semester semester;


    public SubjectDtoWithoutId() {
    }

    public SubjectDtoWithoutId(String name, String description, Long noOfEsp, Long yearOfStudy, Semester semester) {
        this.name = name;
        this.description = description;
        this.noOfEsp = noOfEsp;
        this.yearOfStudy = yearOfStudy;
        this.semester = semester;
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
        return yearOfStudy;
    }

    public void setYearOfStudy(Long yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }


    @Override
    public String toString() {
        return "SubjectDto{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", noOfEsp=" + noOfEsp +
                ", YearOfStudy=" + yearOfStudy +
                ", semester=" + semester +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectDtoWithoutId)) return false;

        SubjectDtoWithoutId that = (SubjectDtoWithoutId) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (noOfEsp != null ? !noOfEsp.equals(that.noOfEsp) : that.noOfEsp != null) return false;
        if (yearOfStudy != null ? !yearOfStudy.equals(that.yearOfStudy) : that.yearOfStudy != null) return false;
        return semester == that.semester;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (noOfEsp != null ? noOfEsp.hashCode() : 0);
        result = 31 * result + (yearOfStudy != null ? yearOfStudy.hashCode() : 0);
        result = 31 * result + (semester != null ? semester.hashCode() : 0);
        return result;
    }
}
