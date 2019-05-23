package com.example.springfinal.controller;

import com.example.springfinal.entity.*;
import com.example.springfinal.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private CourseService cs;
    @Autowired
    private HomeworkService hs;

    // 教师请求添加课程，添加完成后将该教师的所有课程返回

    @PostMapping("/courses")
    public Map postCourses(@RequestBody Course course, @RequestAttribute int uid){
        course.setTeacher(new User(uid));
        cs.addCourse(course);
        return Map.of("courses", cs.listTeacherCourses(uid));
    }

    //教师布置指定课程的家庭作业，后将家庭该家庭作业返回
    @PostMapping("/courses/{cid}/homeworks")
    public Map postHoworks(@PathVariable int cid,@RequestAttribute int uid,
                           @RequestBody Homework homework){
        hs.addHomework(homework);
        return Map.of("homeworks",homework);
    }
}
