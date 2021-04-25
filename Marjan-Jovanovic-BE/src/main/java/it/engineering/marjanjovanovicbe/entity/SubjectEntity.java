package it.engineering.marjanjovanovicbe.entity;

import it.engineering.marjanjovanovicbe.util.Semester;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "subject")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(30)", nullable = false, unique = false)
    private String name;

    @Column(columnDefinition = "varchar(200)", nullable = true, unique = false)
    private String description;

    @Column(columnDefinition = "bigint(1)", nullable = false, unique = false)
    private Long noOfEsp;

    @Column(columnDefinition = "bigint(1)", nullable = false, unique = false)
    private Long YearOfStudy;

    @Enumerated (EnumType.STRING)
    @Column(columnDefinition = "varchar(10)", nullable = false, unique = false)
    private Semester semester;

    @ManyToMany
    @JoinTable(name = "subject_professor", joinColumns = @JoinColumn(name = "subject_id"), inverseJoinColumns = @JoinColumn(name = "professor_id"))
    private List<ProfessorEntity> professors;
}
