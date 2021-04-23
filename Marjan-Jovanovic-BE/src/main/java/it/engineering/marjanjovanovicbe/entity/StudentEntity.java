package it.engineering.marjanjovanovicbe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "student")
public class StudentEntity extends PersonEntity implements Serializable {

    @Id
    @NotNull
    private String indexNumber;

    @NotNull
    private Long indexYear;




    @NotNull
    private Long currentYearOfStudy;


}
