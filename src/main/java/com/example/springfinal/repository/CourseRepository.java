package com.example.springfinal.repository;

import com.example.springfinal.entity.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CustomizedRepository<Course, Integer> {
    /**
     * 获取指定教师的全部课程
     * @param tid
     * @return
     */
    @Query("select  c from Course  c where c.teacher.id=:tid")
    List<Course> list(@Param("tid") int tid);

    @Query("from Course c where c.id=:cid and c.teacher.id=:tid")
    Course find(@Param("cid") int cid, @Param("tid") int tid);

}
