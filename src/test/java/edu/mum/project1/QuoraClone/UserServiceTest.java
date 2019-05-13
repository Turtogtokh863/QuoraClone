package edu.mum.project1.QuoraClone;

import edu.mum.project1.QuoraClone.model.User;
import edu.mum.project1.QuoraClone.repository.AnswerRepository;
import edu.mum.project1.QuoraClone.repository.QuestionRepository;
import edu.mum.project1.QuoraClone.repository.UserRepository;
import edu.mum.project1.QuoraClone.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest extends QuoraCloneApplicationTests{
    @Mock
    private UserRepository userRepository;
    @Mock
    private AnswerRepository answerRepository;
    @Mock
    private QuestionRepository questionRepository;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @InjectMocks
    UserService userService = new UserService(userRepository,bCryptPasswordEncoder);

    private List<User> users;
    private User user;
    private int id;
    private String email;

    @Before
    public void check(){
        MockitoAnnotations.initMocks(this);
        id = 1;
        email="user@gmail.com";
        user = new User();
        user.setId(id);
        user.setEmail(email);
        when(userRepository.findById(id)).thenReturn(user);
        when(userRepository.findByEmail("user@gmail.com")).thenReturn(user);

        User user1 = new User();
        user1.setName("NameOne");

        User user2 = new User();
        user2.setEmail("user2@gmail.com");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        when(userRepository.findAll()).thenReturn(users);
    }

    @Test
    public void testFindUserById() throws Exception{
        assertEquals(userService.getUserById(id).getId(),id);
    }

    @Test
    public void testFindUserByEmail() throws Exception{
        assertEquals(userService.findUserByEmail(email).getEmail(), email);
    }

    @Test
    public void testFindAll(){
        assertEquals(userService.findAll(), users);
    }
}
