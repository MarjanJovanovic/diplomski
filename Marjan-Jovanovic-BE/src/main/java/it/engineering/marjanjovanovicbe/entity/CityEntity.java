package it.engineering.marjanjovanovicbe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "city")
public class CityEntity {

    @Id
    @Column(columnDefinition = "bigint(5)", nullable = false, unique = true)
    private Long postalCode;

    @Column(columnDefinition = "varchar(30)", nullable = false, unique = true)
    private String name;



}
