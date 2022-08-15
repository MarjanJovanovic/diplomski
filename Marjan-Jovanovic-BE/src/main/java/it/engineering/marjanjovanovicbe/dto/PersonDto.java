package it.engineering.marjanjovanovicbe.dto;

import it.engineering.marjanjovanovicbe.entity.CityEntity;

import javax.persistence.*;

public abstract class PersonDto implements MyDto{

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private CityDto city;

    public PersonDto() {
    }

    public PersonDto(Long id){
        this.id = id;
    }

    public PersonDto(Long id, String firstName, String lastName, String email, String address, CityDto city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CityDto getCity() {
        return city;
    }

    public void setCity(CityDto city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city=" + city +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDto)) return false;

        PersonDto personDto = (PersonDto) o;

        if (id != null ? !id.equals(personDto.id) : personDto.id != null) return false;
        if (firstName != null ? !firstName.equals(personDto.firstName) : personDto.firstName != null) return false;
        if (lastName != null ? !lastName.equals(personDto.lastName) : personDto.lastName != null) return false;
        if (email != null ? !email.equals(personDto.email) : personDto.email != null) return false;
        if (address != null ? !address.equals(personDto.address) : personDto.address != null) return false;
        return city != null ? city.equals(personDto.city) : personDto.city == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
