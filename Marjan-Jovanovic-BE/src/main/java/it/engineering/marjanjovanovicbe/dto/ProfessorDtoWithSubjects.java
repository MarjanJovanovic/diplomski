package it.engineering.marjanjovanovicbe.dto;

import java.time.LocalDate;
import java.util.List;

public class ProfessorDtoWithSubjects extends PersonDto {

    private String phone;
    private LocalDate reelectionDate;
    private TitleDto title;
    private List<SubjectDto> subjects;

    public ProfessorDtoWithSubjects() {
    }

    public ProfessorDtoWithSubjects(Long id, String firstName, String lastName, String email, String address, CityDto city, String phone, LocalDate reelectionDate, TitleDto title, List<SubjectDto> subjects) {
        super(id, firstName, lastName, email, address, city);
        this.phone = phone;
        this.reelectionDate = reelectionDate;
        this.title = title;
        this.subjects = subjects;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getReelectionDate() {
        return reelectionDate;
    }

    public void setReelectionDate(LocalDate reelectionDate) {
        this.reelectionDate = reelectionDate;
    }

    public TitleDto getTitle() {
        return title;
    }

    public void setTitle(TitleDto title) {
        this.title = title;
    }

    public List<SubjectDto> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDto> subjects) {
        this.subjects = subjects;
    }
}
