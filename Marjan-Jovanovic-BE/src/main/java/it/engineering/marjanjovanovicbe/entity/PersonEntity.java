package it.engineering.marjanjovanovicbe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//@NoArgsConstructor
//@AllArgsConstructor
//@Data
@MappedSuperclass
public abstract class PersonEntity {
    @Id
    @NotNull
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String email;

    private String address;

    @ManyToOne
    @JoinColumn(name = "postalCode")
    private CityEntity city;
}
