package it.marjanjovanovicbe.controller;

import it.marjanjovanovicbe.dto.ExamDto;
import it.marjanjovanovicbe.dto.ExamDtoSimple;
import it.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.marjanjovanovicbe.exception.MyEntityInvalidParamException;
import it.marjanjovanovicbe.exception.MyEntityNotFoundException;
import it.marjanjovanovicbe.service.ExamService;
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

    @GetMapping("/findById{id}")
    public @ResponseBody ResponseEntity<Object> get(@PathVariable Long id) {
        Optional<ExamDto> examDto = examService.findById(id);
        if (examDto.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(examDto.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid exam id!");
    }

//    @GetMapping("/getAllFiltered")
//    public ResponseEntity<List<ExamDto>> getAll(
//            @RequestParam(defaultValue = "0") int pageNo,
//            @RequestParam(defaultValue = "2") int pageSize,
//            @RequestParam(defaultValue = "name") String sortBy){
//        List<ExamDto> exams = examService.getAll(pageNo, pageSize, sortBy);
//        return ResponseEntity.status(HttpStatus.OK).body(exams);
//    }

    @GetMapping("/getAllFiltered")
    public @ResponseBody ResponseEntity<Page<ExamDto>> getByPage(Pageable pageable) {
        System.out.println(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(examService.getAll(pageable));
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<Object> save(@Valid @RequestBody ExamDtoSimple examDto){
        System.out.println("Received examDto" + examDto);
        try{
            return ResponseEntity.status(HttpStatus.OK).body(examService.save(examDto));
        }catch (MyEntityAlreadyExistsException | MyEntityInvalidParamException e){
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
