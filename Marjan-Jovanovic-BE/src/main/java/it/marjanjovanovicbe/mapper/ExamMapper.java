package it.marjanjovanovicbe.mapper;

import it.marjanjovanovicbe.dto.ExamDto;
import it.marjanjovanovicbe.entity.ExamEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamMapper {

    ExamDto toDto(ExamEntity examEntity);
    ExamEntity toEntity(ExamDto examDto);
}
