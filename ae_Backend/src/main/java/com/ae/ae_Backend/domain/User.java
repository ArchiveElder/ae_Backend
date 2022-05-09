package com.ae.ae_Backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity(name = "user")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long user_id;

    private String name;
    private int gender;
    private String birth_year;
    private String signup_date;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Memory> memories = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<UserAns> userAnswers = new ArrayList<>();

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Diary diary;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<mmseAns> mmse_answers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<userdata> userdatas = new ArrayList<>();
}
