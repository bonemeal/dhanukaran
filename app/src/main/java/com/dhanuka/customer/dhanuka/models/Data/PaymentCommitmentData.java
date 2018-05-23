package com.dhanuka.customer.dhanuka.models.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentCommitmentData {

    @SerializedName("outlet_name")
    @Expose
    private String outletName;
    @SerializedName("commitment_ammount")
    @Expose
    private String commitmentAmmount;

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public String getCommitmentAmmount() {
        return commitmentAmmount;
    }

    public void setCommitmentAmmount(String commitmentAmmount) {
        this.commitmentAmmount = commitmentAmmount;
    }

}