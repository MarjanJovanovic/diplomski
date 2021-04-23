package it.engineering.marjanjovanovicbe.entity;

import it.engineering.marjanjovanovicbe.util.TitleName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "title")
public class TitleEntity {


    @Id
    @NotNull
    private String id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TitleName title;
}
