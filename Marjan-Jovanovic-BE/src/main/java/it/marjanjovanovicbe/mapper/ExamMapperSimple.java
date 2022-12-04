package it.marjanjovanovicbe.mapper;

import it.marjanjovanovicbe.dto.ExamDtoSimple;
import it.marjanjovanovicbe.entity.ExamEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamMapperSimple {

    ExamDtoSimple toDto(ExamEntity examEntity);
    ExamEntity toEntity(ExamDtoSimple examDto);
}
