package com.example.schoolwebsite_spring.controller;

import com.example.schoolwebsite_spring.bean.*;
import com.example.schoolwebsite_spring.dao.CourDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourController {
    @Autowired
    CourDao courDao;

    @RequestMapping ("/getstucour")
    public List<SeeStuCour> getstucour(@RequestParam("stu_id") String stu_id) {
        return courDao.getStuCour(stu_id);
    }

    @RequestMapping ("/getteacour")
    public List<Course> getteacour(@RequestParam("tea_id") String tea_id) {
        return courDao.getTeaCour(tea_id);
    }

    @RequestMapping("/upcour")
    public String upcour(@RequestBody Course course){
        courDao.upCour(course.getCour_id(), course.getCour_intro());
        return "ok";
    }

}
