package it.marjanjovanovicbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamDtoSimple implements MyDto{

    private Long id;
    private ExamPeriodDtoSimple examPeriodDto;
    private SubjectDtoSimple subject;
    private ProfessorDtoSimple professor;
    private LocalDate date;

}
