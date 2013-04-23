package com.myPoemGenerator.controller;

import com.myPoemGenerator.model.PoemText;
import com.myPoemGenerator.validator.ThirdSentenceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page3")
public class PageThreeController {

    ThirdSentenceValidator thirdSentenceValidator;

    @Autowired
    public PageThreeController(ThirdSentenceValidator thirdSentenceValidator) {
        this.thirdSentenceValidator = thirdSentenceValidator;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String validatePage3(ModelMap model,
                             @ModelAttribute("PoemText") PoemText poemText,
                             BindingResult result, SessionStatus status,
                             HttpServletRequest request) {

        HttpSession session = request.getSession();
        thirdSentenceValidator.validate(poemText, result);

        if (result.hasErrors()) {
            //if validator failed
            model.addAttribute("message", "Please enter the third sentence of the poem:");
            return "page3";
        } else {
            status.setComplete();
            session.setAttribute("thirdSentence", poemText.getThirdSentence());
            return "redirect:page4";
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printPage3(ModelMap model,
                               HttpServletRequest request,
                               @ModelAttribute("PoemText") PoemText poemText) {
        HttpSession session = request.getSession();
        model.addAttribute("message", "Please enter the third sentence of the poem:");
        if(session.getAttribute("thirdSentence")!=null){
            poemText.setThirdSentence((String)session.getAttribute("thirdSentence"));
        }
        return "page3";
    }
}
