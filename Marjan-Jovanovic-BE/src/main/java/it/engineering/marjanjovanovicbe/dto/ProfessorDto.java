package it.engineering.marjanjovanovicbe.dto;
import java.time.LocalDate;

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

    @Override
    public String toString() {
        return "ProfessorDto{" +
                "phone='" + phone + '\'' +
                ", reelectionDate=" + reelectionDate +
                ", title=" + title +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfessorDto)) return false;
        if (!super.equals(o)) return false;

        ProfessorDto that = (ProfessorDto) o;

        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (reelectionDate != null ? !reelectionDate.equals(that.reelectionDate) : that.reelectionDate != null)
            return false;
        return title != null ? title.equals(that.title) : that.title == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (reelectionDate != null ? reelectionDate.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
