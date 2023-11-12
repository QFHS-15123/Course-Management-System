package com.example.schoolwebsite_spring.dao;

import com.example.schoolwebsite_spring.bean.Vuser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VuserDao {
    public Vuser selectVuser(@Param("account") String account, @Param("password") String password);

    public String getName(@Param("account") String account);

    public void setStuPw(@Param("stu_id") String account, @Param("stu_pw") String password);

    public void setTeaPw(@Param("tea_id") String account, @Param("tea_pw") String password);
}
