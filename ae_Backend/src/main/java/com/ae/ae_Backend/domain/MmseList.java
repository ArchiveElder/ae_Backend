package com.ae.ae_Backend.domain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mmse_list")
@Getter @Setter
public class MmseList {
    @Id @GeneratedValue
    @Column(name = "mmse_list_id")
    private Long mmse_list_id;
    private String icon;
    private String question;
    private String voice_q_url;

    @OneToMany(mappedBy = "mmse_list")
    private List<MmseAns> mmse_ans = new ArrayList<>();




}
