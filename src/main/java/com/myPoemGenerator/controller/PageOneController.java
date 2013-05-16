package com.myPoemGenerator.controller;

//import com.myPoemGenerator.validator.FirstSentenceValidator;
//import org.springframework.beans.factory.annotation.Autowired;

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

//import com.myPoemGenerator.model.PoemSentence;

@Controller
@RequestMapping("/page1")
public class PageOneController{

    //FirstSentenceValidator firstSentenceValidator;

//    @Autowired
//    public PageOneController(FirstSentenceValidator firstSentenceValidator){
//        this.firstSentenceValidator = firstSentenceValidator;
//    }

    @RequestMapping(method = RequestMethod.GET)
    public String onPage(ModelMap model,
                         @ModelAttribute("PoemSentence") PoemSentence poemSentence,
                         HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("firstSentence")!=null){
            poemSentence.setSentence((String) session.getAttribute("firstSentence"));
            //poemText.setSentence((String) session.getAttribute("firstSentence"));
        }
        model.addAttribute("message", "Please enter the first sentence of the poem:");
        return "page1";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handlePost(ModelMap model,
                             @Valid @ModelAttribute("PoemSentence") PoemSentence poemSentence,
                             BindingResult result, SessionStatus status,
                             HttpServletRequest request) {
        HttpSession session = request.getSession();
        //firstSentenceValidator.validate(poemText, result);

        if (result.hasErrors()) {
            //if validator failed
            model.addAttribute("message", "Please enter the first sentence of the poem:");
            return "page1";
        } else {
            status.setComplete();
            //form success
            session.setAttribute("firstSentence", poemSentence.getSentence());
            return "redirect:page2";
        }
    }
}
