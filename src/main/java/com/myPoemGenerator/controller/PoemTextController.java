package com.myPoemGenerator.controller;

import com.myPoemGenerator.model.PoemText;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/poemText.htm")
public class PoemTextController extends SimpleFormController{

    public PoemTextController(){
        setCommandClass(PoemText.class);
        setCommandName("poemText");
    }

    @RequestMapping(method = RequestMethod.POST)
    public String printPage2(ModelMap model,HttpServletRequest request,
                            @RequestParam(value="sentenceText",required=false)String sentenceText,
                            @RequestParam("nextAction")String nextAction) {
        HttpSession session = request.getSession();
//        session.setAttribute("firstSentence",firstSentence);
//        model.addAttribute("message", "Please enter the second sentence of the poem:");
//        return "page2";
        if(nextAction.equals("firstSentence")){
            return "firstPage";
        }
        if(nextAction.equals("secondSentence")){
            session.setAttribute("firstSentence",sentenceText);
            return "secondPage";
        }
        else{
            return "firstPage";
        }
    }

}

