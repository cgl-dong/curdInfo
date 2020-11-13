package com.his.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cgl
 * @version 1.0
 * @date 2020/9/16 9:04
 */
@RestController
@RequestMapping("/ex")
@Slf4j
public class ExceptionController {

    @RequestMapping(value = "/ok",method = RequestMethod.GET)
    public String ok() throws Exception {
        log.info("测试===");
        try {
            int i=10/0;
        }catch (Exception e){
            throw new Exception("no..");
        }
        return "ok";
    }
}
