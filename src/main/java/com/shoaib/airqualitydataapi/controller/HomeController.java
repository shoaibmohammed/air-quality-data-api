package com.shoaib.airqualitydataapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @RequestMapping(value = "/")
    public String helloWord() {
        return "Air Quality Data";
    }
}
