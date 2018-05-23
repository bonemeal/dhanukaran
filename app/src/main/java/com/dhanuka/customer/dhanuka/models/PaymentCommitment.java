package com.dhanuka.customer.dhanuka.models;
import java.util.List;

import com.dhanuka.customer.dhanuka.models.Data.PaymentCommitmentData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentCommitment {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<PaymentCommitmentData> data = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<PaymentCommitmentData> getData() {
        return data;
    }

    public void setData(List<PaymentCommitmentData> data) {
        this.data = data;
    }

}