package it.engineering.marjanjovanovicbe.mapper;

import it.engineering.marjanjovanovicbe.dto.StudentDtoWithExamRegistration;
import it.engineering.marjanjovanovicbe.entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentDtoWithExamRegistrationMapper {

    StudentDtoWithExamRegistration toDto(StudentEntity entity);
    StudentEntity toEntity(StudentDtoWithExamRegistration dto);
}
