package edu.mum.project1.QuoraClone.control;

import edu.mum.project1.QuoraClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuestionController {



     @RequestMapping(value={ "/questions"}, method = RequestMethod.GET)
    public ModelAndView questions(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("questions");
        return modelAndView;
    }

}
