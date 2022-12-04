package it.marjanjovanovicbe.mapper;

import it.marjanjovanovicbe.dto.StudentDtoWithExamRegistration;
import it.marjanjovanovicbe.entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentDtoWithExamRegistrationMapper {

    StudentDtoWithExamRegistration toDto(StudentEntity entity);
    StudentEntity toEntity(StudentDtoWithExamRegistration dto);
}
