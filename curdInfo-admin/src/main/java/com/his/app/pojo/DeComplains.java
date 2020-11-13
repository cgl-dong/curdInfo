package com.his.app.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2020-08-29
 */
@ApiModel(value="De_complains对象", description="科室、医生投诉信息")
public class DeComplains implements Serializable {

    private static final long serialVersionUID = 1L;

    private String date;

    private String phone;

    private String name;

    private String content;

    private String department;

    private String way;

    private String Processing;

    private String results;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getProcessing() {
        return Processing;
    }

    public void setProcessing(String Processing) {
        this.Processing = Processing;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "DeComplains{" +
        "date=" + date +
        ", phone=" + phone +
        ", name=" + name +
        ", content=" + content +
        ", department=" + department +
        ", way=" + way +
        ", Processing=" + Processing +
        ", results=" + results +
        "}";
    }
}
