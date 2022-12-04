package it.marjanjovanovicbe.service.impl;

import it.marjanjovanovicbe.dto.SubjectDto;
import it.marjanjovanovicbe.dto.SubjectDtoWithoutId;
import it.marjanjovanovicbe.entity.SubjectEntity;
import it.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.marjanjovanovicbe.exception.MyEntityNotFoundException;
import it.marjanjovanovicbe.mapper.SubjectMapper;
import it.marjanjovanovicbe.mapper.SubjectWIthoutIdMapper;
import it.marjanjovanovicbe.repository.SubjectRepository;
import it.marjanjovanovicbe.service.SubjectService;
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
public class SubjectServiceImpl implements SubjectService {
    private SubjectRepository subjectRepository;
    private SubjectMapper subjectMapper;
    private SubjectWIthoutIdMapper subjectWIthoutIdMapper;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository, SubjectMapper subjectMapper, SubjectWIthoutIdMapper subjectWIthoutIdMapper) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
        this.subjectWIthoutIdMapper = subjectWIthoutIdMapper;
    }

    @Override
    public Optional<SubjectDto> findById(Long subjectId) {
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);
        if (subjectEntity.isPresent()) {
            return Optional.of(subjectMapper.toDto(subjectEntity.get()));
        }
        return Optional.empty();
    }

    @Override
    public SubjectDto save(SubjectDtoWithoutId subjectDto) throws MyEntityAlreadyExistsException {
        SubjectEntity subjectEntity = subjectRepository.save(subjectWIthoutIdMapper.toEntity(subjectDto));
        return subjectMapper.toDto(subjectEntity);
    }

    @Override
    public Optional<SubjectDto> update(SubjectDto subjectDto) throws MyEntityNotFoundException {
        Optional<SubjectEntity> entity = subjectRepository.findById(subjectDto.getId());
        if (entity.isPresent()) {
            SubjectEntity subjectEntity = subjectRepository.save(subjectMapper.toEntity(subjectDto));
            return Optional.of(subjectMapper.toDto(subjectEntity));
        } else {
            throw new MyEntityNotFoundException("Subject doesn't exist!");
        }
    }

    @Override
    public void delete(Long subjectId) throws MyEntityNotFoundException {
        Optional<SubjectEntity> entity = subjectRepository.findById(subjectId);
        if (entity.isPresent()) {
            subjectRepository.delete(entity.get());
        } else {
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

//    @Override
//    public List<SubjectDto> getAll(int pageNo, int pageSize, String sortBy) {

    //        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
//
//        Page<SubjectEntity> pageResult = subjectRepository.findAll(pageable);
//        if (pageResult.hasContent()) {
//            List<SubjectEntity> subjects = pageResult.getContent();
//            return subjects.stream().map(entity -> {
//                return subjectMapper.toDto(entity);
//            }).collect(Collectors.toList());
//        }
//        return new ArrayList<SubjectDto>();
//    }
    @Override
    public Page<SubjectDto> getAll(Pageable pageable) {
        return subjectRepository.findAll(pageable).map(subjectMapper::toDto);
    }
}
