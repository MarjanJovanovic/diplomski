package it.engineering.marjanjovanovicbe.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "exam_period")
public class ExamPeriod {

    @Id
    private Long id;

    private String name;

    private Date startDate;

    private Date endDate;

    private boolean isActive;
}
