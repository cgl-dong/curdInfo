package com.his.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cgl
 * @version 1.0
 * @date 2020/8/31 10:56
 */
@Api(value = "his控制器",tags = "Es返回his信息")
@RestController
@RequestMapping("/hisInfo")
public class HisInfoController {

    @ApiOperation("返回医院医师护师介绍")
    @GetMapping("/info")
    public String info(){
        return "his info";
    }
}
