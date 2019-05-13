package edu.mum.project1.QuoraClone.control;

import edu.mum.project1.QuoraClone.model.Question;
import edu.mum.project1.QuoraClone.service.QuestionService;
import edu.mum.project1.QuoraClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;


@Controller
public class GraphController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserService userService;

    @GetMapping("/displayBarGraph")
    public String barGraph(Model model) {
        model.addAttribute("listofquestions", questionService.getAllQuestion());
        List<Question> list_q = new ArrayList<>();
        list_q = questionService.getAllQuestion();
        int count = 1;
        HashMap<Integer, Integer> surveyMap = new HashMap<Integer, Integer>();
        for(Question q : list_q){
            int dOM = q.getCreateDate().getDayOfMonth();
            if(surveyMap.containsKey(dOM)){
                surveyMap.put(dOM, surveyMap.get(dOM)+1);
            }else{
                surveyMap.put(q.getCreateDate().getDayOfMonth(),count);
            }
        }
        model.addAttribute("surveyMap", surveyMap);
        return "barGraph";
    }
}
