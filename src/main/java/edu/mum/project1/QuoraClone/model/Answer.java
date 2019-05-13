package edu.mum.project1.QuoraClone.model;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "answer")
@ToString(exclude = {"question"})
public class Answer implements Comparable<Answer>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "answer_id")
    private int id;
    @Column(name = "answer_content")
    private String answer_content;
    @Column(name = "created_at")
    private LocalDate createDate;
    @Column(name = "upvote")
    private int upvote;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public void incrementUpvote(){
        upvote++;
    }

    @Override
    public int compareTo(Answer compareAnswer) {
        int compareUpvote=((Answer)compareAnswer).getUpvote();
        return compareUpvote - this.upvote;
    }

}
