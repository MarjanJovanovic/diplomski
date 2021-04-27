package it.engineering.marjanjovanovicbe.dto;

import java.time.LocalDate;

public class ExamPeriodDto implements MyDto{

    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isActive;


}
