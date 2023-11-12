package com.example.schoolwebsite_spring.dao;

import com.example.schoolwebsite_spring.bean.SeeProj;
import com.example.schoolwebsite_spring.bean.SeeTeaProj;
import com.example.schoolwebsite_spring.bean.SeeTeaStuProj;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjDao {
    public List<SeeProj> getAllProj();

    public List<SeeProj> getStuProj(@Param("stu_id") String stu_id);
    public List<SeeTeaProj> getTeaProj(@Param("tea_id") String tea_id);
    public void addProj(@Param("proj_name") String proj_name,
                        @Param("proj_info") String proj_info, @Param("proj_uptime") String proj_uptime,
                        @Param("cour_id") String cour_id, @Param("proj_ddl") String proj_ddl);

    List<SeeTeaStuProj> getTeaStuProj(@Param("cour_id")String cour_id);
}
