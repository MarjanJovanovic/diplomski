package it.engineering.marjanjovanovicbe.controller;

import it.engineering.marjanjovanovicbe.dto.ProfessorDto;
import it.engineering.marjanjovanovicbe.exception.MyEntityAlreadyExistsException;
import it.engineering.marjanjovanovicbe.exception.MyEntityNotFoundException;
import it.engineering.marjanjovanovicbe.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/professor")
public class ProfessorController {
    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping("/getAll")
    public @ResponseBody
    ResponseEntity<List<ProfessorDto>> getAll() throws MyEntityNotFoundException {
        List<ProfessorDto> list = professorService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/getAllFiltered")
    public ResponseEntity<List<ProfessorDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "2") int pageSize,
            @RequestParam(defaultValue = "firstName") String sortBy) {
        List<ProfessorDto> listProfessors = professorService.getAll(pageNo, pageSize, sortBy);
        return ResponseEntity.status(HttpStatus.OK).body(listProfessors);
    }

    @PostMapping("/save")
    public @ResponseBody
    ResponseEntity<Object> save(@Valid @RequestBody ProfessorDto professorDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(professorService.save(professorDto));
        } catch (MyEntityAlreadyExistsException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error saving professor entity: " + professorDto);
        }
    }

    @PutMapping("/update")
    public @ResponseBody
    ResponseEntity<ProfessorDto> update(@Valid @RequestBody ProfessorDto professorDto) throws MyEntityNotFoundException {
        Optional<ProfessorDto> professor = professorService.update(professorDto);
        if (professor.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(professor.get());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(professorDto);
        }
    }

    @DeleteMapping("/{professorId}")
    public @ResponseBody
    ResponseEntity<String> delete(@PathVariable(name = "professorId") Long professorId) {
        try {
            professorService.delete(professorId);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted professor with id: " + professorId);
        } catch (MyEntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}
