package com.example.schoolwebsite_spring.dao;

import com.example.schoolwebsite_spring.bean.SeeNews;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsDao {
    public List<SeeNews> getAllNews();

    public List<SeeNews> getStuNews(@Param("stu_id") String stu_id);
    public List<SeeNews> getTeaNews(@Param("tea_id") String tea_id);
    public void addNews(@Param("news_name") String news_name,
                        @Param("news_info") String news_info, @Param("news_uptime") String news_uptime,
                        @Param("cour_id") String cour_id, @Param("tea_id") String tea_id);
}
