package com.godcoder.myhome.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity // model Class라는것을 알림
@Data
public class User {
    @Id // pk라는것을 알림
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가
    private Long id;

    private String username;
    private String password;
    private String enabled;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
}
