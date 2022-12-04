package it.marjanjovanovicbe.controller;

import it.marjanjovanovicbe.dto.ExamPeriodDto;
import it.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.marjanjovanovicbe.exception.MyEntityInvalidParamException;
import it.marjanjovanovicbe.exception.MyEntityNotFoundException;
import it.marjanjovanovicbe.service.ExamPeriodService;
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
@RequestMapping(path = "/exam-period")
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

    @GetMapping("/findById{id}")
    public @ResponseBody ResponseEntity<Object> get(@PathVariable Long id) {
        Optional<ExamPeriodDto> examPeriodDto = examPeriodService.findById(id);
        if (examPeriodDto.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(examPeriodDto.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid exam period id!");
    }

//    @GetMapping("/getAllFiltered")
//    public ResponseEntity<List<ExamPeriodDto>> getAll(
//            @RequestParam(defaultValue = "0") int pageNo,
//            @RequestParam(defaultValue = "2") int pageSize,
//            @RequestParam(defaultValue = "name") String sortBy){
//        List<ExamPeriodDto> listExamPeriod = examPeriodService.getAll(pageNo, pageSize, sortBy);
//        return ResponseEntity.status(HttpStatus.OK).body(listExamPeriod);
//    }

    @GetMapping("/getAllFiltered")
    public @ResponseBody ResponseEntity<Page<ExamPeriodDto>> getByPage(Pageable pageable) {
        System.out.println(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(examPeriodService.getAll(pageable));
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<Object> save(@Valid @RequestBody ExamPeriodDto examPeriodDto){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(examPeriodService.save(examPeriodDto));
        }catch (MyEntityAlreadyExistsException | MyEntityInvalidParamException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error saving exam period entity: " + examPeriodDto);
        }
    }

    @PutMapping("/update")
    public @ResponseBody ResponseEntity<ExamPeriodDto> update(@Valid @RequestBody ExamPeriodDto examPeriodDto) throws MyEntityNotFoundException, MyEntityInvalidParamException {
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
