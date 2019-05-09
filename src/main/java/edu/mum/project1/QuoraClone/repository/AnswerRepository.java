package edu.mum.project1.QuoraClone.repository;

import edu.mum.project1.QuoraClone.model.Answer;
import edu.mum.project1.QuoraClone.model.Question;
import edu.mum.project1.QuoraClone.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
    Answer findById(int id);
    Answer findByQuestion(Question question);
    Answer findByUser(User user);

}
