package com.his.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.his.app.mapper.RegisterMapper;
import com.his.app.pojo.Register;
import com.his.app.service.RegisterService;
import org.springframework.stereotype.Service;

/**
 * @author cgl
 * @version 1.0
 * @date 2020/9/3 9:11
 */
@Service
public class RegisterServiceImpl extends ServiceImpl<RegisterMapper, Register> implements RegisterService  {
}
