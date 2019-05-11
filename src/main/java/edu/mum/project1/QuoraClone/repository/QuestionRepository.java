package edu.mum.project1.QuoraClone.repository;

import edu.mum.project1.QuoraClone.model.Question;
import edu.mum.project1.QuoraClone.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {
    Question findById(int id);
    Question findByTopic(String topic);
    Question findByUser(User user);
}
