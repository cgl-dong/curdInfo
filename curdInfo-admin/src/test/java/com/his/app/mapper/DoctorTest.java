package com.his.app.mapper;

import com.his.app.pojo.Doctor;
import com.his.app.service.DoctorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.smartcardio.ATR;
import java.util.List;

/**
 * @author cgl
 * @version 1.0
 * @date 2020/8/27 23:27
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class DoctorTest {

    @Autowired
    DoctorMapper doctorMapper;

    @Test
    public void test(){
        List<Doctor> doctors = doctorMapper.selectList(null);
        doctors.forEach(System.out::println);
    }

    @Autowired
    DoctorService doctorService;

    @Test
    public void test2(){
        List<Doctor> list = doctorService.list(null);
        list.forEach(System.out::println);
    }
}
