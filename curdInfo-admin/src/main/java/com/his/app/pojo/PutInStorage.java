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
@ApiModel(value="PutInStorage对象", description="")
public class PutInStorage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String manufacturers;

    private String amount;

    private String handlers;

    private String temperature;

    private String qualityOfficer;

    private String warehouseman;

    private String pattern;

    private String species;

    private String productionData;

    private String specification;

    private String dosageForm;

    private String date2;


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

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getQualityOfficer() {
        return qualityOfficer;
    }

    public void setQualityOfficer(String qualityOfficer) {
        this.qualityOfficer = qualityOfficer;
    }

    public String getWarehouseman() {
        return warehouseman;
    }

    public void setWarehouseman(String warehouseman) {
        this.warehouseman = warehouseman;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getProductionData() {
        return productionData;
    }

    public void setProductionData(String productionData) {
        this.productionData = productionData;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    @Override
    public String toString() {
        return "PutInStorage{" +
        "name=" + name +
        ", manufacturers=" + manufacturers +
        ", amount=" + amount +
        ", handlers=" + handlers +
        ", temperature=" + temperature +
        ", qualityOfficer=" + qualityOfficer +
        ", warehouseman=" + warehouseman +
        ", pattern=" + pattern +
        ", species=" + species +
        ", productionData=" + productionData +
        ", specification=" + specification +
        ", dosageForm=" + dosageForm +
        ", date2=" + date2 +
        "}";
    }
}