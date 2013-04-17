package com.myPoemGenerator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page1.htm")
public class PageOneController{

    @RequestMapping(method = RequestMethod.GET)
    public String printPage1(ModelMap model) {
        model.addAttribute("message", "Welcome to the first page!");
        return "page1";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String reloadPage1(ModelMap model, @RequestParam(value="secondSentence", required=false)String secondSentence, HttpServletRequest request){
        HttpSession session = request.getSession();
        String firstSentence = (String)session.getAttribute("firstSentence");
        if(firstSentence != null){
            model.addAttribute("sentence",firstSentence);
        }
        else{
            model.addAttribute("sentence","");
        }
        session.setAttribute("secondSentence",secondSentence);
        return "page1";
    }
}
