package edu.mum.project1.QuoraClone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "question")
public class Question implements Comparable<Question>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int id;
    @Column(name = "question_content")
    private String question_content;
    @Column(name = "topic")
    private String topic;
    @Column(name = "created_at")
    private LocalDate createDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "question")
    private List<Answer> answer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public List<Answer> getSortedAnswers(){
        Collections.sort(answer);
        return answer;
    }

    @Override
    public int compareTo(Question compareQuestion) {
        int compareDate=((Question)compareQuestion).getCreateDate().getDayOfMonth();
        return compareDate - this.createDate.getDayOfMonth();
    }

}
