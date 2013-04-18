package com.myPoemGenerator.controller;

import com.myPoemGenerator.model.PoemText;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page3")
public class PageThreeController {
    @RequestMapping(method = RequestMethod.POST)
    public String printPage3(ModelMap model,
                             @ModelAttribute("PoemText") PoemText poemText,
                             HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("secondSentence",poemText.getSecondSentence());
        model.addAttribute("message", "Please enter the third sentence of the poem:");
        return "page3";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String rePrintPage3(ModelMap model,
                             @ModelAttribute("PoemText") PoemText poemText) {
        model.addAttribute("message", "Please enter the third sentence of the poem:");
        return "page1";
    }
}
