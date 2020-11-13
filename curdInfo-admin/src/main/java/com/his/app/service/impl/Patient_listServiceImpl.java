package com.his.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.his.app.mapper.Patient_listMapper;
import com.his.app.service.Patient_listService;
import com.his.app.vo.Patient_list;
import org.springframework.stereotype.Service;

/**
 * @author cgl
 * @version 1.0
 * @date 2020/9/1 15:53
 */
@Service
public class Patient_listServiceImpl extends ServiceImpl<Patient_listMapper, Patient_list> implements Patient_listService {
}
