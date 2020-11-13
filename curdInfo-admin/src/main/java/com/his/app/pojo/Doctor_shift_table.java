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
@ApiModel(value="Doctor_shift_table对象", description="医生值班信息")
public class Doctor_shift_table implements Serializable {

    private static final long serialVersionUID = 1L;

    private String date;

    private String dates;

    private String name;

    private String sex;

    private String office;

    private String number;

    private String attendance;

    private String signatory;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
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

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getSignatory() {
        return signatory;
    }

    public void setSignatory(String signatory) {
        this.signatory = signatory;
    }

    @Override
    public String toString() {
        return "Doctor_shift_table{" +
        "date=" + date +
        ", dates=" + dates +
        ", name=" + name +
        ", sex=" + sex +
        ", office=" + office +
        ", number=" + number +
        ", attendance=" + attendance +
        ", signatory=" + signatory +
        "}";
    }
}
