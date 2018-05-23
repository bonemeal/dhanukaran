package com.dhanuka.customer.dhanuka.models;

import com.dhanuka.customer.dhanuka.models.Data.CustomerOutstandingsData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CustomerOutstandings {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<CustomerOutstandingsData> data = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<CustomerOutstandingsData> getData() {
        return data;
    }

    public void setData(List<CustomerOutstandingsData> data) {
        this.data = data;
    }

}
