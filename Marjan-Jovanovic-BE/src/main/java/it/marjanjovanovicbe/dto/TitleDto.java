package it.marjanjovanovicbe.dto;

import it.marjanjovanovicbe.util.TitleName;


public class TitleDto {

    private Long id;
    private TitleName title;

    public TitleDto() {
    }

    public TitleDto(Long id, TitleName title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "TitleDto{" +
                "id=" + id +
                ", title=" + title +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TitleDto)) return false;

        TitleDto titleDto = (TitleDto) o;

        if (id != null ? !id.equals(titleDto.id) : titleDto.id != null) return false;
        return title == titleDto.title;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}

