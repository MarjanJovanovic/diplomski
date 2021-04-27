package it.engineering.marjanjovanovicbe.dto;

import it.engineering.marjanjovanovicbe.entity.ExamPeriodEntity;
import it.engineering.marjanjovanovicbe.entity.ProfessorEntity;
import it.engineering.marjanjovanovicbe.entity.StudentEntity;
import it.engineering.marjanjovanovicbe.entity.SubjectEntity;

import java.time.LocalDate;
import java.util.List;

public class ExamDto implements MyDto{

    private Long id;
    private ExamPeriodEntity examPeriodEntity;
    private SubjectEntity subject;
    private ProfessorEntity professor;
    private List<StudentEntity> students;
    private LocalDate date;
}
