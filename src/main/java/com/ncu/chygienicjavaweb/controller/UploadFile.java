package com.ncu.chygienicjavaweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.ncu.chygienicjavaweb.entity.FileName;
import com.ncu.chygienicjavaweb.entity.submitproject.UserJson;
import com.ncu.chygienicjavaweb.mapper.UploadFileMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;

@RestController
public class UploadFile {
    @Resource
    UploadFileMapper uploadFileMapper;

    @RequestMapping("/upload")
    @ResponseBody
    public String create(@RequestParam("projId") Integer projId, @RequestPart MultipartFile file) throws IOException {
//        String path = "/home/ubuntu/server/upload/";
        String path = "C:\\Users\\姚望辰\\Desktop\\";
        String fileName = file.getOriginalFilename();
        String filePath = path + fileName;

        File dest = new File(filePath);
        Files.copy(file.getInputStream(), dest.toPath());

        uploadFileMapper.insertFile(projId,dest.getAbsolutePath());

        return "Upload file success : " + dest.getAbsolutePath() + projId;
    }


    @RequestMapping("/getPath")
    @ResponseBody
    public JSONObject getFilePath(@RequestParam("project_id")int project_id)throws IOException{
        FileName fileName = new FileName();
        fileName = uploadFileMapper.selectFile(project_id);
        String path = fileName.getAppendix_content();
        String[] names=path.split("\\/");
        int len = names.length;
        String name = names[len-1];
        JSONObject jsonTotal =new JSONObject();
        if(fileName == null){
            jsonTotal.put("status",0);
            jsonTotal.put("message","不存在相应文件");
        }
        else {
            jsonTotal.put("status",1);
            jsonTotal.put("message",name);
        }
        return jsonTotal;
    }

    @RequestMapping("/download")
    public String fileDownLoad(HttpServletResponse response, @RequestParam("fileName") String fileName){
        File file = new File("/home/nogra/Public/" +'/'+ fileName);
        if(!file.exists()){
            return "下载文件不存在";
        }
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName );

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));) {
            byte[] buff = new byte[1024];
            OutputStream os  = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            return "下载失败";
        }
        return "下载成功";
    }
}
