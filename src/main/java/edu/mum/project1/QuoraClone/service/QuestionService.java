package edu.mum.project1.QuoraClone.service;

import edu.mum.project1.QuoraClone.model.Answer;
import edu.mum.project1.QuoraClone.model.Question;
import edu.mum.project1.QuoraClone.repository.AnswerRepository;
import edu.mum.project1.QuoraClone.repository.QuestionRepository;
import edu.mum.project1.QuoraClone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;
    private UserRepository userRepository;
    private AnswerRepository answerRepository;

    public QuestionService(){

    }

    @Autowired
    public QuestionService(QuestionRepository q_Repositor,
                           UserRepository u_Repositor,
                           AnswerRepository a_Repositor){
        this.userRepository = u_Repositor;
        this.questionRepository = q_Repositor;
        this.answerRepository = a_Repositor;
    }
    public List getAllQuestion(){
        List list = new ArrayList();
        questionRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public Question getQuestionById(int id){
        return questionRepository.findById(id);
    }

    public boolean save(Question question){

        try{
            questionRepository.save(question);
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    public boolean deleteQuestionById(int id){

        try{
            questionRepository.deleteById(id);
            return true;
        }catch(Exception ex){
            return false;
        }
    }


}
