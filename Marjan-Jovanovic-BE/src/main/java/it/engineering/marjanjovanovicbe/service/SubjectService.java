package it.engineering.marjanjovanovicbe.service;

import it.engineering.marjanjovanovicbe.dto.SubjectDto;
import it.engineering.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.engineering.marjanjovanovicbe.exception.MyEntityInvalidParamException;
import it.engineering.marjanjovanovicbe.exception.MyEntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    Optional<SubjectDto> findById(Long subjectId);
    SubjectDto save(SubjectDto subjectDto) throws MyEntityAlreadyExistsException;
    Optional<SubjectDto> update(SubjectDto subjectDto) throws MyEntityNotFoundException;
    void delete(Long subjectId) throws MyEntityNotFoundException;
    List<SubjectDto> getAll();
    List<SubjectDto> getAll(int pageNo, int pageSize, String sortBy);

}
