package com.example.springfinal.repository;

import com.example.springfinal.entity.HomeworkList;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkListRepository extends CustomizedRepository<HomeworkList,Integer> {

}
