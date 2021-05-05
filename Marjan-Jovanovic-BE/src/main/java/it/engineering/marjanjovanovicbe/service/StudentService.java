package it.engineering.marjanjovanovicbe.service;

import it.engineering.marjanjovanovicbe.dto.ExamDtoIdOnly;
import it.engineering.marjanjovanovicbe.dto.StudentDto;
import it.engineering.marjanjovanovicbe.dto.StudentDtoWithExamRegistration;
import it.engineering.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.engineering.marjanjovanovicbe.exception.MyEntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Optional<StudentDto> findById(Long studentId);
    StudentDto save(StudentDto studentDto) throws MyEntityAlreadyExistsException;
    Optional<StudentDto> update(StudentDto studentDto) throws MyEntityNotFoundException;
    void delete(Long studentId) throws MyEntityNotFoundException;
    List<StudentDto> getAll();
    List<StudentDto> getAll(int pageNo, int pageSize, String sortBy);
    StudentDtoWithExamRegistration registerExam(StudentDtoWithExamRegistration studentDtoWithExamRegistration) throws MyEntityNotFoundException;
}
