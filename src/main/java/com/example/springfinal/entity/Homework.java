package com.example.springfinal.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
//家庭作业
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //课程名称
    private String name;
    //课程作业详细内容
    @Column(columnDefinition = "TEXT")
    private String content;
    //家庭作业只与课程关联，而不与学生关联，便于维护，符合常理
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime deadLineTime;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            updatable = false,
            insertable = false)
    private LocalDateTime insertTime;
    public Homework(int id){
        this.id=id;
    }
}
