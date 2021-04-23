package it.engineering.marjanjovanovicbe.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "city")
public class CityEntity {

    @Id
    @NotNull
    private String postalCode;

    @NotNull
    private String name;
}
