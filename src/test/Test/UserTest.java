package edu.mum.project1.QuoraClone;

import edu.mum.project1.QuoraClone.AnswerTest;
import edu.mum.project1.QuoraClone.model.User;
import edu.mum.project1.QuoraClone.repository.UserRepository;
import edu.mum.project1.QuoraClone.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;

public class UserTest {
    @MockBean
    UserRepository userRepository;
    @Autowired
    User mockUser;;
    @Autowired
    User user;
    @Before
    public void setUp() throws Exception {
        user=new User();
        user.setName("habtom");
        user.setLastName("gebre");
        user.setEmail("user@gmail.com");
        user.setPassword("123456");
        user.setId(1);

    }
    @Test
    public void getId(){
            Assert.assertEquals(1,user.getId());
        }

    @Test
    public void getEmail() {
        Assert.assertEquals("user@gmail.com",user.getEmail());
    }

    @Test
    public void getPassword() {
        Assert.assertEquals("123456",user.getPassword());
    }

    @Test
    public void getName() {
        Assert.assertEquals("habtom",user.getName());
    }

    @Test
    public void getLastName() {
        Assert.assertEquals("gebre",user.getLastName());
    }


}