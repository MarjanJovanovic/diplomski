package it.engineering.marjanjovanovicbe.mapper;

import it.engineering.marjanjovanovicbe.dto.SubjectDto;
import it.engineering.marjanjovanovicbe.entity.SubjectEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    SubjectDto toDto(SubjectEntity entity);
    SubjectEntity toEntity(SubjectDto dto);
}
