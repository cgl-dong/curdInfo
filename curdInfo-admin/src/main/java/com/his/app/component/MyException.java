package com.his.app.component;

import lombok.Data;

/**
 * @author cgl
 * @version 1.0
 * @date 2020/9/23 15:24
 */
@Data
public class MyException extends RuntimeException{
    public MyException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;
}
