package it.marjanjovanovicbe.mapper;

import it.marjanjovanovicbe.dto.ExamPeriodDto;
import it.marjanjovanovicbe.entity.ExamPeriodEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamPeriodMapper {

    ExamPeriodDto toDto(ExamPeriodEntity examPeriodEntity);
    ExamPeriodEntity toEntity (ExamPeriodDto examPeriodDto);
}
