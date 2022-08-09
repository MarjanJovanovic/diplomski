package it.engineering.marjanjovanovicbe.service;

import it.engineering.marjanjovanovicbe.dto.CityDto;
import it.engineering.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.engineering.marjanjovanovicbe.exception.MyEntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CityService {
    Optional<CityDto> findById(Long cityCode);
    CityDto save(CityDto cityDto) throws MyEntityAlreadyExistsException;
    Optional<CityDto> update(CityDto cityDto) throws MyEntityNotFoundException;
    void delete(Long cityCode) throws MyEntityNotFoundException;
    List<CityDto> getAll();
    //    List<SubjectDto> getAll(int pageNo, int pageSize, String sortBy);
    Page<CityDto> getAll(Pageable pageable);
}
