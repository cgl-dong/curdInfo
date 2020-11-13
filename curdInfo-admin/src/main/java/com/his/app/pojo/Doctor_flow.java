package com.his.app.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.sql.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2020-08-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="Doctor_flow对象", description="离职医生信息")
public class Doctor_flow implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private Date leaveDate;

    private String reason;

    private String name;

    private String sex;

    private String date;

    private String degree;

    private String major;

    private String profession;

    private String office;


}
