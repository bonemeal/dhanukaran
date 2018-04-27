package com.dhanuka.customer.dhanuka.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<Response> data = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Response> getData() {
        return data;
    }

    public void setData(List<Response> data) {
        this.data = data;
    }

}