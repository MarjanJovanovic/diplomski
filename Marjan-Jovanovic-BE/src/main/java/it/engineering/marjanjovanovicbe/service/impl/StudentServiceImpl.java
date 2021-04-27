package it.engineering.marjanjovanovicbe.service.impl;

import it.engineering.marjanjovanovicbe.dto.StudentDto;
import it.engineering.marjanjovanovicbe.entity.StudentEntity;
import it.engineering.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.engineering.marjanjovanovicbe.exception.MyEntityNotFoundException;
import it.engineering.marjanjovanovicbe.mapper.StudentMapper;
import it.engineering.marjanjovanovicbe.repository.StudentRepository;
import it.engineering.marjanjovanovicbe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public Optional<StudentDto> findById(Long studentId) {
    Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
    if (studentEntity.isPresent()){
        return Optional.of(studentMapper.toDto(studentEntity.get()));
    }
    return Optional.empty();
    }

    @Override
    public StudentDto save(StudentDto studentDto) throws MyEntityAlreadyExistsException{
        Optional<StudentEntity> entity = studentRepository.findById(studentDto.getId());
        if (entity.isPresent()){
            throw new MyEntityAlreadyExistsException("Student already exists: ", studentMapper.toDto(entity.get()));
        }
        StudentEntity studentEntity = studentRepository.save(studentMapper.toEntity(studentDto));
        return studentMapper.toDto(studentEntity);
    }

    @Override
    public Optional<StudentDto> update(StudentDto studentDto) throws MyEntityNotFoundException{
        Optional<StudentEntity> entity = studentRepository.findById(studentDto.getId());
        if (entity.isPresent()){
            StudentEntity studentEntity = studentRepository.save(studentMapper.toEntity(studentDto));
            return Optional.of(studentMapper.toDto(studentEntity));
        }else{
            throw new MyEntityNotFoundException("Student doesn't exist!");
        }
    }

    @Override
    public void delete(Long studentId) throws MyEntityNotFoundException {
        Optional<StudentEntity> entity = studentRepository.findById(studentId);
        if (entity.isPresent()){
            studentRepository.delete(entity.get());
        }else{
            throw new MyEntityNotFoundException("Student with id: " + studentId + " doesn't exist.");
        }

    }

    @Override
    public List<StudentDto> getAll() {
        List<StudentEntity> entities = studentRepository.findAll();
        return entities.stream().map(entity -> {
            return studentMapper.toDto(entity);
        }).collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getAll(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<StudentEntity> pageResult = studentRepository.findAll(pageable);
        if (pageResult.hasContent()){
            List<StudentEntity> subjects = pageResult.getContent();
            return subjects.stream().map(entity -> {
                return studentMapper.toDto(entity);
            }).collect(Collectors.toList());
        }
        return new ArrayList<StudentDto>();
    }
}
