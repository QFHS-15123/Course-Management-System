package com.example.schoolwebsite_spring.controller;

import com.alibaba.fastjson.JSON;
import com.example.schoolwebsite_spring.bean.Vuser;
import com.example.schoolwebsite_spring.dao.VuserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

//注解：此为controller类
@RestController
public class LoginController {
    //  注解：自动注入
    @Autowired
    VuserDao vuserDao;

    //登录
    @RequestMapping("/login")
    public String login(@RequestBody Vuser vuser){
        String flag="error";
        Vuser vuser1=vuserDao.selectVuser(vuser.getAccount(), vuser.getPassword());
        HashMap<String,Object> res=new HashMap<>();
        String vuser1_state = null;
        if(vuser1!=null){
            flag="ok";
            vuser1_state = vuser1.getState();
        }
        res.put("flag",flag);
        res.put("state",vuser1_state);
        return JSON.toJSONString(res);
    }

    @RequestMapping("/getname")
    public String getname(@RequestBody Vuser vuser){
        return (String) vuserDao.getName(vuser.getAccount());
    }

    @RequestMapping("/setpw")
    public String setpw(@RequestBody Vuser vuser){
        if (vuser.getAccount().length() == 3){
            vuserDao.setTeaPw(vuser.getAccount(), vuser.getPassword());
        }else{
            vuserDao.setStuPw(vuser.getAccount(), vuser.getPassword());
        }
        return "ok";
    }
}
