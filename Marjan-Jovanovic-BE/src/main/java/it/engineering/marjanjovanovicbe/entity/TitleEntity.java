package it.engineering.marjanjovanovicbe.entity;

import it.engineering.marjanjovanovicbe.util.TitleName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "title")
public class TitleEntity {


    @Id
    @Column(columnDefinition = "bigint(7)", nullable = false, unique = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(30)", nullable = false, unique = true)
    private TitleName title;

    public TitleEntity() {
    }

    public TitleEntity(String id, TitleName title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TitleName getTitle() {
        return title;
    }

    public void setTitle(TitleName title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "TitleEntity{" +
                "id='" + id + '\'' +
                ", title=" + title +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TitleEntity)) return false;

        TitleEntity that = (TitleEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return title == that.title;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
