package com.his.app.controller;

import com.his.app.mapper.DrugPopMapper;
import com.his.app.vo.DrugPop;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cgl
 * @version 1.0
 * @date 2020/9/1 16:44
 */
@Api("出药控制器")
@RestController
@RequestMapping("/drugpop")
public class DrugPopController {

    @Autowired
    DrugPopMapper drugPopMapper;

    @ApiOperation("返回出药列表")
    @GetMapping("/list")
    public List<DrugPop> list(){
        return drugPopMapper.selectList(null);
    }

}
