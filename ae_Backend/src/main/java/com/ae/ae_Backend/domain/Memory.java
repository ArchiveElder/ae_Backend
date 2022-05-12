package com.ae.ae_Backend.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity(name = "memory")
@Table(name = "memory")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Memory {
    @Id
    @GeneratedValue
    @Column(name = "memory_id")
    private Long memory_id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;
    private String image;
    private String text;
    private String server_date;
    private String user_date;

    //==연관관계 메서드==//
    public void setUser(User user) {
        this.user = user;
        user.getMemories().add(this);
    }

    //==생성 메서드==//
    public static Memory createMemory(User user) {
        Memory memory = new Memory();
        memory.setUser(user);
        memory.setTitle(memory.title);
        memory.setImage(memory.image);
        memory.setText(memory.text);
        memory.setServer_date(String.valueOf(LocalDateTime.now()));
        memory.setUser_date(memory.user_date);
        return memory;
    }
}
