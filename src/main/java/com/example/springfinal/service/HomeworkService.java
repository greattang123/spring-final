package com.example.springfinal.service;

import com.example.springfinal.entity.Homework;
import com.example.springfinal.repository.HomeworkListRepository;
import com.example.springfinal.repository.HomeworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HomeworkService {
    @Autowired
    private HomeworkRepository hr;

    //增加课程
    public Homework addHomework(Homework homework) {
        return hr.refresh(hr.save(homework));
    }


    //基于指定课程和教师查找所有家庭作业
    public List<Homework> listTeacherHomeworks(int cid, int tid) {
        return hr.list(cid, tid);
    }

    //基于指定课程和学生查找所有课程作业
    public List<Homework> listStudentHomeworks(int cid, int sid) {
        return hr.listByStudent(cid, sid);
    }
}
