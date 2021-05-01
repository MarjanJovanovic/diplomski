package it.engineering.marjanjovanovicbe.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class StudentDtoWithExams extends PersonDto{

    private String indexNumber;
    private String indexYear;
    private Long currentYearOfStudy;
    private List<ExamDto> exams;

    public StudentDtoWithExams() {
    }

    public StudentDtoWithExams(Long id, String firstName, String lastName, String email, String address, CityDto city, String indexNumber, String indexYear, Long currentYearOfStudy, List<ExamDto> exams) {
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

    public List<ExamDto> getExams() {
        return exams;
    }

    public void setExams(List<ExamDto> exams) {
        this.exams = exams;
    }
}
