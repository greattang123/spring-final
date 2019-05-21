package com.example.springfinal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
//作业清单 分解关系，便于维护
public class HomeworkList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*一个学生可能不止一份家庭作业，一份家庭作业里面可能不止一门课程
    ，一门课程可能有多个作业内容*/
    @Column(columnDefinition = "TEXT")
    private String concreteContent;
    @ManyToOne(fetch = FetchType.LAZY)
    private User student;
    @ManyToOne(fetch = FetchType.LAZY)
    private Homework homework;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP",
            updatable = false, insertable = false)
    private LocalDateTime completeTime;
}
