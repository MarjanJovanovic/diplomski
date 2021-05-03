package it.engineering.marjanjovanovicbe.repository;

import it.engineering.marjanjovanovicbe.dto.ExamPeriodDto;
import it.engineering.marjanjovanovicbe.entity.ExamPeriodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExamPeriodRepository extends JpaRepository<ExamPeriodEntity, Long> {

    List<ExamPeriodEntity> findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(
            LocalDate examPeriodStart,
            LocalDate examPeriodEnd);
    // between
    List<ExamPeriodEntity> findAllByStartDateLessThanEqualAndEndDateLessThanEqual(
            LocalDate examPeriodStart,
            LocalDate examPeriodEnd);
    //first before, second between
    List<ExamPeriodEntity> findAllByStartDateGreaterThanEqualAndEndDateGreaterThanEqual(
            LocalDate examPeriodStart,
            LocalDate examPeriodEnd);
    //first between, second after
    List<ExamPeriodEntity> findAllByStartDateGreaterThanEqualAndEndDateLessThanEqual(
            LocalDate examPeriodStart,
            LocalDate examPeriodEnd);
    //around
}
