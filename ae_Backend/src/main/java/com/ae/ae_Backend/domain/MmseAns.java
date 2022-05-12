package com.ae.ae_Backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "mmse_ans")
@Getter @Setter
public class MmseAns {
    @Id @GeneratedValue
    @Column(name = "mmse_ans_id")
    private Long mmse_ans_id;
    private String answer;
    private String answer_url;
    private String server_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mmse_list_id")
    private MmseList mmseList;

    public static MmseAns createMmseAnswer(User user, MmseList mmseList, String answer) {
        MmseAns mmseAnswer = new MmseAns();
        mmseAnswer.setUser(user);
        mmseAnswer.setMmseList(mmseList);
        mmseAnswer.setAnswer(answer);

        return mmseAnswer;
    }



}
