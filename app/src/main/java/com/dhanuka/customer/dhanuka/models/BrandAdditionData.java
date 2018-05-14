package com.dhanuka.customer.dhanuka.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BrandAdditionData {

    @SerializedName("outlet_name")
    @Expose
    private String outletName;
    @SerializedName("outlet_account")
    @Expose
    private String outletAccount;
    @SerializedName("count_of_brand_last_year")
    @Expose
    private Integer countOfBrandLastYear;
    @SerializedName("count_of_brand_current_year")
    @Expose
    private Integer countOfBrandCurrentYear;

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public String getOutletAccount() {
        return outletAccount;
    }

    public void setOutletAccount(String outletAccount) {
        this.outletAccount = outletAccount;
    }

    public Integer getCountOfBrandLastYear() {
        return countOfBrandLastYear;
    }

    public void setCountOfBrandLastYear(Integer countOfBrandLastYear) {
        this.countOfBrandLastYear = countOfBrandLastYear;
    }

    public Integer getCountOfBrandCurrentYear() {
        return countOfBrandCurrentYear;
    }

    public void setCountOfBrandCurrentYear(Integer countOfBrandCurrentYear) {
        this.countOfBrandCurrentYear = countOfBrandCurrentYear;
    }

}
