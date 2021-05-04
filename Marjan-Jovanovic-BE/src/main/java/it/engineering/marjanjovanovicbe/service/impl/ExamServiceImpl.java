package it.engineering.marjanjovanovicbe.service.impl;

import it.engineering.marjanjovanovicbe.dto.*;
import it.engineering.marjanjovanovicbe.entity.ExamEntity;
import it.engineering.marjanjovanovicbe.entity.ExamPeriodEntity;
import it.engineering.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.engineering.marjanjovanovicbe.exception.MyEntityInvalidParamException;
import it.engineering.marjanjovanovicbe.exception.MyEntityNotFoundException;
import it.engineering.marjanjovanovicbe.mapper.ExamMapper;
import it.engineering.marjanjovanovicbe.mapper.ExamMapperSimple;
import it.engineering.marjanjovanovicbe.repository.ExamPeriodRepository;
import it.engineering.marjanjovanovicbe.repository.ExamRepository;
import it.engineering.marjanjovanovicbe.repository.ProfessorRepository;
import it.engineering.marjanjovanovicbe.repository.SubjectRepository;
import it.engineering.marjanjovanovicbe.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {
    private ExamRepository examRepository;
    private ExamMapper examMapper;
    private ExamPeriodRepository examPeriodRepository;
    private SubjectRepository subjectRepository;
    private ProfessorRepository professorRepository;
    private ExamMapperSimple examMapperSimple;

    @Autowired
    public ExamServiceImpl(ExamRepository examRepository, ExamMapper examMapper, ExamPeriodRepository examPeriodRepository, SubjectRepository subjectRepository, ProfessorRepository professorRepository, ExamMapperSimple examMapperSimple) {
        this.examRepository = examRepository;
        this.examMapper = examMapper;
        this.examMapperSimple = examMapperSimple;
        this.examPeriodRepository = examPeriodRepository;
        this.subjectRepository = subjectRepository;
        this.professorRepository = professorRepository;
    }

    @Override
    public Optional<ExamDto> findById(Long examId) {
        Optional<ExamEntity> examEntity = examRepository.findById(examId);
        if (examEntity.isPresent()) {
            return Optional.of(examMapper.toDto(examEntity.get()));
        }
        return Optional.empty();
    }

    @Override
    public ExamDto save(ExamDtoSimple examDto) throws MyEntityAlreadyExistsException, MyEntityInvalidParamException {
        Optional<ExamEntity> entity = examRepository.findById(examDto.getId());
        if (entity.isPresent()) { //TODO: check if exam already exists within examPeriod
            throw new MyEntityAlreadyExistsException("Exam already exists: ", examMapper.toDto(entity.get()));
        }
        if (!(validateExam(examDto))) {
            throw new MyEntityInvalidParamException("Exam period must have a exam period, subject and professor params that already exist, and date that is within the given exam period.");
        }
        ExamEntity examEntityToBeSaved = examMapperSimple.toEntity(examDto);
        examEntityToBeSaved.setExamPeriod(examPeriodRepository.findById(examDto.getExamPeriodDto().getId()).orElse(null));
        ExamEntity examEntitySaved = examRepository.save(examEntityToBeSaved);
        return examMapper.toDto(examEntitySaved);
    }

    @Override
    public Optional<ExamDto> update(ExamDto examDto) throws MyEntityNotFoundException {
        Optional<ExamEntity> entity = examRepository.findById(examDto.getId());
        if (entity.isPresent()) {
            ExamEntity examEntity = examRepository.save(examMapper.toEntity(examDto));
            return Optional.of(examMapper.toDto(examEntity));
        } else {
            throw new MyEntityNotFoundException("Exam doesn't exist!");
        }
    }

    @Override
    public void delete(Long examId) throws MyEntityNotFoundException {
        Optional<ExamEntity> entity = examRepository.findById(examId);
        if (entity.isPresent()) {
            examRepository.delete(entity.get());
        } else {
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

    //
    public boolean validateExam(ExamDtoSimple examDtoSimple) {
        System.out.println(examPeriodRepository.findById(examDtoSimple.getExamPeriodDto().getId()).isPresent());
        System.out.println(subjectRepository.findById(examDtoSimple.getSubject().getId()).isPresent());
        System.out.println(professorRepository.findById(examDtoSimple.getProfessor().getId()).isPresent());

        Optional<ExamPeriodEntity> examPeriodGiven = examPeriodRepository.findById(examDtoSimple.getExamPeriodDto().getId());
        System.out.println("compared 1: " + (examDtoSimple.getDate().compareTo(examPeriodGiven.get().getStartDate()) >= 0));
        System.out.println("compared 2: " + (examDtoSimple.getDate().compareTo(examPeriodGiven.get().getEndDate()) <= 0));

        if (examDtoSimple.getDate().compareTo(examPeriodGiven.get().getStartDate()) >= 0 && examDtoSimple.getDate().compareTo(examPeriodGiven.get().getEndDate()) <= 0) {
            return (examPeriodRepository.findById(examDtoSimple.getExamPeriodDto().getId()).isPresent()
                    && subjectRepository.findById(examDtoSimple.getSubject().getId()).isPresent()
                    && professorRepository.findById(examDtoSimple.getProfessor().getId()).isPresent()
            );
        }
        return false;
    }
}
