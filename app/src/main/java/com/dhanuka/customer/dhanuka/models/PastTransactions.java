
package com.dhanuka.customer.dhanuka.models;

import java.util.List;

import com.dhanuka.customer.dhanuka.models.Data.PastTransactionData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PastTransactions {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<PastTransactionData> data = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<PastTransactionData> getData() {
        return data;
    }

    public void setData(List<PastTransactionData> data) {
        this.data = data;
    }

}
