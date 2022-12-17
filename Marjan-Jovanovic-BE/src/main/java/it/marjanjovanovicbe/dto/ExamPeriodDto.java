package it.marjanjovanovicbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamPeriodDto implements MyDto{

    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isActive;

}
