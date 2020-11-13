package com.his.app.config;

import com.his.app.component.MyException;
import lombok.Data;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cgl
 * @version 1.0
 * @date 2020/8/31 9:37
 */
//全局异常处理器
@RestControllerAdvice
public class ExceptionConfig {

    //系统异常处理器
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        Map map = new HashMap();
        map.put("msg", ex.getMessage());
        return map;
    }

    //自定义异常处理器
    @ExceptionHandler(value = MyException.class)
    public Map exHandler(MyException ex) {
        Map map = new HashMap();
        map.put("code",ex.getCode());
        map.put("msg", ex.getMessage());
        return map;
    }


}
