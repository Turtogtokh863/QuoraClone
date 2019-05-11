package edu.mum.project1.QuoraClone.control;

import edu.mum.project1.QuoraClone.model.Question;
import edu.mum.project1.QuoraClone.model.User;
import edu.mum.project1.QuoraClone.service.QuestionService;
import edu.mum.project1.QuoraClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class QuestionController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;


    @RequestMapping(value = "/addquestion", method = RequestMethod.POST)
    public String addquestion(Model model, @ModelAttribute Question question){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        model.addAttribute("question", new Question());
        question.setUser(user);
        questionService.save(question);
        return "redirect:/index";
    }





    @RequestMapping(value={ "/index"}, method = RequestMethod.GET)
    public String questions(Model model, @ModelAttribute Question question){
        model.addAttribute("newquestion", new Question());
        model.addAttribute("listofquestions", questionService.getAllQuestion());
        return "index";
    }

    @RequestMapping(value={ "/questions/{id}"}, method = RequestMethod.GET)
    public String questionById(@PathVariable int id, Model model){
        String quest = questionService.getQuestionById(id);
        model.addAttribute("questionById", quest);
        return "questions";
    }

    @RequestMapping(value={ "/questions"}, method = RequestMethod.GET)
    public String questionBy(Model model, @ModelAttribute Question question){
        return "questions";
    }
}
