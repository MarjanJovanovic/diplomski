package it.engineering.marjanjovanovicbe.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.engineering.marjanjovanovicbe.entity.CityEntity;

import java.util.List;

public class StudentDto extends PersonDto{

    private String indexNumber;
    private String indexYear;
    private Long currentYearOfStudy;

    public StudentDto() {
    }

    public StudentDto(Long id, String firstName, String lastName, String email, String address, CityDto city, String indexNumber, String indexYear, Long currentYearOfStudy) {
        super(id, firstName, lastName, email, address, city);
        this.indexNumber = indexNumber;
        this.indexYear = indexYear;
        this.currentYearOfStudy = currentYearOfStudy;
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

    @Override
    public String toString() {
        return "StudentDto{" +
                "indexNumber='" + indexNumber + '\'' +
                ", indexYear='" + indexYear + '\'' +
                ", currentYearOfStudy=" + currentYearOfStudy +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentDto)) return false;
        if (!super.equals(o)) return false;

        StudentDto that = (StudentDto) o;

        if (indexNumber != null ? !indexNumber.equals(that.indexNumber) : that.indexNumber != null) return false;
        if (indexYear != null ? !indexYear.equals(that.indexYear) : that.indexYear != null) return false;
        return currentYearOfStudy != null ? currentYearOfStudy.equals(that.currentYearOfStudy) : that.currentYearOfStudy == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (indexNumber != null ? indexNumber.hashCode() : 0);
        result = 31 * result + (indexYear != null ? indexYear.hashCode() : 0);
        result = 31 * result + (currentYearOfStudy != null ? currentYearOfStudy.hashCode() : 0);
        return result;
    }
}
