package com.dhanuka.customer.dhanuka.models;

import java.util.List;

import com.dhanuka.customer.dhanuka.models.Data.IncentivesData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Incentives {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<IncentivesData> data = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<IncentivesData> getData() {
        return data;
    }

    public void setData(List<IncentivesData> data) {
        this.data = data;
    }

}