package com.dhanuka.customer.dhanuka.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PendingOrdersProduct {

    @SerializedName("pc")
    @Expose
    private String pc;
    @SerializedName("pq")
    @Expose
    private String pq;

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getPq() {
        return pq;
    }

    public void setPq(String pq) {
        this.pq = pq;
    }

}