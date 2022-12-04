package it.marjanjovanovicbe.mapper;

import it.marjanjovanovicbe.dto.StudentDto;
import it.marjanjovanovicbe.entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDto toDto(StudentEntity entity);
    StudentEntity toEntity(StudentDto dto);
}
