package it.marjanjovanovicbe.controller;

import it.marjanjovanovicbe.exception.MyEntityNotFoundException;
import it.marjanjovanovicbe.util.TitleName;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/title")
public class TitleController {

    @GetMapping("/getAll")
    public @ResponseBody
    TitleName[] getAll() throws MyEntityNotFoundException {
        return TitleName.values();
    }
}
