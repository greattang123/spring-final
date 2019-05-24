package com.example.springfinal.controller;

import com.example.springfinal.entity.*;
import com.example.springfinal.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService us;
    @Autowired
    private CourseService cs;
    @Autowired
    private HomeworkService hs;

    /**
     * 仅在main页面，显示全部课程
     *
     * @param uid
     * @param aid
     * @return
     */
    @GetMapping("/main")
    public Map getMain(@RequestAttribute int uid, @RequestAttribute int aid) {
        List<Course> courses = null;
        if (aid == User.USER_AUTHORITY) {
            courses = cs.listStudentCourses(uid);
        }
        if (aid == User.ADMIN_AUTHORITY) {
            courses = cs.listTeacherCourses(uid);
        }
        return Map.of("courses", courses);
    }

    //基于指定ID查找课程
    @GetMapping("/courses/{cid}")
    public Map getCourse(@PathVariable int cid, @RequestAttribute int uid,
                         @RequestAttribute int aid) {
        Course course = null;
        if (aid == User.USER_AUTHORITY) {
            course = cs.getStudentCourse(cid, uid);
        }
        if (aid == User.ADMIN_AUTHORITY) {
            course = cs.getTeacherCourse(cid, uid);
        }
        Optional.ofNullable(course)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "资源不存在"));
        return Map.of("course", course);
    }

    //根据课程查找其全部家庭作业
    @GetMapping("/courses/{cid}/homeworks")
    public Map getHomeworks(@PathVariable int cid, @RequestAttribute int uid, @RequestAttribute int aid) {
        List<Homework> homeworks = null;
        if (aid == User.USER_AUTHORITY) {
            homeworks = hs.listStudentHomeworks(cid, uid);
        }
        if (aid == User.ADMIN_AUTHORITY) {
            homeworks = hs.listTeacherHomeworks(cid, uid);
        }

        return Map.of("homeworks", homeworks);
    }
}
