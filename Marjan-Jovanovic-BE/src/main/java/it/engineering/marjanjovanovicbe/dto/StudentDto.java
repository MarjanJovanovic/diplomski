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
}
