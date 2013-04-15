package com.myPoemGenerator.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page2.htm")
public class PageTwoController {
    @RequestMapping(method = RequestMethod.POST)
    public String printPage2(ModelMap model,@RequestParam("firstSentence")String firstSentence,HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("firstSentence",firstSentence);
        model.addAttribute("message", "Please enter the second sentence of the poem:");
        return "page2";
    }
}
