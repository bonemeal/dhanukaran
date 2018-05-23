package com.dhanuka.customer.dhanuka.models.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IncentivesData {

    @SerializedName("customer_code")
    @Expose
    private String customerCode;
    @SerializedName("inc_april")
    @Expose
    private Integer incApril;
    @SerializedName("inc_may")
    @Expose
    private Integer incMay;
    @SerializedName("inc_june")
    @Expose
    private Integer incJune;
    @SerializedName("inc_july")
    @Expose
    private Integer incJuly;
    @SerializedName("inc_august")
    @Expose
    private Integer incAugust;
    @SerializedName("inc_september")
    @Expose
    private Integer incSeptember;
    @SerializedName("inc_october")
    @Expose
    private Integer incOctober;
    @SerializedName("inc_november")
    @Expose
    private Integer incNovember;
    @SerializedName("inc_december")
    @Expose
    private Integer incDecember;
    @SerializedName("inc_january")
    @Expose
    private Integer incJanuary;
    @SerializedName("inc_february")
    @Expose
    private Integer incFebruary;
    @SerializedName("inc_march")
    @Expose
    private Integer incMarch;

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getIncApril() {
        return incApril;
    }

    public void setIncApril(Integer incApril) {
        this.incApril = incApril;
    }

    public Integer getIncMay() {
        return incMay;
    }

    public void setIncMay(Integer incMay) {
        this.incMay = incMay;
    }

    public Integer getIncJune() {
        return incJune;
    }

    public void setIncJune(Integer incJune) {
        this.incJune = incJune;
    }

    public Integer getIncJuly() {
        return incJuly;
    }

    public void setIncJuly(Integer incJuly) {
        this.incJuly = incJuly;
    }

    public Integer getIncAugust() {
        return incAugust;
    }

    public void setIncAugust(Integer incAugust) {
        this.incAugust = incAugust;
    }

    public Integer getIncSeptember() {
        return incSeptember;
    }

    public void setIncSeptember(Integer incSeptember) {
        this.incSeptember = incSeptember;
    }

    public Integer getIncOctober() {
        return incOctober;
    }

    public void setIncOctober(Integer incOctober) {
        this.incOctober = incOctober;
    }

    public Integer getIncNovember() {
        return incNovember;
    }

    public void setIncNovember(Integer incNovember) {
        this.incNovember = incNovember;
    }

    public Integer getIncDecember() {
        return incDecember;
    }

    public void setIncDecember(Integer incDecember) {
        this.incDecember = incDecember;
    }

    public Integer getIncJanuary() {
        return incJanuary;
    }

    public void setIncJanuary(Integer incJanuary) {
        this.incJanuary = incJanuary;
    }

    public Integer getIncFebruary() {
        return incFebruary;
    }

    public void setIncFebruary(Integer incFebruary) {
        this.incFebruary = incFebruary;
    }

    public Integer getIncMarch() {
        return incMarch;
    }

    public void setIncMarch(Integer incMarch) {
        this.incMarch = incMarch;
    }

}
