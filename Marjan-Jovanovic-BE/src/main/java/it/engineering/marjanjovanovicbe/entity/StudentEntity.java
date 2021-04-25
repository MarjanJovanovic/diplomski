package it.engineering.marjanjovanovicbe.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class StudentEntity extends PersonEntity implements Serializable {

    @Column(columnDefinition = "varchar(4)", nullable = false, unique = true)
    private String indexNumber;

    @Column(columnDefinition = "varchar(4)", nullable = false, unique = true)
    private String indexYear;

    @Column(columnDefinition = "bigint(7)", nullable = false, unique = false)
    private Long currentYearOfStudy;


}
