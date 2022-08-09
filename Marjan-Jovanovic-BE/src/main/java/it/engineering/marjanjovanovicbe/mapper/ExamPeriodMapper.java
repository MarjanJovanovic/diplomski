package it.engineering.marjanjovanovicbe.mapper;

import it.engineering.marjanjovanovicbe.dto.ExamPeriodDto;
import it.engineering.marjanjovanovicbe.entity.ExamPeriodEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamPeriodMapper {

    ExamPeriodDto toDto(ExamPeriodEntity examPeriodEntity);
    ExamPeriodEntity toEntity (ExamPeriodDto examPeriodDto);
}
