package com.his.app.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * (PatientList)实体类
 *
 * @author makejava
 * @since 2020-09-01 15:44:21
 */
@ApiModel(value="Patient_list对象", description="病人列表")
@Data
public class Patient_list implements Serializable {
    private static final long serialVersionUID = -75703461329110994L;

    private String date;

    private String number;

    private String name;

    private String sex;

    private String region;

    private String phone;

    private String relation;

    @TableField("illHistory")
    private String illhistory;

    @TableField("idCard")
    private String idcard;

    private String reName;

    private String age;

    private String symptoms;

    private String disease;

    private String position;

    private String address;

    private String doctor;

    private String pharmacist;


}