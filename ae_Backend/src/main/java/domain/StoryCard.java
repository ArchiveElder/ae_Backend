package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;


@Entity
@Getter
public class StoryCard {
    @Id
    @GeneratedValue
    @Column(name = "storycard_id")
    private Long id;

    /*
    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;
     */

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_answer_id")
    private UserAnswer useranswer;

    private String question;
}
