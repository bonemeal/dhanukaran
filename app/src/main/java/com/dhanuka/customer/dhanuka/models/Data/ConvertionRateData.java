package com.dhanuka.customer.dhanuka.models.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConvertionRateData {

    @SerializedName("customer_code")
    @Expose
    private String customerCode;
    @SerializedName("suggested_quantity")
    @Expose
    private Integer suggestedQuantity;
    @SerializedName("ordered_quantity")
    @Expose
    private Integer orderedQuantity;
    @SerializedName("date_field")
    @Expose
    private String dateField;

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getSuggestedQuantity() {
        return suggestedQuantity;
    }

    public void setSuggestedQuantity(Integer suggestedQuantity) {
        this.suggestedQuantity = suggestedQuantity;
    }

    public Integer getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(Integer orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public String getDateField() {
        return dateField;
    }

    public void setDateField(String dateField) {
        this.dateField = dateField;
    }


}