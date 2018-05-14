package com.dhanuka.customer.dhanuka.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConvertionRateData {

    @SerializedName("suggested_quantity")
    @Expose
    private String suggestedQuantity;
    @SerializedName("ordered_quantity")
    @Expose
    private String orderedQuantity;
    @SerializedName("date")
    @Expose
    private String date;

    public String getSuggestedQuantity() {
        return suggestedQuantity;
    }

    public void setSuggestedQuantity(String suggestedQuantity) {
        this.suggestedQuantity = suggestedQuantity;
    }

    public String getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(String orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}