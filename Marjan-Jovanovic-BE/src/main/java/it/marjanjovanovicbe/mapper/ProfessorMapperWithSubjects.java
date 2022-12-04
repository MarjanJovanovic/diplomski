package it.marjanjovanovicbe.mapper;

import it.marjanjovanovicbe.dto.ProfessorDtoWithSubjects;
import it.marjanjovanovicbe.entity.ProfessorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorMapperWithSubjects {

    ProfessorDtoWithSubjects toDto(ProfessorEntity entity);
    ProfessorEntity toEntity(ProfessorDtoWithSubjects dto);
}
