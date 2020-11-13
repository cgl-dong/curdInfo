package com.his.app.dao;


import com.his.app.pojo.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Doctor)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-10 11:19:42
 */
public interface DoctorDao {


    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Doctor> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param doctor 实例对象
     * @return 对象列表
     */
    List<Doctor> queryAll(Doctor doctor);

    /**
     * 新增数据
     *
     * @param doctor 实例对象
     * @return 影响行数
     */
    int insert(Doctor doctor);

    /**
     * 修改数据
     *
     * @param doctor 实例对象
     * @return 影响行数
     */
    int update(Doctor doctor);

    /*
     * @return 总数
     */

    @Select("select t1.nurseCount,t2.doctorCount from \n" +
            "  (select count(*) nurseCount from nurse_exist) t1,\n" +
            "  (select count(*) doctorCount from doctor) t2")
    List<Map> count();

    /**
     *
     * @param office
     * @return 总数
     */

    List<HashMap<String,Object>> countByOffice();

    @Select("select office from doctor group by office")
    List<String> getOffice();

    @Select("select count(1) from doctor group by office")
    List<Integer> getOfficeCount();

}