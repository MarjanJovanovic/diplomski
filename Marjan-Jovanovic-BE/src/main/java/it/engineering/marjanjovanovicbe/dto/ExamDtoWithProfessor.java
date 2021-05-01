package it.engineering.marjanjovanovicbe.dto;

import java.time.LocalDate;
import java.util.List;

public class ExamDtoWithProfessor implements MyDto{

    private Long id;
    private ExamPeriodDto examPeriodDto;
    private SubjectDto subject;
    private ProfessorDto professor;
    private List<StudentDto> students;
    private LocalDate date;

    public ExamDtoWithProfessor() {
    }

    public ExamDtoWithProfessor(Long id, ExamPeriodDto examPeriodDto, SubjectDto subject, ProfessorDto professor, List<StudentDto> students, LocalDate date) {
        this.id = id;
        this.examPeriodDto = examPeriodDto;
        this.subject = subject;
        this.professor = professor;
        this.students = students;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
