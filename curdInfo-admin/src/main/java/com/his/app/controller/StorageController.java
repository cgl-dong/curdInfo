package com.his.app.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.his.app.mapper.StorageMapper;
import com.his.app.pojo.Storage;
import com.his.app.service.impl.StorageServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-08-29
 */
@Api("药库控制器")
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    StorageMapper storageMapper;

    @ApiOperation("获取药库药品信息")
    @GetMapping("/list")
    public List<Storage> list(){
        return storageMapper.selectList(null);
    }

    @Autowired
    StorageServiceImpl storageService;

    @ApiOperation("药物入库")
    @PostMapping("/add")
    public String save(@RequestBody Storage storage){
        boolean save = storageService.save(storage);
        return save?"入库成功":"入库失败";
    }


    @ApiResponse(code = 300,message = "ok")
    @ApiOperation("通过药品名查询药库信息")
    @GetMapping("/search")
    public List<Storage> search(String name){
        QueryWrapper<Storage> wrapper=new QueryWrapper<>();
        wrapper.like("name",name);
        List<Storage> list = storageMapper.selectList(wrapper);
        return list;
    }


}

