package fr.insa.msclient.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ms-client/test")
public class TestController {
    @GetMapping
    public String getTest(){
        return "Hello";
    }
}
