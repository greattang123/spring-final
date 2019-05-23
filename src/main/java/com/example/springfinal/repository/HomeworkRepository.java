package com.example.springfinal.repository;

import com.example.springfinal.entity.Homework;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeworkRepository extends CustomizedRepository<Homework, Integer> {
    /**
     * 获取指定教师和其讲授所有课程的全部家庭作业
     *
     * @param cid
     * @param tid
     * @return
     */
    @Query("select h from Homework h where h.course.id=:cid and h.course.teacher.id=:tid")
    List<Homework> listByTeacher(@Param("cid") int cid, @Param("tid") int tid);

    /**
     * 基于学生学号和课程编号，查询该学生此门课程的所有家庭作业
     * @param cid
     * @param sid
     * @return`
     */
    @Query("SELECT h FROM Homework h LEFT JOIN Elective e ON h.course.id=e.course.id " +
            "WHERE h.course.id=:cid AND e.student.id=:sid")
    List<Homework> listByStudent(@Param("cid") int cid, @Param("sid") int sid);

}

