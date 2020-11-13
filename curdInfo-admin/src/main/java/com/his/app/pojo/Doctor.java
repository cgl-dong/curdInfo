package com.his.app.pojo;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2020-08-29
 */
@ApiModel(value="Doctor对象", description="数据库中存储的医生")
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "id号不能为空")
    @Pattern(regexp = "[0-9]{8}$", message = "id格式有误")
    @Size(min = 6, max = 11)
    private String id;

    private String name;

    private String sex;

    private String date;

    private String degree;

    private String major;

    private String profession;

    private String office;

    private String officeid;

    private String isexpert;


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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getOfficeid() {
        return officeid;
    }

    public void setOfficeid(String officeid) {
        this.officeid = officeid;
    }

    public String getIsexpert() {
        return isexpert;
    }

    public void setIsexpert(String isexpert) {
        this.isexpert = isexpert;
    }

    @Override
    public String toString() {
        return "Doctor{" +
        "id=" + id +
        ", name=" + name +
        ", sex=" + sex +
        ", date=" + date +
        ", degree=" + degree +
        ", major=" + major +
        ", profession=" + profession +
        ", office=" + office +
        ", officeid=" + officeid +
        ", isexpert=" + isexpert +
        "}";
    }
}
