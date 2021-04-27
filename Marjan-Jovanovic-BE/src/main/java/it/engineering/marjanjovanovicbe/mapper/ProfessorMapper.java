package it.engineering.marjanjovanovicbe.mapper;

import it.engineering.marjanjovanovicbe.dto.ProfessorDto;
import it.engineering.marjanjovanovicbe.entity.ProfessorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {

    ProfessorDto toDto(ProfessorEntity entity);
    ProfessorEntity toEntity(ProfessorDto dto);
}
