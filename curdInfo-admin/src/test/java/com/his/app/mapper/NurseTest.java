package com.his.app.mapper;

import com.his.app.pojo.Nurse_exist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author cgl
 * @version 1.0
 * @date 2020/9/16 11:14
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class NurseTest {
    @Autowired
    Nurse_existMapper mapper;

    @Test
    public void test(){
        List<Nurse_exist> all = mapper.all();
        mapper.all();
        all.forEach(System.out::println);
    }
}
