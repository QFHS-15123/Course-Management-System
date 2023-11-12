package com.example.schoolwebsite_spring.dao;

import com.example.schoolwebsite_spring.bean.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetCourseDao {
    List<Course> getCourses(@Param("tea_id") String tea_id);
}
