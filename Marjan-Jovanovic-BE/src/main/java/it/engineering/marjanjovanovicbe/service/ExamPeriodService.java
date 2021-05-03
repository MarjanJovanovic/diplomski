package it.engineering.marjanjovanovicbe.service;

import it.engineering.marjanjovanovicbe.dto.ExamPeriodDto;
import it.engineering.marjanjovanovicbe.entity.ExamPeriodEntity;
import it.engineering.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.engineering.marjanjovanovicbe.exception.MyEntityInvalidParamException;
import it.engineering.marjanjovanovicbe.exception.MyEntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ExamPeriodService {
    Optional<ExamPeriodDto> findById(Long examPeriodId);
    ExamPeriodDto save(ExamPeriodDto examPeriodDto) throws MyEntityAlreadyExistsException, MyEntityInvalidParamException;
    Optional<ExamPeriodDto> update(ExamPeriodDto examPeriodDto) throws MyEntityNotFoundException, MyEntityInvalidParamException;
    void delete(Long examPeriodId) throws MyEntityNotFoundException;
    List<ExamPeriodDto> getAll();
    List<ExamPeriodDto> getAll(int pageNo, int pageSize, String sortBy);
    boolean validateExamPeriodDates(ExamPeriodEntity examPeriodEntity);
}
