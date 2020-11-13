package com.his.app.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.his.app.mapper.Nurse_complain_infoMapper;
import com.his.app.mapper.Nurse_existMapper;
import com.his.app.mapper.Nurse_shift_tableMapper;
import com.his.app.pojo.*;
import com.his.app.service.impl.Nurse_existServiceImpl;
import com.his.app.service.impl.Nurse_shift_tableServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/nurse")
@Api("护士控制器")
@Slf4j
@CacheConfig(cacheNames = "nurse")
public class NurseController {

    @Autowired
    Nurse_existMapper nurse_existMapper;

    @ApiOperation("医院中的所有在职护士信息")
    @GetMapping("/hasNurse")
    public List<Nurse_exist> hasNurse(){
        log.info("医院中的所有在职护士信息");
        return nurse_existMapper.selectList(null);
    }

    @ApiOperation("分页展示在职护士信息")
    @GetMapping("/hasNurse/page")
    @Cacheable
    public IPage<Nurse_exist> hasNursePage(int offset, int limit){
        log.info("nurse分页： offset: "+offset +" limit: "+limit);
        IPage<Nurse_exist> page = new Page<>(offset,limit);
        IPage<Nurse_exist> existIPage = nurse_existMapper.selectPage(page, null);
        return existIPage;
    }




    @Autowired
    Nurse_shift_tableMapper nurse_shift_tableMapper;

    @ApiOperation("护士值班表")
    @GetMapping("/table")
    public List<Nurse_shift_table> table(){
        return nurse_shift_tableMapper.selectList(null);
    }

    @ApiOperation("更新护士值班信息")
    @PostMapping("/table/edit")
    public String shiftEdit(@RequestBody Nurse_shift_table nurse_shift_table){
        QueryWrapper queryWrapper=new QueryWrapper<Nurse_shift_table>();
        queryWrapper.eq("name",nurse_shift_table.getName());
        int update = nurse_shift_tableMapper.update(nurse_shift_table, queryWrapper);
        String msg="修改失败";
        if(update==1){
            msg="修改成功";
        }
        return msg;
    }

    @Autowired
    Nurse_shift_tableServiceImpl nurseShiftTableService;

    @ApiOperation("添加护士值班信息")
    @PostMapping("/table/shift")
    public String tableAdd(@RequestBody Nurse_shift_table shift_table){
        boolean save = nurseShiftTableService.save(shift_table);
        String msg="添加失败";
        if(save){
            msg="添加成功";
        }

        return msg;
    }

    @Autowired
    Nurse_complain_infoMapper nurse_complain_infoMapper;

    @ApiOperation("返回对护士的投诉")
    @GetMapping("/complain")
    public List<Nurse_complain_info> info(){
        return nurse_complain_infoMapper.selectList(null);
    }

    @Autowired
    Nurse_existServiceImpl existService;

    @ApiOperation("保存一个护士信息")
    @PostMapping("/save")
    public String save(@RequestBody Nurse_exist nurse){
        boolean save = existService.save(nurse);
        return save?"保存成功":"保存异常";
    }


    @ApiOperation("查询匹配的Nurse,通过名字或者科室")
    @GetMapping("/search/name")
    public List<Nurse_exist> searchByName(@RequestParam("name") String name) {
        QueryWrapper<Nurse_exist> wrapper = new QueryWrapper();
        wrapper.like("name",name);
        return nurse_existMapper.selectList(wrapper);
    }

    @ApiOperation("查询匹配的Nurse,通过名字或者科室")
    @GetMapping("/search/department")
    public List<Nurse_exist> searchByDepartment(@RequestParam("department") String department) {

        return nurse_existMapper.searchByDepartment(department);
    }

    @ApiOperation("查询匹配的Nurse,通过名字或者科室")
    @GetMapping("/search")
    public List<Nurse_exist> search( @RequestParam("name") String name, @RequestParam("department") String department) {

        return nurse_existMapper.searchByNameAndDepartment(name,department);
    }


    @ApiOperation("更新护士信息")
    @PostMapping("/edit")
    public String edit(@RequestBody Nurse_exist nurse_exist){
        QueryWrapper<Nurse_exist> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("name",nurse_exist.getName());
        int update = nurse_existMapper.update(nurse_exist, queryWrapper);
        String msg="修改失败";
        if(update==1){
            msg="修改成功";
        }
        return msg;
    }

}

