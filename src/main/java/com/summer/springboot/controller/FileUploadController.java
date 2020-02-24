package com.summer.springboot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author:chiyou Project Name: springboot
 * File Name: FileUploadController
 * Package Name: com.summer.springboot.controller
 * Date: 2020/2/9 20:58
 * sprinboot 文件上传和多文件上传
 */
@RestController
public class FileUploadController {

    SimpleDateFormat sdf =new SimpleDateFormat("/yyyy/mm/dd");

    /**
     * 单文件上传
     * @param file
     * @param reg
     * @return
     */
    @PostMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest reg) {

        //创建保存文件的文件夹地址
        String format = sdf.format((new Date()));
        //“/img”相当于webapp下的img “/” 相当于在默认访问的静态资源路径
        String realPath = reg.getServletContext().getRealPath("/img")+format;
        //创建文件夹
        File folder = new File(realPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        System.out.println(" real Path: "+realPath);
        //防止文件名字重复，使用uuid创建新的文件名
        String oldName=file.getOriginalFilename();
        //从旧文件名的点之前开始截取加上uuid
        String newName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."));

        try {
            //保存文件
            file.transferTo(new File(folder,newName));
            //保存成功返回保存的路径
            String url =reg.getScheme()+"://"+reg.getServerName()+":"
                    +reg.getServerPort()+"/img"+format+newName;
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 多文件上传
     * @param files
     * @param reg
     * @return
     */
    @PostMapping("/uploads")
    public String uploads(MultipartFile[] files, HttpServletRequest reg) {

        //创建保存文件的文件夹地址
        String format = sdf.format((new Date()));
        //“/img”相当于webapp下的img “/” 相当于在默认访问的静态资源路径
        String realPath = reg.getServletContext().getRealPath("/img")+format;
        //创建文件夹
        File folder = new File(realPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        //System.out.println(" real Path: "+realPath);
        for (MultipartFile file : files) {
            //防止文件名字重复，使用uuid创建新的文件名
            String oldName=file.getOriginalFilename();
            //从旧文件名的点之前开始截取加上uuid
            String newName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."));

            try {
                //保存文件
                file.transferTo(new File(folder,newName));
                //保存成功返回保存的路径
                String url =reg.getScheme()+"://"+reg.getServerName()+":"
                        +reg.getServerPort()+"/img"+format+newName;
                System.out.println(url);;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return "success";
    }

}
