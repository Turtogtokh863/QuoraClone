package edu.mum.project1.QuoraClone.service;

import edu.mum.project1.QuoraClone.model.Answer;
import edu.mum.project1.QuoraClone.repository.AnswerRepository;
import edu.mum.project1.QuoraClone.repository.QuestionRepository;
import edu.mum.project1.QuoraClone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {
    private UserRepository userRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    public AnswerService(){

    }

    @Autowired
    public AnswerService(UserRepository u_Repository,
                           AnswerRepository a_Repository,
                           QuestionRepository q_Repository){
        this.answerRepository = a_Repository;
        this.questionRepository = q_Repository;
        this.userRepository = u_Repository;
    }

    public List getAllAnswer(){
        List<Answer> list = new ArrayList();
        answerRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public String getAnswerById(int id){
        String answer =answerRepository.findById(id).getAnswer_content();
        return answer;
    }

    public boolean save(Answer answer){
        try{
            answerRepository.save(answer);
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    public boolean deleteAnswerById(Long id){
        try{
            answerRepository.deleteById(id);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}
