package it.engineering.marjanjovanovicbe.entity;

import it.engineering.marjanjovanovicbe.util.Semester;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "subject")
public class SubjectEntity {

    @Id
    @NotNull
    private String id;

    private String name;

    private String description;

    private Long noOfEsp;

    @Enumerated (EnumType.STRING)
    private Semester semester;
}
