package com.myPoemGenerator.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page3.htm")
public class PageThreeController {
    @RequestMapping(method = RequestMethod.POST)
    public String printPage3(ModelMap model,@RequestParam("secondSentence")String secondSentence,HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("secondSentence",secondSentence);
        model.addAttribute("message", "Please enter the third sentence of the poem:");
        return "page3";
    }
}
