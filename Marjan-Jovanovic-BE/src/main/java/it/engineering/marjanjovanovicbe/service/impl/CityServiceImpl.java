package it.engineering.marjanjovanovicbe.service.impl;

import it.engineering.marjanjovanovicbe.dto.CityDto;
import it.engineering.marjanjovanovicbe.entity.CityEntity;
import it.engineering.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.engineering.marjanjovanovicbe.exception.MyEntityNotFoundException;
import it.engineering.marjanjovanovicbe.mapper.CityMapper;
import it.engineering.marjanjovanovicbe.repository.CityRepository;
import it.engineering.marjanjovanovicbe.service.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;
    private CityMapper cityMapper;

    public CityServiceImpl(CityRepository cityRepository, CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
    }

    @Override
    public Optional<CityDto> findById(Long cityCode) {
        Optional<CityEntity> cityEntity = cityRepository.findById(cityCode);
        if (cityEntity.isPresent()){
            return Optional.of(cityMapper.toDto(cityEntity.get()));
        }
        return Optional.empty();
    }

    @Override
    public CityDto save(CityDto cityDto) throws MyEntityAlreadyExistsException {
        CityEntity cityEntity = cityRepository.save(cityMapper.toEntity(cityDto));
        return cityMapper.toDto(cityEntity);
    }

    @Override
    public Optional<CityDto> update(CityDto cityDto) throws MyEntityNotFoundException {
        Optional<CityEntity> entity = cityRepository.findById(cityDto.getPostalCode());
        if (entity.isPresent()){
            CityEntity cityEntity = cityRepository.save(cityMapper.toEntity(cityDto));
            return Optional.of(cityMapper.toDto(cityEntity));
        }else{
            throw new MyEntityNotFoundException("City doesn't exist!");
        }
    }

    @Override
    public void delete(Long cityCode) throws MyEntityNotFoundException {
        Optional<CityEntity> entity = cityRepository.findById(cityCode);
        if (entity.isPresent()){
            cityRepository.delete(entity.get());
        }else{
            throw new MyEntityNotFoundException("City with code: " + cityCode + " doesn't exist.");
        }
    }

    @Override
    public List<CityDto> getAll() {
        List<CityEntity> entities = cityRepository.findAll();
        return  entities.stream().map(entity -> {
            return cityMapper.toDto(entity);
        }).collect(Collectors.toList());
    }

    @Override
    public Page<CityDto> getAll(Pageable pageable) {
        return cityRepository.findAll(pageable).map(cityMapper::toDto);
    }
}
