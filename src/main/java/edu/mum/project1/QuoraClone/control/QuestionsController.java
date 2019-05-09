package edu.mum.project1.QuoraClone.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QuestionsController {

    @RequestMapping(value={ "/questions"}, method = RequestMethod.GET)
    public ModelAndView questions(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("questions");
        return modelAndView;
    }
}
