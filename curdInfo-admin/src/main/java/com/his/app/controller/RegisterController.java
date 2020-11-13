package com.his.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.his.app.mapper.DoctorMapper;
import com.his.app.mapper.DrugPopMapper;
import com.his.app.mapper.RegisterMapper;
import com.his.app.pojo.Doctor;
import com.his.app.pojo.Patient;
import com.his.app.pojo.Register;
import com.his.app.service.impl.RegisterServiceImpl;
import com.his.app.vo.DrugPop;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cgl
 * @version 1.0
 * @date 2020/8/31 10:39
 */
@RestController
@RequestMapping("/register")
@Api("挂号控制器")
public class RegisterController {
    @Autowired
    RegisterMapper registerMapper;

    @ApiOperation("返回挂号信息列表")
    @GetMapping("/list")
    public List<Register> list(){
        return registerMapper.selectList(null);
    }

    @Autowired
    RegisterServiceImpl registerService;

    @ApiOperation("增加挂号信息")
    @PostMapping("/add")
    public String save(@RequestBody Register register){
        boolean save = registerService.save(register);
        return save?"添加成功":"添加失败";
    }

    @Autowired
    DoctorMapper doctorMapper;

    @ApiOperation("注册时，根据科室查询医生")
    @PostMapping("/search")
    public List<Doctor> search(String office){
        QueryWrapper<Doctor> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("office",office);
        List<Doctor> list = doctorMapper.selectList(queryWrapper);
        return list;
    }

    @ApiOperation("根据挂号序号查询挂号信息")
    @PostMapping("/query/number")
    public List<Register> queryNumber(String number){
        QueryWrapper<Register> wrapper=new QueryWrapper<>();
        wrapper.eq("number",number);
        List<Register> registers = registerMapper.selectList(wrapper);
        return registers;
    }


    @ApiOperation("根据挂号患者名查询挂号信息")
    @PostMapping("/query/name")
    public List<Register> queryName(String name){
        QueryWrapper<Register> wrapper=new QueryWrapper<>();
        wrapper.eq("patient_name",name);
        List<Register> registers = registerMapper.selectList(wrapper);
        return registers;
    }


    @ApiOperation("根据挂号序号、姓名查询挂号信息")
    @PostMapping("/query")
    public List<Register> query(String name,String number){
        QueryWrapper<Register> wrapper=new QueryWrapper<>();
        wrapper.eq("number",number);
        wrapper.eq("patient_name",name);
        List<Register> registers = registerMapper.selectList(wrapper);
        return registers;
    }

}
