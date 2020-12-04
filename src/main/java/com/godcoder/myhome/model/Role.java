package com.godcoder.myhome.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity // model Class라는것을 알림
@Data
public class Role {
    @Id // pk라는것을 알림
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가
    private Long id;

    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
