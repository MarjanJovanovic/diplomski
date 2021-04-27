package it.engineering.marjanjovanovicbe.service;

import it.engineering.marjanjovanovicbe.dto.ProfessorDto;
import it.engineering.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.engineering.marjanjovanovicbe.exception.MyEntityInvalidParamException;
import it.engineering.marjanjovanovicbe.exception.MyEntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ProfessorService {
    Optional<ProfessorDto> findById(Long professorId);
    ProfessorDto save(ProfessorDto professorDto) throws MyEntityAlreadyExistsException;
    Optional<ProfessorDto> update(ProfessorDto professorDto) throws MyEntityNotFoundException;
    void delete(Long professorId) throws MyEntityNotFoundException;
    List<ProfessorDto> getAll();
    List<ProfessorDto> getAll(int pageNo, int pageSize, String sortBy);
}
