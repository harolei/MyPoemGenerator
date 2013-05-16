package com.myPoemGenerator.controller;

import com.myPoemGenerator.model.PoemSentence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

//import com.myPoemGenerator.validator.SecondSentenceValidator;
//import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/page2")
public class PageTwoController{
//    SecondSentenceValidator secondSentenceValidator;
//
//    @Autowired
//    public PageTwoController(SecondSentenceValidator secondSentenceValidator){
//        this.secondSentenceValidator = secondSentenceValidator;
//    }


    @RequestMapping(method = RequestMethod.POST)
    public String handlePost(ModelMap model,
                             @ModelAttribute("PoemSentence") @Valid PoemSentence poemSentence,
                             BindingResult result, SessionStatus status,
                             HttpServletRequest request) {

        HttpSession session = request.getSession();
        //secondSentenceValidator.validate(poemText, result);

        if (result.hasErrors()) {
            //if validator failed
            model.addAttribute("message", "Please enter the second sentence of the poem:");
            return "page2";
        } else {
            status.setComplete();
            //form success
            session.setAttribute("secondSentence", poemSentence.getSentence());
            return "redirect:page3";
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public String onPage(ModelMap model,
                             @ModelAttribute("PoemSentence") PoemSentence poemSentence,
                             HttpServletRequest request) {
        model.addAttribute("message", "Please enter the second sentence of the poem:");
        HttpSession session = request.getSession();
        if(session.getAttribute("secondSentence")!=null){
            poemSentence.setSentence((String) session.getAttribute("secondSentence"));
        }
        return "page2";
    }

}
