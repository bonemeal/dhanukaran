package com.dhanuka.customer.dhanuka.models;


import java.util.List;

import com.dhanuka.customer.dhanuka.models.Data.FlVisitData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlVisit {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<FlVisitData> data = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<FlVisitData> getData() {
        return data;
    }

    public void setData(List<FlVisitData> data) {
        this.data = data;
    }

}