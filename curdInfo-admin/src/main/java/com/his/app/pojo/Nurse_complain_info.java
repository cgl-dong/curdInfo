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
@ApiModel(value="Nurse_complain_info对象", description="护士投诉信息")
public class Nurse_complain_info implements Serializable {

    private static final long serialVersionUID = 1L;

    private String complainant;

    private String type;

    private String date;

    private String content;

    private String phone;


    public String getComplainant() {
        return complainant;
    }

    public void setComplainant(String complainant) {
        this.complainant = complainant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Nurse_complain_info{" +
        "complainant=" + complainant +
        ", type=" + type +
        ", date=" + date +
        ", content=" + content +
        ", phone=" + phone +
        "}";
    }
}
