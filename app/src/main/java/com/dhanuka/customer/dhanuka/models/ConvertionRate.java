package com.dhanuka.customer.dhanuka.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConvertionRate {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<ConvertionRateData> data = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<ConvertionRateData> getData() {
        return data;
    }

    public void setData(List<ConvertionRateData> data) {
        this.data = data;
    }

}