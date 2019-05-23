package com.example.springfinal.service;

import com.example.springfinal.entity.Course;
import com.example.springfinal.repository.CourseDetailRepository;
import com.example.springfinal.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseService {
    @Autowired
    private CourseRepository cr;
    @Autowired
    private CourseDetailRepository cdr;

    //获取指定教师的全部课程
    public List<Course> listTeacherCourses(int tid) {
        return cr.list(tid);
    }

    //获取指定学生的全部课程
    public List<Course> listStudentCourses(int sid) {
        return cdr.list(sid);
    }

    //增加课程
    public Course addCourse(Course course) {
        return cr.refresh(cr.save(course));
    }

    //基于指定教师和指定课程查找课程信息
    public Course getTeacherCourse(int cid, int tid) {
        return cr.find(cid, tid);
    }

    //基于指定学生和指定课程查找课程信息
    public Course getStudentCourse(int cid, int sid) {
        return cdr.find(cid, sid);
    }
}

