package com.his.app.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.his.app.mapper.DrugPopMapper;
import com.his.app.mapper.DrugTrashMapper;
import com.his.app.service.DrugTrashService;
import com.his.app.service.impl.DrugTrashServiceImpl;
import com.his.app.service.impl.Drug_wServiceImpl;
import com.his.app.vo.DrugTrash;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cgl
 * @version 1.0
 * @date 2020/9/1 16:46
 */
@RestController
@RequestMapping("/drugtrash")
@Api("浪费药物控制器")
public class DrugTrashController {

    @Autowired
    DrugTrashMapper drugTrashMapper;

    @ApiOperation("返回所有浪费的药物")
    @GetMapping("/list")
    public List<DrugTrash> list(){
        return drugTrashMapper.selectList(null);
    }

    @Autowired
    DrugTrashServiceImpl drugTrashService;

    @ApiOperation("添加一个浪费药物信息")
    @PostMapping("/add")
    public String save(@RequestBody DrugTrash drugTrash){
        boolean save = drugTrashService.save(drugTrash);
        return save?"添加成功":"添加失败";

    }

    @ApiOperation("更新浪费药物数据")
    @PostMapping("/edit")
    public String edit(@RequestBody DrugTrash drugTrash){
        UpdateWrapper<DrugTrash> wrapper=new UpdateWrapper<>();
        wrapper.eq("id",drugTrash.getId());
        boolean update = drugTrashService.update(drugTrash, wrapper);
        return update?"更新成功":"更新失败";
    }
}
