package it.engineering.marjanjovanovicbe.dto;


import java.time.LocalDate;
import java.util.List;

public class ProfessorDto extends PersonDto{

    private String phone;
    private LocalDate reelectionDate;
    private TitleDto title;

    public ProfessorDto() {
    }

    public ProfessorDto(Long id, String firstName, String lastName, String email, String address, CityDto city, String phone, LocalDate reelectionDate, TitleDto title) {
        super(id, firstName, lastName, email, address, city);
        this.phone = phone;
        this.reelectionDate = reelectionDate;
        this.title = title;
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
}
