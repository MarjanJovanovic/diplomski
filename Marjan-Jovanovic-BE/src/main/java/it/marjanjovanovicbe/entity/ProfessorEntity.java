package it.marjanjovanovicbe.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "professor")
public class ProfessorEntity extends PersonEntity implements Serializable {

    @Size(min = 9)
    @NotNull
    @Column(columnDefinition = "varchar(15)", nullable = false, unique = false)
    private String phone;

    @NotNull
    @Column(columnDefinition = "date", nullable = false, unique = false)
    private LocalDate reelectionDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "title_id")
    private TitleEntity title;


    @ManyToMany
    @JoinTable(name = "subject_professor", joinColumns = @JoinColumn(name = "professor_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<SubjectEntity> subjects;

    public ProfessorEntity() {
    }

    public ProfessorEntity(Long id, String firstName, String lastName, String email, String address, CityEntity city, String phone, LocalDate reelectionDate, TitleEntity title, List<SubjectEntity> subjects) {
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
        return "ProfessorEntity{" +
                "phone='" + phone + '\'' +
                ", reelectionDate=" + reelectionDate +
                ", title=" + title +
                ", subjects=" + subjects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfessorEntity)) return false;
        if (!super.equals(o)) return false;

        ProfessorEntity that = (ProfessorEntity) o;

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
