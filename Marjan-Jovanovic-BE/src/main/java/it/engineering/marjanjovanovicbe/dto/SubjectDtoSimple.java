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
}
