package com.example.springfinal.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    public static final int USER_AUTHORITY = 1;
    public static final int ADMIN_AUTHORITY = 2;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;
    private String name;
    private String clazz;
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    //禁止password序列化
    private String password;
    //未声明时默认为1
    private int authority=1;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
    updatable = false,
    insertable = false)
    private LocalDateTime insertTime;
    //不设置OneToMany关联
    public User(int id){
        this.id=id;
    }
}
