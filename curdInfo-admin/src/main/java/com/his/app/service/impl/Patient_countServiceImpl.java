package com.his.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.his.app.mapper.PatientMapper;
import com.his.app.mapper.Patient_countMapper;
import com.his.app.pojo.Patient;
import com.his.app.service.PatientService;
import com.his.app.service.Patient_countService;
import com.his.app.vo.Patient_count;
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
public class Patient_countServiceImpl extends ServiceImpl<Patient_countMapper, Patient_count> implements Patient_countService {

}
