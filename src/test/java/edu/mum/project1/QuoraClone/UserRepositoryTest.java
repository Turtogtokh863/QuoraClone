package edu.mum.project1.QuoraClone;

import edu.mum.project1.QuoraClone.model.User;
import edu.mum.project1.QuoraClone.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Test
    public void testAddUser(){
        User user = new User();
        user.setEmail("user@gmail.com");
        user.setPassword("123456789");
        user.setName("UserOne");
        User user1 = userRepository.save(user);
        assertEquals(user.getName(),user1.getName());
    }

}
