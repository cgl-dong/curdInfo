package com.his.app.vo;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * (DrugTrash)实体类
 *
 * @author makejava
 * @since 2020-09-01 16:27:37
 */
@ApiModel(value = "视图对象:DrugTrash",description = "浪费的药物")
public class DrugTrash implements Serializable {
    private static final long serialVersionUID = 669240959532368086L;
    
    private String id;
    
    private String name;
    
    private String manufacturers;
    
    private String amount;
    
    private String handlers;
    
    private String trashy;


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

    public String getTrashy() {
        return trashy;
    }

    public void setTrashy(String trashy) {
        this.trashy = trashy;
    }

}