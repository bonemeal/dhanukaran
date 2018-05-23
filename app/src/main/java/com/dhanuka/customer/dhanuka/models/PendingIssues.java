package com.dhanuka.customer.dhanuka.models;

import java.util.List;

import com.dhanuka.customer.dhanuka.models.Data.PendingIssuesData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PendingIssues {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<PendingIssuesData> data = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<PendingIssuesData> getData() {
        return data;
    }

    public void setData(List<PendingIssuesData> data) {
        this.data = data;
    }

}
