package it.engineering.marjanjovanovicbe.repository;

import it.engineering.marjanjovanovicbe.entity.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<ExamEntity, Long> {
}
