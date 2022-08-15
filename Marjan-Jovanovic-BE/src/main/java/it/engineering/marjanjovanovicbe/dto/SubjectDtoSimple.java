package it.engineering.marjanjovanovicbe.dto;

public class SubjectDtoSimple {
    private Long id;

    public SubjectDtoSimple() {
    }

    public SubjectDtoSimple(Long id) {
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
        return "SubjectDtoSimple{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectDtoSimple)) return false;

        SubjectDtoSimple that = (SubjectDtoSimple) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
