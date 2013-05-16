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

//import com.myPoemGenerator.validator.ThirdSentenceValidator;

@Controller
@RequestMapping("/page3")
public class PageThreeController {

//    ThirdSentenceValidator thirdSentenceValidator;
//
//    @Autowired
//    public PageThreeController(ThirdSentenceValidator thirdSentenceValidator) {
//        this.thirdSentenceValidator = thirdSentenceValidator;
//    }

    @RequestMapping(method = RequestMethod.POST)
    public String handlePost(ModelMap model,
                             @ModelAttribute("PoemSentence") @Valid PoemSentence poemSentence,
                             BindingResult result, SessionStatus status,
                             HttpServletRequest request) {

        HttpSession session = request.getSession();
        //thirdSentenceValidator.validate(poemText, result);

        if (result.hasErrors()) {
            //if validator failed
            model.addAttribute("message", "Please enter the third sentence of the poem:");
            return "page3";
        } else {
            status.setComplete();
            session.setAttribute("thirdSentence", poemSentence.getSentence());
            return "redirect:page4";
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public String onPage(ModelMap model,
                         HttpServletRequest request,
                         @ModelAttribute("PoemSentence") PoemSentence poemSentence) {
        HttpSession session = request.getSession();
        model.addAttribute("message", "Please enter the third sentence of the poem:");
        if(session.getAttribute("thirdSentence")!=null){
            poemSentence.setSentence((String) session.getAttribute("thirdSentence"));
        }
        return "page3";
    }
}
