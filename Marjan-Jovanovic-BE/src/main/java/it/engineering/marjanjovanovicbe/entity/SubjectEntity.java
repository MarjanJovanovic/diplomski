package it.engineering.marjanjovanovicbe.entity;

import it.engineering.marjanjovanovicbe.util.Semester;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "subject")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3)
    @Column(columnDefinition = "varchar(30)", nullable = false, unique = false)
    private String name;

    @Column(columnDefinition = "varchar(200)", nullable = true, unique = false)
    private String description;

    @Column(columnDefinition = "bigint(1)", nullable = false, unique = false)
    private Long noOfEsp;

    @Column(columnDefinition = "bigint(1)", nullable = false, unique = false)
    private Long yearOfStudy;

    @Enumerated (EnumType.STRING)
    @Column(columnDefinition = "varchar(10)", nullable = false, unique = false)
    private Semester semester;

    @ManyToMany
    @JoinTable(name = "subject_professor", joinColumns = @JoinColumn(name = "subject_id"), inverseJoinColumns = @JoinColumn(name = "professor_id"))
    private List<ProfessorEntity> professors;

    public SubjectEntity() {
    }

    public SubjectEntity(Long id, String name, String description, Long noOfEsp, Long yearOfStudy, Semester semester, List<ProfessorEntity> professors) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.noOfEsp = noOfEsp;
        this.yearOfStudy = yearOfStudy;
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

    public List<ProfessorEntity> getProfessors() {
        return professors;
    }

    public void setProfessors(List<ProfessorEntity> professors) {
        this.professors = professors;
    }

    @Override
    public String toString() {
        return "SubjectEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", noOfEsp=" + noOfEsp +
                ", YearOfStudy=" + yearOfStudy +
                ", semester=" + semester +
                ", professors=" + professors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectEntity)) return false;

        SubjectEntity that = (SubjectEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (noOfEsp != null ? !noOfEsp.equals(that.noOfEsp) : that.noOfEsp != null) return false;
        if (yearOfStudy != null ? !yearOfStudy.equals(that.yearOfStudy) : that.yearOfStudy != null) return false;
        if (semester != that.semester) return false;
        return professors != null ? professors.equals(that.professors) : that.professors == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (noOfEsp != null ? noOfEsp.hashCode() : 0);
        result = 31 * result + (yearOfStudy != null ? yearOfStudy.hashCode() : 0);
        result = 31 * result + (semester != null ? semester.hashCode() : 0);
        result = 31 * result + (professors != null ? professors.hashCode() : 0);
        return result;
    }
}
