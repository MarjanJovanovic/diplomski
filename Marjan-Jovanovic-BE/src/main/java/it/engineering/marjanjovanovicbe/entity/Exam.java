package it.engineering.marjanjovanovicbe.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "exam")
public class Exam {

    @Id
    private Long id;

    @ManyToOne
    private ExamPeriod examPeriod;

    @ManyToOne
    private SubjectEntity subject;

    @ManyToOne
    private ProfessorEntity professor; //Professor has to be working on the selected subject

    private Date date;
}
