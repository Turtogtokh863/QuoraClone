package edu.mum.project1.QuoraClone.model;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(callSuper = false, exclude = {"answers","questions"})
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "email")
    @NotEmpty(message = "*Please provide an email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "active")
    private int active;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_answers")
    private List<Answer> answers;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_questions")
    private List<Question> questions;

    public List<Question> getSortedQuestion(){
        Collections.sort(questions);
        return questions;
    }
}
