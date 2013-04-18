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
@RequestMapping("/result.htm")
public class ResultController {
    @RequestMapping(method = RequestMethod.POST)
    public String printResult(ModelMap model,
                              HttpServletRequest request,
                              @ModelAttribute("PoemText") PoemText poemText) {
        HttpSession session = request.getSession();
        session.setAttribute("forthSentence",poemText.getForthSentence());
        return "result";
    }
}
