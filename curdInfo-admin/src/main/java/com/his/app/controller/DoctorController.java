package com.his.app.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.his.app.mapper.DoctorMapper;
import com.his.app.mapper.Doctor_flowMapper;
import com.his.app.mapper.Doctor_shift_tableMapper;
import com.his.app.pojo.Doctor;
import com.his.app.pojo.Doctor_flow;
import com.his.app.pojo.Doctor_shift_table;
import com.his.app.service.impl.DoctorServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-08-29
 */
@RestController
@Api("医生控制器")
@RequestMapping("/doctor")
@Slf4j
@CacheConfig(cacheNames = "doctor")
public class DoctorController {

    @Autowired
    DoctorMapper doctorMapper;

    @ApiOperation("返回所有医生信息")
    @GetMapping("/doctors")
    public List<Doctor> doctors(){
        List<Doctor> doctors = doctorMapper.selectList(null);
        return doctors;
    }

    @Autowired
    Doctor_shift_tableMapper doctor_shift_tableMapper;

    @Cacheable
    @ApiOperation("返回医生值班信息")
    @GetMapping("/table")
    public List<Doctor_shift_table> table(){
        log.info("doctor   table");
        return doctor_shift_tableMapper.selectList(null);
    }


    @Autowired
    Doctor_flowMapper doctor_flowMapper;

    @ApiOperation("返回医生离职信息")
    @GetMapping("/over")
    public List<Doctor_flow> over(){
        return doctor_flowMapper.selectList(null);
    }


    @Autowired
    DoctorServiceImpl doctorService;

    @ApiOperation("保存一个医生信息")
    @PostMapping("/save")
    public String save(@RequestBody @Valid Doctor doctor){
        boolean save = doctorService.save(doctor);
        return save?"保存成功":"保存失败";
    }

    @ApiOperation("编辑医生信息，通过id")
    @PostMapping("/edit")
    public String edit(@RequestBody Doctor doctor){
        UpdateWrapper<Doctor> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",doctor.getId());
        boolean update = doctorService.update(doctor, updateWrapper);
        return update?"修改成功":"修改失败";
    }


    @GetMapping("/search/office")
    public List<Doctor> search(String office){
        QueryWrapper<Doctor> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("office",office);
         return doctorMapper.selectList(queryWrapper);
    }


    @GetMapping("/search")
    public List<Doctor> search(String office,String name){
        QueryWrapper<Doctor> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("office",office);
        queryWrapper.eq("name",name);
        return doctorMapper.selectList(queryWrapper);
    }


    @GetMapping("/search/name")
    public List<Doctor> search(String name,int o){
        QueryWrapper<Doctor> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("name",name);
        return doctorMapper.selectList(queryWrapper);
    }

    @Cacheable
    @ApiOperation("医生数据分页")
    @PostMapping("/page")
    public IPage<Doctor> page(int offset,int limit){
        IPage<Doctor> page = new Page<>(offset,limit);
        log.debug(page.toString());
        log.info("page: "+page);
        IPage<Doctor> doctorIPage = doctorMapper.selectPage(page, null);

        return doctorIPage;
    }



}

