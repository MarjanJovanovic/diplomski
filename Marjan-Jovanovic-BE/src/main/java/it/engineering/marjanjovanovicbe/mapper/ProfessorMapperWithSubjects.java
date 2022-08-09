package it.engineering.marjanjovanovicbe.mapper;

import it.engineering.marjanjovanovicbe.dto.ProfessorDtoWithSubjects;
import it.engineering.marjanjovanovicbe.entity.ProfessorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorMapperWithSubjects {

    ProfessorDtoWithSubjects toDto(ProfessorEntity entity);
    ProfessorEntity toEntity(ProfessorDtoWithSubjects dto);
}
