package com.his.app.mapper;

import com.his.app.pojo.LoginUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2020-08-29
 */
public interface Login_userMapper extends BaseMapper<LoginUser> {

    @Select("SELECT name,password,type from login_user where name=#{name} and password=#{password}")
    public LoginUser find(LoginUser user);
}
