package com.his.app.controller;

import com.his.app.mapper.Nurse_turn_overMapper;
import com.his.app.pojo.Nurse_turn_over;
import com.his.app.service.impl.Nurse_shift_tableServiceImpl;
import com.his.app.service.impl.Nurse_turn_overServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cgl
 * @version 1.0
 * @date 2020/9/1 14:26
 */
@RestController
@Api("离职控制器")
@RequestMapping("/turnover")
public class TurnOverController {

    @Autowired
    Nurse_turn_overServiceImpl nurse_turn_overService;
    @ApiOperation("添加护士离职信息")
    @PostMapping("/nurse")
    public String addNurseOver(@RequestBody Nurse_turn_over nurse_turn_over){
        boolean save = nurse_turn_overService.save(nurse_turn_over);

        String msg="增加失败";
        if(save){
            msg="增加成功";
        }
        return msg;
    }


    @Autowired
    Nurse_turn_overMapper nurse_turn_overMapper;

    @ApiOperation("离职护士信息")
    @GetMapping("/list")
    public List<Nurse_turn_over> overNurse(){
        return nurse_turn_overMapper.selectList(null);
    }
}
