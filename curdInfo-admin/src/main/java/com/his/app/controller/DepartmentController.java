package com.his.app.controller;


import com.his.app.mapper.De_complainsMapper;
import com.his.app.pojo.DeComplains;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@Api("科室信息控制器")
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    De_complainsMapper de_complainsMapper;

    @ApiOperation("返回对科室的投诉信息")
    @GetMapping("/complain")
    public List<DeComplains> complain(){
        return de_complainsMapper.selectList(null);
    }

}

