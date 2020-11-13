package com.his.app.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.his.app.mapper.Drug_cMapper;
import com.his.app.mapper.Drug_wMapper;
import com.his.app.pojo.Drug_c;
import com.his.app.pojo.Drug_w;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-08-29
 */
@Api("药品控制器")
@RestController
@RequestMapping("/drug")
public class DrugController {

    @Autowired
    Drug_wMapper durgsWMapper;

    @ApiOperation("返回西药信息")
    @GetMapping("/w")
    public List<Drug_w> drugw(){
        return durgsWMapper.selectList(null);
    }

    @Autowired
    Drug_cMapper durgcWMapper;

    @ApiOperation("返回中药信息")
    @GetMapping("/c")
    public List<Drug_c> drugc(){
        return durgcWMapper.selectList(null);
    }


    @ApiOperation("返回查询中药列表，通过药品名")
    @PostMapping("/c/search")
    public List<Drug_c> searchC(String name){
        QueryWrapper<Drug_c> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("drugname",name);
        List<Drug_c> list = durgcWMapper.selectList(queryWrapper);
        return  list;
    }

    @ApiOperation("返回查询西药列表，通过药品名")
    @PostMapping("/w/search")
    public List<Drug_w> searchW(String name){
        QueryWrapper<Drug_w> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("drugname",name);
        List<Drug_w> list = durgsWMapper.selectList(queryWrapper);
        return  list;
    }

}

