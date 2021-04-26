package it.engineering.marjanjovanovicbe.service.impl;

import it.engineering.marjanjovanovicbe.dto.SubjectDto;
import it.engineering.marjanjovanovicbe.entity.SubjectEntity;
import it.engineering.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.engineering.marjanjovanovicbe.exception.MyEntityInvalidParamException;
import it.engineering.marjanjovanovicbe.exception.MyEntityNotFoundException;
import it.engineering.marjanjovanovicbe.mapper.SubjectMapper;
import it.engineering.marjanjovanovicbe.repository.SubjectRepository;
import it.engineering.marjanjovanovicbe.service.SubjectService;
import it.engineering.marjanjovanovicbe.util.Semester;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
    private SubjectRepository subjectRepository;
    private SubjectMapper subjectMapper;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository, SubjectMapper subjectMapper) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
    }

    @Override
    public Optional<SubjectDto> findById(Long subjectId) {
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);
        if (subjectEntity.isPresent()){
            return Optional.of(subjectMapper.toDto(subjectEntity.get()));
        }
        return Optional.empty();
    }

    @Override
    public SubjectDto save(SubjectDto subjectDto) throws MyEntityAlreadyExistsException, MyEntityInvalidParamException {
        Optional<SubjectEntity> entity = subjectRepository.findById(subjectDto.getId());
        if (entity.isPresent()){
            throw new MyEntityAlreadyExistsException("Subject already exists: ", subjectMapper.toDto(entity.get()));
        }
        if (subjectDto.getName().length() < 3){
            throw new MyEntityInvalidParamException("Name must have more than 2 characters");
        }
        if (!(EnumUtils.isValidEnum(Semester.class, subjectDto.getSemester().toString()))){
            throw new MyEntityInvalidParamException("Name must be: " + Arrays.toString(Semester.values()));
        }
        SubjectEntity subjectEntity = subjectRepository.save(subjectMapper.toEntity(subjectDto));
        return subjectMapper.toDto(subjectEntity);
    }

    @Override
    public Optional<SubjectDto> update(SubjectDto subjectDto) throws MyEntityNotFoundException, MyEntityInvalidParamException {
        Optional<SubjectEntity> entity = subjectRepository.findById(subjectDto.getId());
        if (subjectDto.getName().length() < 3){
            throw new MyEntityInvalidParamException("Name must have more than 2 characters");
        }
        if (!(EnumUtils.isValidEnum(Semester.class, subjectDto.getSemester().toString()))){
            throw new MyEntityInvalidParamException("Name must be: " + Arrays.toString(Semester.values()));
        }
        if (entity.isPresent()){
            SubjectEntity subjectEntity = subjectRepository.save(subjectMapper.toEntity(subjectDto));
            return Optional.of(subjectMapper.toDto(subjectEntity));
        }else{
            throw new MyEntityNotFoundException("Subject doesn't exist!");
        }

    }

    @Override
    public void delete(Long subjectId) throws MyEntityNotFoundException {
        Optional<SubjectEntity> entity = subjectRepository.findById(subjectId);
        if (entity.isPresent()){
            subjectRepository.delete(entity.get());
        }else{
            throw new MyEntityNotFoundException("Subject with id: " + subjectId + " doesn't exist.");
        }
    }

    @Override
    public List<SubjectDto> getAll() {
        List<SubjectEntity> entities = subjectRepository.findAll();
        return entities.stream().map(entity -> {
            return subjectMapper.toDto(entity);
        }).collect(Collectors.toList());

    }

    @Override
    public List<SubjectDto> getAll(int pageNo, int pageSize, String sortBy) {

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<SubjectEntity> pageResult = subjectRepository.findAll(pageable);
        if (pageResult.hasContent()) {
            List<SubjectEntity> subjects = pageResult.getContent();
            return subjects.stream().map(entity -> {
                return subjectMapper.toDto(entity);
            }).collect(Collectors.toList());
        }
        return new ArrayList<SubjectDto>();

    }
}
