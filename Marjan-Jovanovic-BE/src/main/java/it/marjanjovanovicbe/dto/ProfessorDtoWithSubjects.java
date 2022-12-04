package it.marjanjovanovicbe.dto;

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

    @Override
    public String toString() {
        return "ProfessorDtoWithSubjects{" +
                "phone='" + phone + '\'' +
                ", reelectionDate=" + reelectionDate +
                ", title=" + title +
                ", subjects=" + subjects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfessorDtoWithSubjects)) return false;
        if (!super.equals(o)) return false;

        ProfessorDtoWithSubjects that = (ProfessorDtoWithSubjects) o;

        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (reelectionDate != null ? !reelectionDate.equals(that.reelectionDate) : that.reelectionDate != null)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return subjects != null ? subjects.equals(that.subjects) : that.subjects == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (reelectionDate != null ? reelectionDate.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (subjects != null ? subjects.hashCode() : 0);
        return result;
    }
}
