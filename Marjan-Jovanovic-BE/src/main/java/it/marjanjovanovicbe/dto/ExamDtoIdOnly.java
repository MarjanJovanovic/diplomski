package it.marjanjovanovicbe.dto;

public class ExamDtoIdOnly implements MyDto{
    private Long id;

    public ExamDtoIdOnly() {
    }

    public ExamDtoIdOnly(Long id) {
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
        return "ExamDtoIdOnly{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExamDtoIdOnly)) return false;

        ExamDtoIdOnly that = (ExamDtoIdOnly) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
