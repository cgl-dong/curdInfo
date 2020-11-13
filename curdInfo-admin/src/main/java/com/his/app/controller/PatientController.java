package com.his.app.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.his.app.mapper.PatientMapper;
import com.his.app.mapper.Patient_countMapper;
import com.his.app.mapper.Patient_listMapper;
import com.his.app.pojo.Patient;
import com.his.app.service.impl.Patient_listServiceImpl;
import com.his.app.vo.Patient_count;
import com.his.app.vo.Patient_list;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Api("病人控制器")
@Slf4j
@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    Patient_countMapper patient_countMapper;

    @ApiOperation("返回上周病人统计信息")
    @GetMapping("/count")
    public List<Patient_count> count(){
        return  patient_countMapper.selectList(null);
    }



    @Autowired
    Patient_listMapper patient_listMapper;

    @ApiOperation("返回病人列表具体信息")
    @GetMapping("/list")
    public List<Patient_list>  list(){
        return patient_listMapper.selectList(null);
    }


    @ApiOperation("修改病人数据，通过挂号序号")
    @PostMapping("/edit")
    public String edit(@RequestBody Patient_list patient_list){
        UpdateWrapper<Patient_list> patient=new UpdateWrapper<>();
        patient.eq("number",patient_list.getNumber());
        int update = patient_listMapper.update(patient_list, patient);
        String msg="修改失败";
        if(update==1){
            msg="修改成功";
        }
        return msg;
    }

    @ApiOperation("查询病人，根据条件：名字、日期、主治医生、身份证号")
    @PostMapping("/query/{msg}")
    public List<Patient_list> query(@PathVariable("msg") String msg,@RequestParam String value){
        log.error(msg);
        log.info(value);
        QueryWrapper<Patient_list> wrapper=new QueryWrapper<>();
        wrapper.eq(msg,value);
        return patient_listMapper.selectList(wrapper);
    }

    @Autowired
    Patient_listServiceImpl patient_listService;

    @ApiOperation("增加病人信息")
    @PostMapping("/add")
    public String save(@RequestBody Patient_list patient_list){
        boolean save = patient_listService.save(patient_list);
        return save?"增加成功":"增加失败";
    }

}

