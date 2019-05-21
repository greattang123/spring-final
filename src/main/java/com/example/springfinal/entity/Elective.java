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
//选课
public class Elective {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //由于选课只是关系，故不需要name，ID标识足够
    private int id;
    //一个学生可以选多门课，将学生直接与选课编号绑定
    @ManyToOne(fetch = FetchType.LAZY)
    private User student;
    /*一门课可以被多个学生选，但课程并不与学生直接关联，而是与教师关联，
    故一门课程对应多门选课，从而间接与学生绑定*/
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            updatable = false,
            insertable = false)
    private LocalDateTime insertTime;
}
