package edu.mum.project1.QuoraClone.control;

import edu.mum.project1.QuoraClone.model.Answer;
import edu.mum.project1.QuoraClone.model.Question;
import edu.mum.project1.QuoraClone.model.User;
import edu.mum.project1.QuoraClone.service.AnswerService;
import edu.mum.project1.QuoraClone.service.QuestionService;
import edu.mum.project1.QuoraClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;


    @RequestMapping(value = "/addquestion", method = RequestMethod.POST)
    public String addquestion(Model model, @ModelAttribute Question question){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        question.setUser(user);
        question.setCreateDate(LocalDate.now());
        if(question.getQuestion_content().isEmpty()){
            return "redirect:/index";
        }else{
            questionService.save(question);
        }
        return "redirect:/index";
    }

    @RequestMapping(value={ "/index"}, method = RequestMethod.GET)
    public String questions(Model model, @ModelAttribute Question question){
        model.addAttribute("question", new Question());
        model.addAttribute("listofquestions", questionService.getAllQuestion());
        return "index";
    }

    @RequestMapping(value = {"/inc_upvote/{id}"}, method = RequestMethod.GET)
    public String increaseUpvote(@PathVariable int id, Model model){
        Answer answer = answerService.getAnswerById(id);
        int q_id = answer.getQuestion().getId();
        answer.incrementUpvote();
        answerService.save(answer);
        return "redirect:/questions/" + answer.getQuestion().getId();
    }

    @RequestMapping(value={ "/questions/{id}"}, method = RequestMethod.GET)
    public String questionById(@PathVariable int id, Model model){
        Question question = questionService.getQuestionById(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        Answer answer = new Answer();
        int totalAnswer = question.getAnswer().size();
        answer.setQuestion(question);
        model.addAttribute("question", question);
        model.addAttribute("answer", answer);
        if(totalAnswer <2){
            model.addAttribute("totalAnswer", totalAnswer + " Answer");
        }
        else{
            model.addAttribute("totalAnswer",totalAnswer + " Answers");
        }
        model.addAttribute("user_name", user.getName() + " " + user.getLastName());
        model.addAttribute("question_user_name", question.getUser().getName() + " " + question.getUser().getLastName());
        return "question";
    }

    @RequestMapping(value={ "/addAnswer"}, method = RequestMethod.POST)
    public String addAnswer(Model model, @ModelAttribute Answer answer){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        answer.setUser(user);
        answer.setCreateDate(LocalDate.now());
        answerService.save(answer);
        return "redirect:/questions/" + answer.getQuestion().getId();
    }
}