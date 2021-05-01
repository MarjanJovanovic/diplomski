package it.engineering.marjanjovanovicbe.mapper;

import it.engineering.marjanjovanovicbe.dto.SubjectDto;
import it.engineering.marjanjovanovicbe.dto.SubjectDtoWithoutId;
import it.engineering.marjanjovanovicbe.entity.SubjectEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectWIthoutIdMapper {

    //    @Mapping(target = "professors", ignore = true)
    SubjectDtoWithoutId toDto(SubjectEntity entity);

    //    @Mapping(target = "professors", ignore = true)
    SubjectEntity toEntity(SubjectDtoWithoutId dto);
}
