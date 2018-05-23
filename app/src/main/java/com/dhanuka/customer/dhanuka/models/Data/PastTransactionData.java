
package com.dhanuka.customer.dhanuka.models.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PastTransactionData {

    @SerializedName("customer_code")
    @Expose
    private String customerCode;
    @SerializedName("posting_date")
    @Expose
    private String postingDate;
    @SerializedName("document_type")
    @Expose
    private String documentType;
    @SerializedName("document_no")
    @Expose
    private Integer documentNo;
    @SerializedName("amount")
    @Expose
    private Integer amount;

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Integer getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(Integer documentNo) {
        this.documentNo = documentNo;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
