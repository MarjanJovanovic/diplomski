package it.engineering.marjanjovanovicbe.mapper;

import it.engineering.marjanjovanovicbe.dto.ExamDto;
import it.engineering.marjanjovanovicbe.entity.ExamEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamMapper {

    ExamDto toDto(ExamEntity examEntity);
    ExamEntity toEntity(ExamDto examDto);
}
