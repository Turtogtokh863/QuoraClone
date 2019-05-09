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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class QuestionController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    java.util.logging.Logger logger = Logger.getLogger(this.getClass().getName());

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String home(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        int userID = user.getId();
        List<User> userList = userService.findAll();

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == userID) {
                userList.remove(i);
                break;
            }
        }

        for (User obj : userList) {
            logger.info(obj.getName());
            for (Question q : obj.getQuestions()) {
                logger.info(q.getQuestion_content());
            }
        }
        model.addAttribute("question", new Question());
        model.addAttribute("logged",  "Welcome" + user.getName());
        return "index";
    }

    @PostMapping("/addquestion")
    public String addquestion(Model model, @ModelAttribute Question question){
        logger.info(question.getQuestion_content());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        model.addAttribute("question", new Question());
        question.setUser(user);
        questionService.save(question);
        return "index";
    }
}
