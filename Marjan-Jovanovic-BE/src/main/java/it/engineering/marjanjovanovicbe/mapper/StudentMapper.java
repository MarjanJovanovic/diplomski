package it.engineering.marjanjovanovicbe.mapper;

import it.engineering.marjanjovanovicbe.dto.StudentDto;
import it.engineering.marjanjovanovicbe.entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDto toDto(StudentEntity entity);
    StudentEntity toEntity(StudentDto dto);
}
