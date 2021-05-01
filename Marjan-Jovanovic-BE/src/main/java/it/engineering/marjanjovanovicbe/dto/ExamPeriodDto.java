package it.engineering.marjanjovanovicbe.dto;

import java.time.LocalDate;

public class ExamPeriodDto implements MyDto{

    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isActive;

    public ExamPeriodDto() {
    }

    public ExamPeriodDto(Long id, String name, LocalDate startDate, LocalDate endDate, boolean isActive) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
