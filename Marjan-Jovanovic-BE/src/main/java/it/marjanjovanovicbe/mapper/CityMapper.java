package it.marjanjovanovicbe.mapper;

import it.marjanjovanovicbe.dto.CityDto;
import it.marjanjovanovicbe.entity.CityEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityDto toDto(CityEntity entity);
    CityEntity toEntity(CityDto dto);
}
