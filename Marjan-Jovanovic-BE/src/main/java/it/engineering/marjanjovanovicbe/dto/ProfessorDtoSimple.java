package it.engineering.marjanjovanovicbe.dto;

public class ProfessorDtoSimple {

    private Long id;

    public ProfessorDtoSimple() {
    }

    public ProfessorDtoSimple(Long id) {
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
        return "ProfessorDtoSimple{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfessorDtoSimple)) return false;

        ProfessorDtoSimple that = (ProfessorDtoSimple) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
