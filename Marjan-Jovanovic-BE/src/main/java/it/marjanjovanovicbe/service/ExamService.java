package it.marjanjovanovicbe.service;

import it.marjanjovanovicbe.dto.ExamDto;
import it.marjanjovanovicbe.dto.ExamDtoSimple;
import it.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.marjanjovanovicbe.exception.MyEntityInvalidParamException;
import it.marjanjovanovicbe.exception.MyEntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ExamService {
    Optional<ExamDto> findById(Long subjectId);
    ExamDto save(ExamDtoSimple examDto) throws MyEntityAlreadyExistsException, MyEntityInvalidParamException;
    Optional<ExamDto> update(ExamDto examDto) throws MyEntityNotFoundException;
    void delete(Long examId) throws MyEntityNotFoundException;
    List<ExamDto> getAll();
//    List<ExamDto> getAll(int pageNo, int pageSize, String sortBy);
    Page<ExamDto> getAll(Pageable pageable);
}
