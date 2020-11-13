package com.his.app.pojo;

/**
 * @author cgl
 * @version 1.0
 * @desc
 * @date 2020/10/10 14:12
 */

import lombok.Data;

@Data
public class EchartsEntity {

    public String name;
    public String type;
    public EchartsEntity() {

    }

    public EchartsEntity(String name, String type) {
        super();
        this.name = name;
        this.type = type;

    }



}