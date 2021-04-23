package it.engineering.marjanjovanovicbe.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "professor")
public class ProfessorEntity extends PersonEntity implements Serializable {

    private String Phone;

    private Date reelectionDate;

    @ManyToOne
    private TitleEntity title;
}
