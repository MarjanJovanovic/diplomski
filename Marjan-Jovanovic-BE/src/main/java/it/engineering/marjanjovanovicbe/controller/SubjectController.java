package it.engineering.marjanjovanovicbe.controller;

import it.engineering.marjanjovanovicbe.dto.SubjectDto;
import it.engineering.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.engineering.marjanjovanovicbe.exception.MyEntityInvalidParamException;
import it.engineering.marjanjovanovicbe.exception.MyEntityNotFoundException;
import it.engineering.marjanjovanovicbe.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/subject")
public class SubjectController {
    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/getAll")
    public @ResponseBody
    ResponseEntity<List<SubjectDto>> getAll() throws MyEntityNotFoundException{
        List<SubjectDto> list = subjectService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/getAllFiltered")
    public ResponseEntity<List<SubjectDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "2") int pageSize,
            @RequestParam(defaultValue = "name") String sortBy){
        List<SubjectDto> listSubjects = subjectService.getAll(pageNo, pageSize, sortBy);
        return ResponseEntity.status(HttpStatus.OK).body(listSubjects);
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<Object> save(@RequestBody SubjectDto subjectDto){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(subjectService.save(subjectDto));
        }catch (MyEntityAlreadyExistsException | MyEntityInvalidParamException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error saving subject entity: " + subjectDto);
        }
    }

    @PutMapping("/update")
    public @ResponseBody ResponseEntity<SubjectDto> update(@RequestBody SubjectDto subjectDto) throws MyEntityNotFoundException, MyEntityInvalidParamException {
        Optional<SubjectDto> subject = subjectService.update(subjectDto);
        if (subject.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(subject.get());
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(subjectDto);
        }
    }

    @DeleteMapping("/{subjectId}")
    public @ResponseBody ResponseEntity<String> delete(@PathVariable(name = "subjectId") Long subjectId){
        try{
            subjectService.delete(subjectId);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted subject with id: " + subjectId);
        } catch (MyEntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}
