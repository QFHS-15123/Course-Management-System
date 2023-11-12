package com.example.schoolwebsite_spring.controller;

import com.alibaba.fastjson.JSON;
import com.example.schoolwebsite_spring.bean.Course;
import com.example.schoolwebsite_spring.bean.Teacher;
import com.example.schoolwebsite_spring.bean.Vuser;
import com.example.schoolwebsite_spring.dao.GetCourseDao;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class GetCourseController {
    @Autowired
    GetCourseDao getCourseDao;

    @RequestMapping("/getcourses")
    public String getcournames(@RequestBody Teacher teacher) {
        List<Course> cour = getCourseDao.getCourses(teacher.getTea_id());
        HashMap<String, Object> res = new HashMap<>();
        res.put("courses", cour);
        return JSON.toJSONString(res);
    }
}

