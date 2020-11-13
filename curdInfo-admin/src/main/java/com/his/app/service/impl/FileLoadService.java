//package com.his.app.service.impl;
//
//import com.his.app.component.MyException;
//import com.his.app.dao.ImageDao;
//import com.his.app.entity.Image;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
///**
// * @author cgl
// * @version 1.0
// * @desc 处理文件上传下载
// * @date 2020/10/21 10:45
// */
//@Service
//public class FileLoadService {
//
//    @Autowired
//    ImageDao imageDao;
//
//    public String upload(MultipartFile file, String userName) throws IOException {
//        String s = new String(file.getBytes());
//        Image head = new Image(null, "head", userName, s);
//
//        imageDao.insert(head);
//
//        Image image = imageDao.queryByUser(userName);
//        System.out.println(image);
//
//        return  "ok";
//    }
//
//    public String downLoad(){
//        return "ok";
//
//    }
//
//}
