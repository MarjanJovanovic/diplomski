package it.engineering.marjanjovanovicbe.repository;

import it.engineering.marjanjovanovicbe.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}
