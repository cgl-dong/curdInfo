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
@ApiModel(value="Nurse_turn_over对象", description="离职护士信息")
public class Nurse_turn_over implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String number;

    private String age;

    private String sex;

    private String department;

    private String position;

    private String processor;

    private String address;

    private String hiredate;

    private String resignation_time;

    private String resignation_reason;

    private String seniority;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getResignation_time() {
        return resignation_time;
    }

    public void setResignation_time(String resignation_time) {
        this.resignation_time = resignation_time;
    }

    public String getResignation_reason() {
        return resignation_reason;
    }

    public void setResignation_reason(String resignation_reason) {
        this.resignation_reason = resignation_reason;
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    @Override
    public String toString() {
        return "Nurse_turn_over{" +
        "name=" + name +
        ", number=" + number +
        ", age=" + age +
        ", sex=" + sex +
        ", department=" + department +
        ", position=" + position +
        ", processor=" + processor +
        ", address=" + address +
        ", hiredate=" + hiredate +
        ", resignation_time=" + resignation_time +
        ", resignation_reason=" + resignation_reason +
        ", seniority=" + seniority +
        "}";
    }
}
