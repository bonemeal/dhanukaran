package com.dhanuka.customer.dhanuka.models;

import java.util.List;

import com.dhanuka.customer.dhanuka.models.Data.PendingOrdersData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PendingOrders {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<PendingOrdersData> data = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<PendingOrdersData> getData() {
        return data;
    }

    public void setData(List<PendingOrdersData> data) {
        this.data = data;
    }

}