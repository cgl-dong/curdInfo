package com.his.app.pojo;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * @author cgl
 * @version 1.0
 * @date 2020/9/1 16:28
 */
@ApiModel(value = "register对象：挂号",description = "挂号")
public class Register implements Serializable {
    private static final long serialVersionUID = 104050168213912901L;

    private String no;

    private String number;

    private String patientName;

    private String certificateValue;

    private String cardNumber;

    private String departmentValue;

    private String doctorName;

    private String visitDate;

    private String expense;


    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getCertificateValue() {
        return certificateValue;
    }

    public void setCertificateValue(String certificateValue) {
        this.certificateValue = certificateValue;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getDepartmentValue() {
        return departmentValue;
    }

    public void setDepartmentValue(String departmentValue) {
        this.departmentValue = departmentValue;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

}