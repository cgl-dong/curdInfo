package com.his.app.controller;

import com.alibaba.fastjson.JSON;
import com.his.app.dao.DoctorDao;
import com.his.app.util.EchartsUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author cgl
 * @version 1.0
 * @desc
 * @date 2020/10/11 0:51
 */
@RestController
@Api(value = "图表展示",tags = "echart图表展示")
@RequestMapping("/echarts")
public class EchartConteoller {
    @Autowired
    EchartsUtil echartsUtil;

    @Autowired
    DoctorDao doctorDao;

    @ApiOperation("返回doctor制作echart饼图表的json数据")
    @GetMapping("/doctor")
    public String doctor(){
        String echart = echartsUtil.echart();
        return echart;
    }

    @ApiOperation("返回doctor制作echart柱形图表的json数据")
    @GetMapping("/doctor2")
    public String doctorEchart(){
        List list=new ArrayList();
        list.add(doctorDao.getOffice());
        list.add(doctorDao.getOfficeCount());
        return JSON.toJSONString(list);
    }

    @ApiOperation("返回制作echart图表的json数据，医生和护士的人数")
    @GetMapping("/count")
    public List<Map> doctorCount(){
        List<Map> count = doctorDao.count();
        System.out.println(count);
        return count;
    }


}
