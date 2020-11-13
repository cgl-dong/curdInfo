package com.his.app.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
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
@ApiModel(value="Drug_c对象", description="中药")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drug_c implements Serializable {

    private static final long serialVersionUID = 1L;


    private String type;

    private String drugname;

    @TableField("OTC")
    private String OTC;

    private String specification;

    private String form;

    private String expiryDate;

    private String vender;

    private String quantity;

    private String price;

    private String productname;

    private String useQuantity;

    private String brand;

    private String plantype;

    private String expiry;

    private String genericname;

    private String certificate;

    private String useEat;




}
