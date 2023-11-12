package com.example.schoolwebsite_spring.dao;

import com.example.schoolwebsite_spring.bean.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao {
    public  int getStuCounts(@Param("stu_id") String stu_id);

    public Student selectStudent(@Param("stu_id") String stu_id, @Param("stu_pw") String stu_pw);
}
