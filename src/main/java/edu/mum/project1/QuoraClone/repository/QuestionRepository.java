package edu.mum.project1.QuoraClone.repository;

import edu.mum.project1.QuoraClone.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("questionRepository")
public interface QuestionRepository extends CrudRepository<Question, Long> {

}
