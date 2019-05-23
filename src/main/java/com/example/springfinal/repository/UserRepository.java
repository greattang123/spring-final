package com.example.springfinal.repository;

import com.example.springfinal.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CustomizedRepository<User, Integer> {
    @Query("select u from User u where u.number=:number")
    User find(@Param("number") String number);
}
