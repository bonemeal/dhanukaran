package com.dhanuka.customer.dhanuka.models;

import java.util.List;

import com.dhanuka.customer.dhanuka.models.Data.PaymentAdherenceData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentAdherence {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<PaymentAdherenceData> data = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<PaymentAdherenceData> getData() {
        return data;
    }

    public void setData(List<PaymentAdherenceData> data) {
        this.data = data;
    }

}