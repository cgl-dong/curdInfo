package com.his.app.entity;

import lombok.AllArgsConstructor;

import java.io.Serializable;

/**
 * (Image)实体类
 *
 * @author cgl
 * @since 2020-10-20 16:29:36
 */

@AllArgsConstructor
public class Image implements Serializable {
    private static final long serialVersionUID = 157134371877811625L;
    
    private Integer id;
    /**
    * 分类
    */
    private String type;
    /**
    * 拥有者
    */
    private String user;
    /**
    * 二进制数据,使用base64加密，整条记录加盐
    */
    private String data;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Object getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", user='" + user + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}