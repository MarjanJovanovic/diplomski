package it.engineering.marjanjovanovicbe.service;

import it.engineering.marjanjovanovicbe.dto.ExamDto;
import it.engineering.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.engineering.marjanjovanovicbe.exception.MyEntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ExamService {
    Optional<ExamDto> findById(Long subjectId);
    ExamDto save(ExamDto examDto) throws MyEntityAlreadyExistsException;
    Optional<ExamDto> update(ExamDto examDto) throws MyEntityNotFoundException;
    void delete(Long examId) throws MyEntityNotFoundException;
    List<ExamDto> getAll();
    List<ExamDto> getAll(int pageNo, int pageSize, String sortBy);
}
