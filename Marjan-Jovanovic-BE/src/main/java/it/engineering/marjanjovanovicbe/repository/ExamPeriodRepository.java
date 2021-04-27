package it.engineering.marjanjovanovicbe.repository;

import it.engineering.marjanjovanovicbe.entity.ExamPeriodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamPeriodRepository extends JpaRepository<ExamPeriodEntity, Long> {
}
