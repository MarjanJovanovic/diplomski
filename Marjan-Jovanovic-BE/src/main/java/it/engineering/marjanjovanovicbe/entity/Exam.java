package it.engineering.marjanjovanovicbe.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ExamPeriod examPeriod;

    @ManyToOne
    private SubjectEntity subject;

    @ManyToOne
    private ProfessorEntity professor; //Professor has to be working on the selected subject

    private LocalDate date;
}
