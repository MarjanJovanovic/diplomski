package it.engineering.marjanjovanovicbe.entity;

import it.engineering.marjanjovanovicbe.util.TitleName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "title")
public class TitleEntity {


    @Id
    @Column(columnDefinition = "bigint(7)", nullable = false, unique = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(30)", nullable = false, unique = true)
    private TitleName title;
}
