package com.example.schoolwebsite_spring.controller;

import com.example.schoolwebsite_spring.bean.*;
import com.example.schoolwebsite_spring.dao.ProjDao;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

@RestController
public class ProjController {
    @Autowired
    ProjDao projDao;

    @RequestMapping ("/getproj")
    public List<SeeProj> getproj() {
        return projDao.getAllProj();
    }

    @RequestMapping ("/getstuproj")
    public List<SeeProj> getstuproj(@RequestParam("stu_id") String stu_id) {
        return projDao.getStuProj(stu_id);
    }

    @RequestMapping ("/getteaproj")
    public List<SeeTeaProj> getteaproj(@RequestParam("tea_id") String tea_id) {
        return projDao.getTeaProj(tea_id);
    }

    @RequestMapping ("/getteastuproj")
    public List<SeeTeaStuProj> getteastuproj(@RequestParam("cour_id") String cour_id) {
        return projDao.getTeaStuProj(cour_id);
    }

    @RequestMapping("/addproj")
    public String addproj(@RequestBody SeeProj seeProj){
        projDao.addProj(seeProj.getProj_name(), seeProj.getProj_intro(),
                seeProj.getProj_uptime(), seeProj.getProj_ddl(), seeProj.getCour_id());
        return "ok";
    }

    @PostMapping("/uploadproj")
    public void add(@RequestParam MultipartFile file){
//        //获取文件名
        String fileName = file.getOriginalFilename();
//        System.out.println(fileName);
//        //获取文件后缀
//        String suffixName=fileName.substring(fileName.lastIndexOf("."));
//        //重新生成文件名
//        fileName = UUID.randomUUID()+suffixName;
        //指定本地存入路径
        String filePath="F:\\JAVA\\2022.6_SimpleBS\\temp\\";
        try {
            file.transferTo(new File(filePath+fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/deleteproj")
    public boolean deleteproj(@RequestParam("filename") String filename){
        File fileFolder = new File("F:\\JAVA\\2022.6_SimpleBS\\temp\\");
        File[] files = fileFolder.listFiles();
        boolean flag = false;
        for (File f : files) {
            if (f.isDirectory()) {
                break;
            } else {
                if (f.getName().equals(filename)){
                    flag = f.delete();
                }
            }
        }
        return flag;
    }

    @CrossOrigin
    @RequestMapping("/download")
    public Object download(@RequestParam String fileName,
                           final HttpServletResponse response){
        System.out.println(fileName);
//        response.setHeader("Access-Control-Allow-Origin", "*");
        OutputStream os = null;
        InputStream is = null;
        try{
            // 取得输出流
            os = response.getOutputStream();
            // 清空输出流
            response.reset();
            response.setContentType("application/x-download;charset=GBK");
            response.setHeader("Content-Disposition", "attachment; filename="
                    + new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
            System.out.println("yes");
            //读取流
            String filePath="F:\\JAVA\\2022.6_SimpleBS\\temp\\";
            File f = new File(filePath + fileName);
            is = Files.newInputStream(f.toPath());
            System.out.println("yes2");
            if (is == null) {
                return "下载附件失败，请检查文件“" + fileName + "”是否存在";
            }
            IOUtils.copy(is, response.getOutputStream());
            response.getOutputStream().flush();
            System.out.println("yes3");
        } catch (IOException e) {
            return "下载附件失败，请检查文件“" + fileName + "”是否存在";
        } finally {
            try{
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if(os != null){
                    os.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "no";
    }

}
