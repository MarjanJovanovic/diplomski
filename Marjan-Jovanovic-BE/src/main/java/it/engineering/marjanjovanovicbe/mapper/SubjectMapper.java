package it.engineering.marjanjovanovicbe.mapper;

import it.engineering.marjanjovanovicbe.dto.SubjectDto;
import it.engineering.marjanjovanovicbe.entity.SubjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    @Mapping(target = "professors", ignore = true)
    SubjectDto toDto(SubjectEntity entity);

    @Mapping(target = "professors", ignore = true)
    SubjectEntity toEntity(SubjectDto dto);
}
