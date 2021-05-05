package it.engineering.marjanjovanovicbe.dto;

public class PersonDtoIdOnly {

    private Long id;

    public PersonDtoIdOnly() {
    }

    public PersonDtoIdOnly(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PersonDtoIdOnly{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDtoIdOnly)) return false;

        PersonDtoIdOnly that = (PersonDtoIdOnly) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
