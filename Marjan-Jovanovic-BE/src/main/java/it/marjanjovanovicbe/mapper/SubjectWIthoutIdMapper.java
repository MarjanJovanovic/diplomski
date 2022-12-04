package it.marjanjovanovicbe.mapper;

import it.marjanjovanovicbe.dto.SubjectDtoWithoutId;
import it.marjanjovanovicbe.entity.SubjectEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectWIthoutIdMapper {

    SubjectDtoWithoutId toDto(SubjectEntity entity);
    SubjectEntity toEntity(SubjectDtoWithoutId dto);
}
