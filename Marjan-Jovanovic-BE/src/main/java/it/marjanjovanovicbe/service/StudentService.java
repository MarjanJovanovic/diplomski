package it.marjanjovanovicbe.service;

import it.marjanjovanovicbe.dto.StudentDto;
import it.marjanjovanovicbe.dto.StudentDtoWithExamRegistration;
import it.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.marjanjovanovicbe.exception.MyEntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Optional<StudentDto> findById(Long studentId);
    StudentDto save(StudentDto studentDto) throws MyEntityAlreadyExistsException;
    Optional<StudentDto> update(StudentDto studentDto) throws MyEntityNotFoundException;
    void delete(Long studentId) throws MyEntityNotFoundException;
    List<StudentDto> getAll();
//    List<StudentDto> getAll(int pageNo, int pageSize, String sortBy);
    Page<StudentDto> getAll(Pageable pageable);
    StudentDtoWithExamRegistration registerExam(StudentDtoWithExamRegistration studentDtoWithExamRegistration) throws MyEntityNotFoundException;
}
