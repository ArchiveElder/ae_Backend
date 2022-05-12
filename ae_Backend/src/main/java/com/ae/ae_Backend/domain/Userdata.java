package com.ae.ae_Backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="userdata")
@Getter @Setter
public class Userdata {
    @Id @GeneratedValue
    @Column(name = "userdata_id")
    private Long userdata_id;

    private String mci_score;
    private String result_date;
    private String mmse_result;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;




}


