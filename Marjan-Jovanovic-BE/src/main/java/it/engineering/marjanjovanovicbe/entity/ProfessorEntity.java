package it.engineering.marjanjovanovicbe.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "professor")
public class ProfessorEntity extends PersonEntity implements Serializable {


    @Column(columnDefinition = "varchar(15)", nullable = false, unique = false)
    private String phone;

    @Column(columnDefinition = "date", nullable = false, unique = false)
    private LocalDate reelectionDate;

    @ManyToOne
    @JoinColumn(name = "title_id")
    private TitleEntity title;

    @ManyToMany
    @JoinTable(name = "subject_professor", joinColumns = @JoinColumn(name = "professor_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<SubjectEntity> subjects;
}
