package it.engineering.marjanjovanovicbe.controller;

import it.engineering.marjanjovanovicbe.dto.StudentDto;
import it.engineering.marjanjovanovicbe.dto.StudentDtoWithExamRegistration;
import it.engineering.marjanjovanovicbe.dto.SubjectDto;
import it.engineering.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.engineering.marjanjovanovicbe.exception.MyEntityNotFoundException;
import it.engineering.marjanjovanovicbe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAll")
    public @ResponseBody
    ResponseEntity<List<StudentDto>> getAll() throws MyEntityNotFoundException {
        List<StudentDto> list = studentService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/findById{id}")
    public @ResponseBody
    ResponseEntity<Object> get(@PathVariable Long id) {
        Optional<StudentDto> studentDto = studentService.findById(id);
        if (studentDto.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(studentDto.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid student id!");
    }

    //    @GetMapping("/getAllFiltered")
//    public ResponseEntity<List<StudentDto>> getAll(
//            @RequestParam(defaultValue = "0") int pageNo,
//            @RequestParam(defaultValue = "2") int pageSize,
//            @RequestParam(defaultValue = "firstName") String sortBy) {
//        List<StudentDto> listStudents = studentService.getAll(pageNo, pageSize, sortBy);
//        return ResponseEntity.status(HttpStatus.OK).body(listStudents);
//    }

    @GetMapping("/getAllFiltered")
    public @ResponseBody
    ResponseEntity<Page<StudentDto>> getByPage(Pageable pageable) {
        System.out.println(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAll(pageable));
    }

    @PostMapping("/save")
    public @ResponseBody
    ResponseEntity<Object> save(@Valid @RequestBody StudentDto studentDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.save(studentDto));
        } catch (MyEntityAlreadyExistsException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error saving student entity: " + studentDto);
        }
    }

    @PutMapping("/update")
    public @ResponseBody
    ResponseEntity<StudentDto> update(@Valid @RequestBody StudentDto studentDto) throws MyEntityNotFoundException {
        Optional<StudentDto> student = studentService.update(studentDto);
        if (student.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(student.get());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(studentDto);
        }
    }

    @DeleteMapping("/{studentId}")
    public @ResponseBody
    ResponseEntity<String> delete(@PathVariable(name = "studentId") Long studentId) {
        try {
            studentService.delete(studentId);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted student with id: " + studentId);
        } catch (MyEntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/registerExams")
    public @ResponseBody
    ResponseEntity<Object> registerExam(@RequestBody StudentDtoWithExamRegistration studentDtoWithExamRegistration) {
        try {
            System.out.println("trying to reg");
            return ResponseEntity.status(HttpStatus.OK).body(studentService.registerExam(studentDtoWithExamRegistration));
        } catch (MyEntityNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error saving student entity: " + studentDtoWithExamRegistration);
        }
    }


}
