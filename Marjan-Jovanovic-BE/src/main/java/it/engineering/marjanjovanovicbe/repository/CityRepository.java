package it.engineering.marjanjovanovicbe.repository;

import it.engineering.marjanjovanovicbe.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
}
