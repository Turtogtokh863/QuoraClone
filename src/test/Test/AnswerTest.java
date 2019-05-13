package edu.mum.project1.QuoraClone;

import edu.mum.project1.QuoraClone.model.Answer;
import edu.mum.project1.QuoraClone.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class AnswerTest {
    Answer a;
    @Autowired
    private edu.mum.project1.QuoraClone.model.User user;

    @Before
    public void setUp() throws Exception {
        a = new Answer();
        a.setAnswer_content("my birth day is tomorrow");
        a.setCreateDate(LocalDate.now());
        a.setId(0);
        a.setUpvote(3);
        a.setUser(user);


    }

    @Test
    public void getId() {
        Assert.assertEquals(0, a.getId());
    }


    @Test
    public void getAnswer_content() {
        Assert.assertEquals("my birth day is tomorrow", a.getAnswer_content());
    }

    @Test
    public void getCreateDate() {
        Assert.assertEquals(LocalDate.now(), a.getCreateDate());
    }


    @Test
    public void getUser() {
        Assert.assertEquals(user, a.getUser());
    }




}

