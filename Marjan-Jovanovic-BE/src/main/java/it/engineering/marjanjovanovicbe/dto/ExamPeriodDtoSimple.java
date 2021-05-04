package it.engineering.marjanjovanovicbe.dto;

public class ExamPeriodDtoSimple {

    private Long id;

    public ExamPeriodDtoSimple() {
    }

    public ExamPeriodDtoSimple(Long id) {
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
        return "ExamPeriodDtoSimple{" +
                "id=" + id +
                '}';
    }
}
