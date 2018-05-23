package com.dhanuka.customer.dhanuka.models.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConvertionRateData {

    @SerializedName("suggested_quantity")
    @Expose
    private Integer suggestedQuantity;
    @SerializedName("ordered_quantity")
    @Expose
    private Integer orderedQuantity;
    @SerializedName("date")
    @Expose
    private String date;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}