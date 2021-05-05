package it.engineering.marjanjovanovicbe.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "student")
public class StudentEntity extends PersonEntity implements Serializable {

    @Size(min = 4, max = 4)
    @NotNull
    @Column(columnDefinition = "varchar(4)", nullable = false, unique = true)
    private String indexNumber;

    @Min(2000)
    @Max(2100)
    @NotNull
    @Column(columnDefinition = "varchar(4)", nullable = false, unique = true)
    private String indexYear;

    @NotNull
    @Column(columnDefinition = "bigint(7)", nullable = false, unique = false)
    private Long currentYearOfStudy;

    @ManyToMany
    @JoinTable(name = "student_exam", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "exam_id"))
    private List<ExamEntity> exams;

    public StudentEntity() {
    }

    public StudentEntity(Long id, String firstName, String lastName, String email, String address, CityEntity city, String indexNumber, String indexYear, Long currentYearOfStudy, List<ExamEntity> exams) {
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

    public List<ExamEntity> getExams() {
        return exams;
    }

    public void setExams(List<ExamEntity> exams) {
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
