package com.his.app.service.impl;

import com.his.app.pojo.Patient;
import com.his.app.mapper.PatientMapper;
import com.his.app.service.PatientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2020-08-29
 */
@Service
public class Patient_ServiceImpl extends ServiceImpl<PatientMapper, Patient> implements PatientService {

}
