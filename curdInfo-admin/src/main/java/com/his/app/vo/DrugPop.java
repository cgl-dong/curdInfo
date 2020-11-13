package com.his.app.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * (DrugPop)实体类
 *
 * @author makejava
 * @since 2020-09-01 16:27:23
 */
@ApiModel(value = "视图对象：DrugPop",description = "出药")
public class DrugPop implements Serializable {
    private static final long serialVersionUID = 747141239807627247L;
    
    private String id;
    
    private String name;
    
    private String manufacturers;
    
    private String amount;
    
    private String handlers;

    @TableField("timeApplication")
    private String timeApplication;

    @TableField("outOfTime")
    private String outOfTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(String manufacturers) {
        this.manufacturers = manufacturers;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getHandlers() {
        return handlers;
    }

    public void setHandlers(String handlers) {
        this.handlers = handlers;
    }

    public String getTimeApplication() {
        return timeApplication;
    }

    public void setTimeApplication(String timeApplication) {
        this.timeApplication = timeApplication;
    }

    public String getOutOfTime() {
        return outOfTime;
    }

    public void setOutOfTime(String outOfTime) {
        this.outOfTime = outOfTime;
    }

}