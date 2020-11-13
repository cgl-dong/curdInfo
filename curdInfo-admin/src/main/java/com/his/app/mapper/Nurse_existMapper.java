package com.his.app.mapper;

import com.his.app.pojo.Nurse_exist;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2020-08-29
 */
public interface Nurse_existMapper extends BaseMapper<Nurse_exist> {

    @Select("SELECT name,address,sex,age,position,department,education,profession,date FROM nurse_exist\n" +
            "        where name=#{name}")
    public List<Nurse_exist> searchByName(String name);

    @Select("SELECT name,address,sex,age,position,department,education,profession,date FROM nurse_exist\n" +
            "        where department=#{department}")
    public List<Nurse_exist> searchByDepartment(String department);

    @Select(" SELECT name,address,sex,age,position,department,education,profession,date FROM nurse_exist\n" +
            "        where name=#{name} and department=#{department}")
    public List<Nurse_exist> searchByNameAndDepartment(String name,String department);

    public List<Nurse_exist> all();
}
