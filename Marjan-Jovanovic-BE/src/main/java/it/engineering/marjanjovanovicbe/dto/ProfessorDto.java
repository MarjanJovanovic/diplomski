package it.engineering.marjanjovanovicbe.dto;

import it.engineering.marjanjovanovicbe.entity.CityEntity;
import it.engineering.marjanjovanovicbe.entity.SubjectEntity;
import it.engineering.marjanjovanovicbe.entity.TitleEntity;

import java.time.LocalDate;
import java.util.List;

public class ProfessorDto extends PersonDto{

    private String phone;
    private LocalDate reelectionDate;
    private TitleEntity title;
    private List<SubjectEntity> subjects;

    public ProfessorDto() {
    }

    public ProfessorDto(Long id, String firstName, String lastName, String email, String address, CityEntity city, String phone, LocalDate reelectionDate, TitleEntity title, List<SubjectEntity> subjects) {
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

    public TitleEntity getTitle() {
        return title;
    }

    public void setTitle(TitleEntity title) {
        this.title = title;
    }

    public List<SubjectEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectEntity> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "ProfessorDto{" +
                "phone='" + phone + '\'' +
                ", reelectionDate=" + reelectionDate +
                ", title=" + title +
                ", subjects=" + subjects +
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
