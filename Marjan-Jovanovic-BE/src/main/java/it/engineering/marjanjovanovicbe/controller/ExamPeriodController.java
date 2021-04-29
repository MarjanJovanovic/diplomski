package it.engineering.marjanjovanovicbe.controller;

import it.engineering.marjanjovanovicbe.dto.ExamPeriodDto;
import it.engineering.marjanjovanovicbe.entity.ExamPeriodEntity;
import it.engineering.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.engineering.marjanjovanovicbe.exception.MyEntityNotFoundException;
import it.engineering.marjanjovanovicbe.service.ExamPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/examPeriod")
public class ExamPeriodController {
    private final ExamPeriodService examPeriodService;

    @Autowired
    public ExamPeriodController(ExamPeriodService examPeriodService) {
        this.examPeriodService = examPeriodService;
    }

    @GetMapping("/getAll")
    public @ResponseBody
    ResponseEntity<List<ExamPeriodDto>> getAll() throws MyEntityNotFoundException{
        List<ExamPeriodDto> list = examPeriodService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/getAllFiltered")
    public ResponseEntity<List<ExamPeriodDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "2") int pageSize,
            @RequestParam(defaultValue = "name") String sortBy){
        List<ExamPeriodDto> listExamPeriod = examPeriodService.getAll(pageNo, pageSize, sortBy);
        return ResponseEntity.status(HttpStatus.OK).body(listExamPeriod);
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<Object> save(@Valid @RequestBody ExamPeriodDto examPeriodDto){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(examPeriodService.save(examPeriodDto));
        }catch (MyEntityAlreadyExistsException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error saving exam period entity: " + examPeriodDto);
        }
    }

    @PutMapping("/update")
    public @ResponseBody ResponseEntity<ExamPeriodDto> update(@Valid @RequestBody ExamPeriodDto examPeriodDto) throws MyEntityNotFoundException{
        Optional<ExamPeriodDto> examPeriod = examPeriodService.update(examPeriodDto);
        if (examPeriod.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(examPeriod.get());
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(examPeriodDto);
        }
    }

    @DeleteMapping("/{examPeriodId}")
    public @ResponseBody ResponseEntity<String> delete(@PathVariable(name = "examPeriodId") Long examPeriodId){
        try{
            examPeriodService.delete(examPeriodId);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted exam period with id: " + examPeriodId);
        } catch (MyEntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
