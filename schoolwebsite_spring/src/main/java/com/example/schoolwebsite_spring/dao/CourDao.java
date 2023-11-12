package com.example.schoolwebsite_spring.dao;

import com.example.schoolwebsite_spring.bean.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourDao {
//    public List<SeeProj> getAllProj();
    public void upCour(@Param("cour_id") String cour_id, @Param("cour_intro") String cour_intro);

    List<SeeStuCour> getStuCour(@Param("stu_id") String stu_id);
    List<Course> getTeaCour(@Param("tea_id") String tea_id);

    List<Course> getTeaStuCour(Tea_cour tea_cour);
}
