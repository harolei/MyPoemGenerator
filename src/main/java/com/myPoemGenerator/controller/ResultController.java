package com.myPoemGenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/result")
public class ResultController {
    @RequestMapping(method = RequestMethod.GET)
    public String printResult(){
        return "result";
    }
}
