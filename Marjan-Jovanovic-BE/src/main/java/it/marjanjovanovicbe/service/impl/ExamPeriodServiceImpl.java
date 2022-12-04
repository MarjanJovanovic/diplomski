package it.marjanjovanovicbe.service.impl;

import it.marjanjovanovicbe.dto.ExamPeriodDto;
import it.marjanjovanovicbe.entity.ExamPeriodEntity;
import it.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.marjanjovanovicbe.exception.MyEntityInvalidParamException;
import it.marjanjovanovicbe.exception.MyEntityNotFoundException;
import it.marjanjovanovicbe.mapper.ExamPeriodMapper;
import it.marjanjovanovicbe.repository.ExamPeriodRepository;
import it.marjanjovanovicbe.service.ExamPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ExamPeriodServiceImpl implements ExamPeriodService {
    private ExamPeriodRepository examPeriodRepository;
    private ExamPeriodMapper examPeriodMapper;

    @Autowired
    public ExamPeriodServiceImpl(ExamPeriodRepository examPeriodRepository, ExamPeriodMapper examPeriodMapper) {
        this.examPeriodRepository = examPeriodRepository;
        this.examPeriodMapper = examPeriodMapper;
    }

    @Override
    public Optional<ExamPeriodDto> findById(Long examPeriodId) {
        Optional<ExamPeriodEntity> examPeriodEntity = examPeriodRepository.findById(examPeriodId);
        if (examPeriodEntity.isPresent()) {
            return Optional.of(examPeriodMapper.toDto(examPeriodEntity.get()));
        }
        return Optional.empty();
    }

    @Override
    public ExamPeriodDto save(ExamPeriodDto examPeriodDto) throws MyEntityAlreadyExistsException, MyEntityInvalidParamException {
        System.out.println("Testing exam period" + examPeriodDto);
        if (!(validateExamPeriodDates(examPeriodMapper.toEntity(examPeriodDto)))){
            throw new MyEntityInvalidParamException("Exam period in the given time period already exists");
        }
        Optional<ExamPeriodEntity> entity = examPeriodRepository.findById(examPeriodDto.getId());
        if (entity.isPresent()) {
            throw new MyEntityAlreadyExistsException("Exam period already exists: ", examPeriodMapper.toDto(entity.get()));
        }
        ExamPeriodEntity examPeriodEntity = examPeriodRepository.save(examPeriodMapper.toEntity(examPeriodDto));
        return examPeriodMapper.toDto(examPeriodEntity);
    }

    @Override
    public Optional<ExamPeriodDto> update(ExamPeriodDto examPeriodDto) throws MyEntityNotFoundException, MyEntityInvalidParamException {
        if (!(validateExamPeriodDates(examPeriodMapper.toEntity(examPeriodDto)))){
            throw new MyEntityInvalidParamException("Exam period in the given time period already exists");
        }
        Optional<ExamPeriodEntity> entity = examPeriodRepository.findById(examPeriodDto.getId());
        if (entity.isPresent()) {
            ExamPeriodEntity examPeriodEntity = examPeriodRepository.save(examPeriodMapper.toEntity(examPeriodDto));
            return Optional.of(examPeriodMapper.toDto(examPeriodEntity));
        } else {
            throw new MyEntityNotFoundException("Exam period doesn't exist!");
        }
    }

    @Override
    public void delete(Long examPeriodId) throws MyEntityNotFoundException {
        Optional<ExamPeriodEntity> entity = examPeriodRepository.findById(examPeriodId);
        if (entity.isPresent()) {
            examPeriodRepository.delete(entity.get());
        } else {
            throw new MyEntityNotFoundException("Exam period with id: " + examPeriodId + " doesn't exist.");
        }
    }

    @Override
    public List<ExamPeriodDto> getAll() {
        List<ExamPeriodEntity> entities = examPeriodRepository.findAll();
        return entities.stream().map(entity -> {
            return examPeriodMapper.toDto(entity);
        }).collect(Collectors.toList());
    }

//    @Override
//    public List<ExamPeriodDto> getAll(int pageNo, int pageSize, String sortBy) {
//        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
//
//        Page<ExamPeriodEntity> pageResult = examPeriodRepository.findAll(pageable);
//        if (pageResult.hasContent()) {
//            List<ExamPeriodEntity> examPeriods = pageResult.getContent();
//            return examPeriods.stream().map(entity -> {
//                return examPeriodMapper.toDto(entity);
//            }).collect(Collectors.toList());
//        }
//        return new ArrayList<ExamPeriodDto>();
//    }

    @Override
    public Page<ExamPeriodDto> getAll(Pageable pageable) {
        return examPeriodRepository.findAll(pageable).map(examPeriodMapper::toDto);
    }

    //TODO: Cleanup
    @Override
    public boolean validateExamPeriodDates(ExamPeriodEntity examPeriodEntity){
        List<ExamPeriodEntity> timePeriod1 = examPeriodRepository.findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(examPeriodEntity.getStartDate(), examPeriodEntity.getEndDate());
        List<ExamPeriodEntity> timePeriod2 = examPeriodRepository.findAllByStartDateBetween(examPeriodEntity.getStartDate(), examPeriodEntity.getEndDate());
        List<ExamPeriodEntity> timePeriod3 = examPeriodRepository.findAllByEndDateBetween(examPeriodEntity.getStartDate(), examPeriodEntity.getEndDate());
        List<ExamPeriodEntity> timePeriod4 = examPeriodRepository.findAllByStartDateGreaterThanEqualAndEndDateLessThanEqual(examPeriodEntity.getStartDate(), examPeriodEntity.getEndDate());
        return (timePeriod1.isEmpty() && timePeriod2.isEmpty() && timePeriod3.isEmpty() && timePeriod4.isEmpty());
    }
}
