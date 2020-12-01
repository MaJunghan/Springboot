package com.godcoder.myhome.model;


import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity // model Class라는것을 알림
@Data
public class Board {
    @Id // pk라는것을 알림
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가
    private Long id;
    @NotNull
    @Size(min=2, max=30, message = "제목은 2글자와 30글자 사이입니다.")
    private String title;
    private String content;
}
