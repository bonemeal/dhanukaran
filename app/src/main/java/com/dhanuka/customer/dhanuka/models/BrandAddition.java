package com.dhanuka.customer.dhanuka.models;

import java.util.List;

import com.dhanuka.customer.dhanuka.models.Data.BrandAdditionData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BrandAddition {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<BrandAdditionData> data = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<BrandAdditionData> getData() {
        return data;
    }

    public void setData(List<BrandAdditionData> data) {
        this.data = data;
    }

}
