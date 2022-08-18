package it.engineering.marjanjovanovicbe.controller;

import it.engineering.marjanjovanovicbe.entity.SenderResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class AuthController {


    @GetMapping(value="/admin")
    public SenderResponse adminEndPoint() {
        return new SenderResponse("Hello From Admin");
    }
    @GetMapping(value="/professor")
    public SenderResponse managerEndPoint() {
        return new SenderResponse("Hello From Manager");
    }
}
