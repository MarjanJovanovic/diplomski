package it.engineering.marjanjovanovicbe.controller;

import it.engineering.marjanjovanovicbe.dto.ExamDto;
import it.engineering.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.engineering.marjanjovanovicbe.exception.MyEntityNotFoundException;
import it.engineering.marjanjovanovicbe.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/exam")
public class ExamController {
    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/getAll")
    public @ResponseBody
    ResponseEntity<List<ExamDto>> getAll() throws MyEntityNotFoundException {
        List<ExamDto> list = examService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/getAllFiltered")
    public ResponseEntity<List<ExamDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "2") int pageSize,
            @RequestParam(defaultValue = "name") String sortBy){
        List<ExamDto> exams = examService.getAll(pageNo, pageSize, sortBy);
        return ResponseEntity.status(HttpStatus.OK).body(exams);
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<Object> save(@Valid @RequestBody ExamDto examDto){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(examService.save(examDto));
        }catch (MyEntityAlreadyExistsException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error saving exam entity: " + examDto);
        }
    }

    @PutMapping("/update")
    public @ResponseBody ResponseEntity<ExamDto> update(@Valid @RequestBody ExamDto examDto) throws MyEntityNotFoundException{
        Optional<ExamDto> exam = examService.update(examDto);
        if (exam.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(exam.get());
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(examDto);
        }
    }

    @DeleteMapping("/{examId}")
    public @ResponseBody ResponseEntity<String> delete(@PathVariable(name = "examId") Long examId){
        try{
            examService.delete(examId);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted exam with id: " + examId);
        } catch (MyEntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
