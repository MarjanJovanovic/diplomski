package it.marjanjovanovicbe.mapper;

import it.marjanjovanovicbe.dto.SubjectDto;
import it.marjanjovanovicbe.entity.SubjectEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    SubjectDto toDto(SubjectEntity entity);
    SubjectEntity toEntity(SubjectDto dto);
}
