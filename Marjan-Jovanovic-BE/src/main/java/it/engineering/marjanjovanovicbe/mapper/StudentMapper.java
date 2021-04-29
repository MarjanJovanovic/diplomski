package it.engineering.marjanjovanovicbe.mapper;

import it.engineering.marjanjovanovicbe.dto.StudentDto;
import it.engineering.marjanjovanovicbe.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "exams", ignore = true)
    StudentDto toDto(StudentEntity entity);
    @Mapping(target = "exams", ignore = true)
    StudentEntity toEntity(StudentDto dto);
}
