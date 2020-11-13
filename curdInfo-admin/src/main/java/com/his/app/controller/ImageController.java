//package com.his.app.controller;
//
//import com.his.app.service.impl.FileLoadService;
//import com.his.app.util.FileLoadUtil;
//import io.swagger.annotations.Api;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.net.URISyntaxException;
//
///**
// * @author cgl
// * @version 1.0
// * @desc
// * @date 2020/10/20 15:33
// */
//@Slf4j
//@RestController
//@Api(tags = "头像上传下载")
//public class ImageController {
//
//    @Autowired
//    FileLoadService fileLoadService;
//
//    @RequestMapping("/test")
//    public void test(MultipartFile file, @RequestParam String userName) throws InterruptedException, IOException, URISyntaxException {
//        String upload = fileLoadService.upload(file, userName);
//        log.info("*******"+userName+"更换头像");
//    }
//}
