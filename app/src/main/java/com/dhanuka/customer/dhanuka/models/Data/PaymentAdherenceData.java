package com.dhanuka.customer.dhanuka.models.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentAdherenceData {

    @SerializedName("customer_code")
    @Expose
    private String customerCode;
    @SerializedName("pymt_comm_rec")
    @Expose
    private Integer pymtCommRec;
    @SerializedName("pymt_rec")
    @Expose
    private Integer pymtRec;

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getPymtCommRec() {
        return pymtCommRec;
    }

    public void setPymtCommRec(Integer pymtCommRec) {
        this.pymtCommRec = pymtCommRec;
    }

    public Integer getPymtRec() {
        return pymtRec;
    }

    public void setPymtRec(Integer pymtRec) {
        this.pymtRec = pymtRec;
    }
}

