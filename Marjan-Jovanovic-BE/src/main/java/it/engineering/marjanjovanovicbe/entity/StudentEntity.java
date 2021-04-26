package it.engineering.marjanjovanovicbe.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "student")
public class StudentEntity extends PersonEntity implements Serializable {

    @Column(columnDefinition = "varchar(4)", nullable = false, unique = true)
    private String indexNumber;

    @Column(columnDefinition = "varchar(4)", nullable = false, unique = true)
    private String indexYear;

    @Column(columnDefinition = "bigint(7)", nullable = false, unique = false)
    private Long currentYearOfStudy;

    @ManyToMany
    @JoinTable(name = "student_exam", joinColumns = @JoinColumn(name = "exam_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<StudentEntity> exams;

    public StudentEntity() {
    }

    public StudentEntity(Long id, String firstName, String lastName, String email, String address, CityEntity city, String indexNumber, String indexYear, Long currentYearOfStudy, List<StudentEntity> exams) {
        super(id, firstName, lastName, email, address, city);
        this.indexNumber = indexNumber;
        this.indexYear = indexYear;
        this.currentYearOfStudy = currentYearOfStudy;
        this.exams = exams;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getIndexYear() {
        return indexYear;
    }

    public void setIndexYear(String indexYear) {
        this.indexYear = indexYear;
    }

    public Long getCurrentYearOfStudy() {
        return currentYearOfStudy;
    }

    public void setCurrentYearOfStudy(Long currentYearOfStudy) {
        this.currentYearOfStudy = currentYearOfStudy;
    }

    public List<StudentEntity> getExams() {
        return exams;
    }

    public void setExams(List<StudentEntity> exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "indexNumber='" + indexNumber + '\'' +
                ", indexYear='" + indexYear + '\'' +
                ", currentYearOfStudy=" + currentYearOfStudy +
                ", exams=" + exams +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentEntity)) return false;
        if (!super.equals(o)) return false;

        StudentEntity that = (StudentEntity) o;

        if (indexNumber != null ? !indexNumber.equals(that.indexNumber) : that.indexNumber != null) return false;
        if (indexYear != null ? !indexYear.equals(that.indexYear) : that.indexYear != null) return false;
        if (currentYearOfStudy != null ? !currentYearOfStudy.equals(that.currentYearOfStudy) : that.currentYearOfStudy != null)
            return false;
        return exams != null ? exams.equals(that.exams) : that.exams == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (indexNumber != null ? indexNumber.hashCode() : 0);
        result = 31 * result + (indexYear != null ? indexYear.hashCode() : 0);
        result = 31 * result + (currentYearOfStudy != null ? currentYearOfStudy.hashCode() : 0);
        result = 31 * result + (exams != null ? exams.hashCode() : 0);
        return result;
    }
}
