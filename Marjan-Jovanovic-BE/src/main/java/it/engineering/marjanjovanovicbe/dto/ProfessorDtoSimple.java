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
}
