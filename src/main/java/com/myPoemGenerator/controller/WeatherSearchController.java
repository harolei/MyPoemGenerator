package com.myPoemGenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/weather")
public class WeatherSearchController {
    @RequestMapping(method = RequestMethod.GET)
    public String getWeather(HttpServletRequest request, Model model){
        return "searchWeather";
    }

}
