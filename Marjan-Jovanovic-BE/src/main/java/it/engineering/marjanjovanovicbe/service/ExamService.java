package it.engineering.marjanjovanovicbe.service;

import it.engineering.marjanjovanovicbe.dto.ExamDto;
import it.engineering.marjanjovanovicbe.dto.ExamDtoSimple;
import it.engineering.marjanjovanovicbe.dto.SubjectDto;
import it.engineering.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.engineering.marjanjovanovicbe.exception.MyEntityInvalidParamException;
import it.engineering.marjanjovanovicbe.exception.MyEntityNotFoundException;
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
