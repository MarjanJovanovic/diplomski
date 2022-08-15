package it.engineering.marjanjovanovicbe.dto;

public class ExamPeriodDtoSimple implements MyDto{

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExamPeriodDtoSimple)) return false;

        ExamPeriodDtoSimple that = (ExamPeriodDtoSimple) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
