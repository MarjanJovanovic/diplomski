package it.engineering.marjanjovanovicbe.service;

import it.engineering.marjanjovanovicbe.dto.SubjectDto;
import it.engineering.marjanjovanovicbe.dto.SubjectDtoWithoutId;
import it.engineering.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.engineering.marjanjovanovicbe.exception.MyEntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    Optional<SubjectDto> findById(Long subjectId);
    SubjectDto save(SubjectDtoWithoutId subjectDto) throws MyEntityAlreadyExistsException;
    Optional<SubjectDto> update(SubjectDto subjectDto) throws MyEntityNotFoundException;
    void delete(Long subjectId) throws MyEntityNotFoundException;
    List<SubjectDto> getAll();
//    List<SubjectDto> getAll(int pageNo, int pageSize, String sortBy);
    Page<SubjectDto> getAll(Pageable pageable);

}
