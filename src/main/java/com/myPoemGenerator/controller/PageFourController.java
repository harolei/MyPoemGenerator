package com.myPoemGenerator.controller;

import com.myPoemGenerator.model.PoemText;
import com.myPoemGenerator.validator.ForthSentenceValidator;
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
@RequestMapping("/page4")
public class PageFourController {

    ForthSentenceValidator forthSentenceValidator;

    @Autowired
    public PageFourController(ForthSentenceValidator forthSentenceValidator) {
        this.forthSentenceValidator = forthSentenceValidator;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String validatePage4(ModelMap model,
                             @ModelAttribute("PoemText") PoemText poemText,
                             BindingResult result, SessionStatus status,
                             HttpServletRequest request) {
        HttpSession session = request.getSession();
        forthSentenceValidator.validate(poemText, result);

        if (result.hasErrors()) {
            //if validator failed
            model.addAttribute("message","Please enter the forth sentence of the poem:");
            return "page4";
        } else {
            status.setComplete();
            session.setAttribute("forthSentence", poemText.getForthSentence());
            return "redirect:result";
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public String rePrintPage4(ModelMap model,
                               HttpServletRequest request,
                               @ModelAttribute("PoemText") PoemText poemText) {
        HttpSession session = request.getSession();
        model.addAttribute("message", "Please enter the forth sentence of the poem:");
        if(session.getAttribute("forthSentence")!=null){
            poemText.setForthSentence((String)session.getAttribute("forthSentence"));
        }
        return "page4";
    }
}
