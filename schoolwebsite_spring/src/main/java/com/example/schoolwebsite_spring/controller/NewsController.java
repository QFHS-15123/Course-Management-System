package com.example.schoolwebsite_spring.controller;

import com.example.schoolwebsite_spring.bean.SeeNews;
import com.example.schoolwebsite_spring.bean.Student;
import com.example.schoolwebsite_spring.bean.Teacher;
import com.example.schoolwebsite_spring.dao.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class NewsController {
    @Autowired
    NewsDao newsDao;

    @RequestMapping ("/getnews")
    public List<SeeNews> getnews() {
        return newsDao.getAllNews();
    }

    @RequestMapping ("/getstunews")
    public List<SeeNews> getstunews(@RequestBody Student student) {
        return newsDao.getStuNews(student.getStu_id());
    }

    @RequestMapping ("/getteanews")
    public List<SeeNews> getteanews(@RequestBody Teacher teacher) {
        return newsDao.getTeaNews(teacher.getTea_id());
    }
    
    @RequestMapping("/addnews")
    public String addnews(@RequestBody SeeNews seeNews){
        newsDao.addNews(seeNews.getNews_name(), seeNews.getNews_info(),
                seeNews.getNews_uptime(), seeNews.getCour_id(), seeNews.getTea_id());
        return "ok";
    }

}
