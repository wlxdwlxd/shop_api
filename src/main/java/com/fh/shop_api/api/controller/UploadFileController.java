package com.fh.shop_api.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @create 2020-11-03 19:33
 */
@RequestMapping("/uploadFile")
@Controller
@CrossOrigin
public class UploadFileController {
    @RequestMapping("photo")
    @ResponseBody
    public Map<String,Object> photo(@RequestParam("file") MultipartFile photo, HttpServletRequest request){
        //System.out.println(photo.getOriginalFilename());i
        //先给图片重命名
        Long timeMills=System.currentTimeMillis();//获取当前时间的时间戳
        String oldFileName=photo.getOriginalFilename();//获取图片原名称
        String newFileName=timeMills+oldFileName.substring(oldFileName.lastIndexOf("."));
        //获取上传的绝对路径
        String realPath=request.getSession().getServletContext().getRealPath("/");
        String uploadPath=realPath+"/commons/photo/";
        File file=new File(uploadPath);
        if(!file.exists()){
            file.mkdirs();
        }
        //拼接后缀名
        String photoUrl=uploadPath+"/"+newFileName;
        //上传
        try {
            photo.transferTo(new File(photoUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("code",0);
        resultMap.put("url","http://192.168.1.35:8080/commons/photo/"+newFileName);
        return resultMap;
    }
}
