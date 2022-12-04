package it.marjanjovanovicbe.service.impl;

import it.marjanjovanovicbe.dto.ProfessorDto;
import it.marjanjovanovicbe.dto.ProfessorDtoWithSubjects;
import it.marjanjovanovicbe.entity.ProfessorEntity;
import it.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.marjanjovanovicbe.exception.MyEntityNotFoundException;
import it.marjanjovanovicbe.mapper.ProfessorMapper;
import it.marjanjovanovicbe.mapper.ProfessorMapperWithSubjects;
import it.marjanjovanovicbe.repository.ProfessorRepository;
import it.marjanjovanovicbe.service.ProfessorService;
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
public class ProfessorServiceImpl implements ProfessorService {
    private ProfessorRepository professorRepository;
    private ProfessorMapper professorMapper;
    private ProfessorMapperWithSubjects professorMapperWithSubjects;

    @Autowired
    public ProfessorServiceImpl(ProfessorRepository professorRepository, ProfessorMapper professorMapper, ProfessorMapperWithSubjects professorMapperWithSubjects) {
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
        this.professorMapperWithSubjects = professorMapperWithSubjects;
    }

    @Override
    public Optional<ProfessorDto> findById(Long professorId) {
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);
        if (professorEntity.isPresent()) {
            return Optional.of(professorMapper.toDto(professorEntity.get()));
        }
        return Optional.empty();
    }

    @Override
    public ProfessorDto save(ProfessorDto professorDto) throws MyEntityAlreadyExistsException {
        Optional<ProfessorEntity> entity = professorRepository.findById(professorDto.getId());
        if (entity.isPresent()) {
            throw new MyEntityAlreadyExistsException("Professor already exists: ", professorMapper.toDto(entity.get()));
        }
        ProfessorEntity professorEntity = professorRepository.save(professorMapper.toEntity(professorDto));
        return professorMapper.toDto(professorEntity);
    }


    @Override
    public Optional<ProfessorDtoWithSubjects> update(ProfessorDtoWithSubjects professorDto) throws MyEntityNotFoundException {
        Optional<ProfessorEntity> entity = professorRepository.findById(professorDto.getId());
        if (entity.isPresent()) {
            ProfessorEntity professorEntity = professorRepository.save(professorMapperWithSubjects.toEntity(professorDto));
            return Optional.of(professorMapperWithSubjects.toDto(professorEntity));
        } else {
            throw new MyEntityNotFoundException("Professor doesn't eexist!");
        }
    }

    @Override
    public void delete(Long professorId) throws MyEntityNotFoundException {
        Optional<ProfessorEntity> entity = professorRepository.findById(professorId);
        if (entity.isPresent()) {
            professorRepository.delete(entity.get());
        } else {
            throw new MyEntityNotFoundException("Professor with id: " + professorId + " doesn't exist.");
        }


    }

    @Override
    public List<ProfessorDto> getAll() {
        List<ProfessorEntity> entities = professorRepository.findAll();
        return entities.stream().map(entity -> {
            return professorMapper.toDto(entity);
        }).collect(Collectors.toList());
    }

//    @Override
//    public List<ProfessorDto> getAll(int pageNo, int pageSize, String sortBy) {
//        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
//
//        Page<ProfessorEntity> pageResult = professorRepository.findAll(pageable);
//        if (pageResult.hasContent()) {
//            List<ProfessorEntity> professors = pageResult.getContent();
//            return professors.stream().map(entity -> {
//                return professorMapper.toDto(entity);
//            }).collect(Collectors.toList());
//        }
//        return new ArrayList<ProfessorDto>();
//    }

    @Override
    public Page<ProfessorDto> getAll(Pageable pageable) {
        return professorRepository.findAll(pageable).map(professorMapper::toDto);
    }
}
