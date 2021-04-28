package it.engineering.marjanjovanovicbe.service.impl;

import it.engineering.marjanjovanovicbe.dto.ExamDto;
import it.engineering.marjanjovanovicbe.entity.ExamEntity;
import it.engineering.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.engineering.marjanjovanovicbe.exception.MyEntityNotFoundException;
import it.engineering.marjanjovanovicbe.mapper.ExamMapper;
import it.engineering.marjanjovanovicbe.repository.ExamRepository;
import it.engineering.marjanjovanovicbe.service.ExamService;
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
public class ExamServiceImpl implements ExamService {
    private ExamRepository examRepository;
    private ExamMapper examMapper;

    @Autowired
    public ExamServiceImpl(ExamRepository examRepository, ExamMapper examMapper) {
        this.examRepository = examRepository;
        this.examMapper = examMapper;
    }

    @Override
    public Optional<ExamDto> findById(Long examId) {
        Optional<ExamEntity> examEntity = examRepository.findById(examId);
        if (examEntity.isPresent()){
            return Optional.of(examMapper.toDto(examEntity.get()));
        }
        return Optional.empty();
    }

    @Override
    public ExamDto save(ExamDto examDto) throws MyEntityAlreadyExistsException {
        Optional<ExamEntity> entity = examRepository.findById(examDto.getId());
        if (entity.isPresent()){
            throw new MyEntityAlreadyExistsException("Exam already exists: ", examMapper.toDto(entity.get()));
        }
        ExamEntity examEntity = examRepository.save(examMapper.toEntity(examDto));
        return examMapper.toDto(examEntity);
    }

    @Override
    public Optional<ExamDto> update(ExamDto examDto) throws MyEntityNotFoundException {
        Optional<ExamEntity> entity = examRepository.findById(examDto.getId());
        if (entity.isPresent()){
            ExamEntity examEntity = examRepository.save(examMapper.toEntity(examDto));
            return Optional.of(examMapper.toDto(examEntity));
        }else{
            throw new MyEntityNotFoundException("Exam doesn't exist!");
        }
    }

    @Override
    public void delete(Long examId) throws MyEntityNotFoundException {
        Optional<ExamEntity> entity = examRepository.findById(examId);
        if (entity.isPresent()){
            examRepository.delete(entity.get());
        }else{
            throw new MyEntityNotFoundException("Exam with id: " + examId + " doesn't exist.");
        }
    }

    @Override
    public List<ExamDto> getAll() {
        List<ExamEntity> entities = examRepository.findAll();
        return entities.stream().map(entity -> {
            return examMapper.toDto(entity);
        }).collect(Collectors.toList());
    }

    @Override
    public List<ExamDto> getAll(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<ExamEntity> pageResult = examRepository.findAll(pageable);
        if (pageResult.hasContent()) {
            List<ExamEntity> exams = pageResult.getContent();
            return exams.stream().map(entity -> {
                return examMapper.toDto(entity);
            }).collect(Collectors.toList());
        }
        return new ArrayList<ExamDto>();
    }
}
