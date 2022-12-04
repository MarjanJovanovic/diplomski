package it.marjanjovanovicbe.mapper;

import it.marjanjovanovicbe.dto.ProfessorDto;
import it.marjanjovanovicbe.entity.ProfessorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {

    ProfessorDto toDto(ProfessorEntity entity);
    ProfessorEntity toEntity(ProfessorDto dto);
}
