package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class UserAnswer {
    @Id
    @GeneratedValue
    @Column(name = "user_answer_id")
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "useranswer", fetch = LAZY, cascade = CascadeType.ALL)
    private StoryCard storycard;
}
