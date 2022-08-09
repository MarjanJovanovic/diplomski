package it.engineering.marjanjovanovicbe.mapper;

import it.engineering.marjanjovanovicbe.dto.ExamDtoSimple;
import it.engineering.marjanjovanovicbe.entity.ExamEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamMapperSimple {

    ExamDtoSimple toDto(ExamEntity examEntity);
    ExamEntity toEntity(ExamDtoSimple examDto);
}
