package com.his.app.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URLEncoder;

/**
 * @author cgl
 * @version 1.0
 * @desc 处理文件上传下载
 * @date 2020/10/20 15:35
 */

@Slf4j
public class FileLoadUtil {


    /**
     * 返回 图片的全路径
     *
     * @param file 页面的文件对象
     * @return
     */
    public static String upload(MultipartFile file) throws IOException, URISyntaxException, InterruptedException {

        String imageData = new String(file.getBytes());

        FileOutputStream outputStream = new FileOutputStream(new File("H://a.jpg"));
        outputStream.write(file.getBytes());
        outputStream.close();
        return "uploading success";

    }


    public static String downLoad(HttpServletResponse response) throws IOException {

        String filename="dd.img";
        String filePath = "H:/file" ;
        File file = new File(filePath + "/" + filename);


        if(!file.exists()){

        }
        //下载
        response.setContentType("application/octet-stream");
        response.setHeader("content-type", "application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(filename,"utf8"));
        byte[] buffer = new byte[1024];
        //输出流
        OutputStream os = null;
        try(FileInputStream fis= new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);) {
            os = response.getOutputStream();
            int i = bis.read(buffer);
            while(i != -1){
                os.write(buffer);
                i = bis.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "download ok";
    }
}
