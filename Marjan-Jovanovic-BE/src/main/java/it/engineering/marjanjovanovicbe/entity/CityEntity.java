package it.engineering.marjanjovanovicbe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "city")
public class CityEntity {

    @Id
    @Column(columnDefinition = "bigint(5)", nullable = false, unique = true)
    private Long postalCode;

    @Column(columnDefinition = "varchar(30)", nullable = false, unique = true)
    private String name;

    public CityEntity() {
    }

    public CityEntity(Long postalCode, String name) {
        this.postalCode = postalCode;
        this.name = name;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "postalCode=" + postalCode +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CityEntity)) return false;

        CityEntity that = (CityEntity) o;

        if (postalCode != null ? !postalCode.equals(that.postalCode) : that.postalCode != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = postalCode != null ? postalCode.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
