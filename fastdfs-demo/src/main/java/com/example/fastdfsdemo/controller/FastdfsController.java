package com.example.fastdfsdemo.controller;

import com.zhousy.spring.fastdfs.FastDFSClientUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Controller
@RequestMapping("fastdfs")
public class FastdfsController {

    @Resource
    private FastDFSClientUtil fastDFSClientUtil;

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {

        String fileId;
        try {
            String originalFilename = file.getOriginalFilename();
            fileId = fastDFSClientUtil.uploadFile(file.getBytes(), originalFilename.substring(originalFilename.lastIndexOf(".")));
            return fastDFSClientUtil.getSourceUrl(fileId);
        } catch (Exception e) {
            e.printStackTrace();
            return "文件上传图片服务器失败";
        }
    }


    @DeleteMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam String fileid) {
        try {
            fastDFSClientUtil.delete(fileid);
        } catch (Exception e) {
            e.printStackTrace();
            return "文件删除失败";
        }
       return  "success";
    }


}