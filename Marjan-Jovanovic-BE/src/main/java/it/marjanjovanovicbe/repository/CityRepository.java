package it.marjanjovanovicbe.repository;

import it.marjanjovanovicbe.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
}
