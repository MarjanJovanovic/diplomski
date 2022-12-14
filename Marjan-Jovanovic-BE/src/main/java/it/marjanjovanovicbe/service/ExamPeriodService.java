package it.marjanjovanovicbe.service;

import it.marjanjovanovicbe.dto.ExamPeriodDto;
import it.marjanjovanovicbe.entity.ExamPeriodEntity;
import it.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.marjanjovanovicbe.exception.MyEntityInvalidParamException;
import it.marjanjovanovicbe.exception.MyEntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ExamPeriodService {
    Optional<ExamPeriodDto> findById(Long examPeriodId);
    ExamPeriodDto save(ExamPeriodDto examPeriodDto) throws MyEntityAlreadyExistsException, MyEntityInvalidParamException;
    Optional<ExamPeriodDto> update(ExamPeriodDto examPeriodDto) throws MyEntityNotFoundException, MyEntityInvalidParamException;
    void delete(Long examPeriodId) throws MyEntityNotFoundException;
    List<ExamPeriodDto> getAll();
//    List<ExamPeriodDto> getAll(int pageNo, int pageSize, String sortBy);
    Page<ExamPeriodDto> getAll(Pageable pageable);
    boolean validateExamPeriodDates(ExamPeriodEntity examPeriodEntity);
}
