package edu.mum.project1.QuoraClone;

import edu.mum.project1.QuoraClone.model.User;
import edu.mum.project1.QuoraClone.repository.UserRepository;
import edu.mum.project1.QuoraClone.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @MockBean
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Test
    public void findUserByEmailTest(){
        User mockUser = new User();
        mockUser.setEmail("test@test.com");
        mockUser.setPassword("123456");
        mockUser.setName("test test");

        Mockito.when(userRepository.findByEmail("test@test.com")).thenReturn(mockUser);
        assertThat(userService.findUserByEmail("test@test.com")).isEqualTo(mockUser);

    }
    @Test
    public void saveUser(){
        User mockUser = new User();
        mockUser.setEmail("test@test.com");
        mockUser.setPassword("123456");
        mockUser.setName("test test");

        Mockito.when(userRepository.save(mockUser)).thenReturn(mockUser);
        assertThat(userService.saveUser(mockUser)).isEqualTo(mockUser);
    }
}
