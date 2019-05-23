package com.example.springfinal.repository;

import com.example.springfinal.entity.Course;
import com.example.springfinal.entity.Elective;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDetailRepository extends CustomizedRepository<Elective, Integer> {
    /**
     *基于ID，获取指定学生的全部课程
     * @param sid
     * @return
     */
    @Query("select e.course from Elective e where e.student.id=:sid")
    List<Course> list(@Param("sid") int sid);

    @Query("from Elective e where e.course.id=:cid and e.student.id=:sid")
    Course find(@Param("cid") int cid, @Param("sid") int sid);
}
