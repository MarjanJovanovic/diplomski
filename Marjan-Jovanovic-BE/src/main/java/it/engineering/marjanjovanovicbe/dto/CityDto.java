package it.engineering.marjanjovanovicbe.dto;

public class CityDto {

    private Long postalCode;
    private String name;

    public CityDto() {
    }

    public CityDto(Long postalCode, String name) {
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
        return "CityDto{" +
                "postalCode=" + postalCode +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CityDto)) return false;

        CityDto cityDto = (CityDto) o;

        if (postalCode != null ? !postalCode.equals(cityDto.postalCode) : cityDto.postalCode != null) return false;
        return name != null ? name.equals(cityDto.name) : cityDto.name == null;
    }

    @Override
    public int hashCode() {
        int result = postalCode != null ? postalCode.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
