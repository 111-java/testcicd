package com.bbhaviin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class TestController {

    @GetMapping("/{name}")
    public String myTest(@PathVariable String name){
        return "Hello " + name + " Congrats successfully completed Jenkins Demo...";
    }

}
