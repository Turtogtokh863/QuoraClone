package edu.mum.project1.QuoraClone.repository;

import edu.mum.project1.QuoraClone.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    User findById(int id);
    List<User> findAll();
}
