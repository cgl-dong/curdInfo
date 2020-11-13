package com.his.app.dao;

import com.his.app.entity.Image;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Image)表数据库访问层
 *
 * @author cgl
 * @since 2020-10-20 16:29:38
 */
public interface ImageDao {

    /**
     * 通过ID查询单条数据
     *
     *
     * @return 实例对象
     */
    @Select(" select\n" +
            "          id, type, user, data\n" +
            "        from his.image\n" +
            "        where user=#{userName}")
    Image queryByUser(String userName);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Image> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param image 实例对象
     * @return 对象列表
     */
    List<Image> queryAll(Image image);

    /**
     * 新增数据
     *
     * @param image 实例对象
     * @return 影响行数
     */
    @Insert(" insert into his.image(type, user, data)\n" +
            "        values (#{type}, #{user}, #{data})")
    void insert(Image image);

    /**
     * 修改数据
     *
     * @param image 实例对象
     * @return 影响行数
     */
    int update(Image image);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}