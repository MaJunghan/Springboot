package com.godcoder.myhome.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // model Class라는것을 알림
@Data
public class Board {
    @Id // pk라는것을 알림
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가
    private long id;
    private String title;
    private String content;
}
