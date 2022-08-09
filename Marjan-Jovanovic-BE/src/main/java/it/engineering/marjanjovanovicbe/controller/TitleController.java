package it.engineering.marjanjovanovicbe.controller;

import it.engineering.marjanjovanovicbe.dto.SubjectDto;
import it.engineering.marjanjovanovicbe.dto.TitleDto;
import it.engineering.marjanjovanovicbe.exception.MyEntityNotFoundException;
import it.engineering.marjanjovanovicbe.service.SubjectService;
import it.engineering.marjanjovanovicbe.util.TitleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/title")
public class TitleController {

    @GetMapping("/getAll")
    public @ResponseBody
    TitleName[] getAll() throws MyEntityNotFoundException {
        return TitleName.values();
    }
}
