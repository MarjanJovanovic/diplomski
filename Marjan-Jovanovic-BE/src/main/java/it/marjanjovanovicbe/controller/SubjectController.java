package it.marjanjovanovicbe.controller;

import it.marjanjovanovicbe.dto.SubjectDto;
import it.marjanjovanovicbe.dto.SubjectDtoWithoutId;
import it.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.marjanjovanovicbe.exception.MyEntityNotFoundException;
import it.marjanjovanovicbe.service.SubjectService;
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

    @GetMapping("/findById{id}")
    public @ResponseBody ResponseEntity<Object> get(@PathVariable Long id) {
        Optional<SubjectDto> subjectDto = subjectService.findById(id);
        if (subjectDto.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(subjectDto.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid subject id!");
    }

//    @GetMapping("/getAllFiltered")
//    public ResponseEntity<List<SubjectDto>> getAll(
//            @RequestParam(defaultValue = "0") int pageNo,
//            @RequestParam(defaultValue = "2") int pageSize,
//            @RequestParam(defaultValue = "name") String sortBy){
//        List<SubjectDto> listSubjects = subjectService.getAll(pageNo, pageSize, sortBy);
//        return ResponseEntity.status(HttpStatus.OK).body(listSubjects);
//    }

    @GetMapping("/getAllFiltered")
    public @ResponseBody ResponseEntity<Page<SubjectDto>> getByPage(Pageable pageable) {
        System.out.println(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.getAll(pageable));
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<Object> save(@Valid @RequestBody SubjectDtoWithoutId subjectDto){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(subjectService.save(subjectDto));
        }catch (MyEntityAlreadyExistsException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error saving subject entity: " + subjectDto);
        }
    }

    @PutMapping("/update")
    public @ResponseBody ResponseEntity<SubjectDto> update(@Valid @RequestBody SubjectDto subjectDto) throws MyEntityNotFoundException{
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
