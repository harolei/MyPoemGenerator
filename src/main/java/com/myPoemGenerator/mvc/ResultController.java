package com.myPoemGenerator.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/result.htm")
public class ResultController {
    @RequestMapping(method = RequestMethod.POST)
    public String printResult(ModelMap model,@RequestParam("forthSentence")String forthSentence,HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("forthSentence",forthSentence);
        return "result";
    }
}
