package com.myPoemGenerator.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page4.htm")
public class PageFourController {
    @RequestMapping(method = RequestMethod.POST)
    public String printPage4(ModelMap model,@RequestParam("thirdSentence")String thirdSentence,HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("thirdSentence",thirdSentence);
        model.addAttribute("message", "Please enter the forth sentence of the poem:");
        return "page4";
    }
}
