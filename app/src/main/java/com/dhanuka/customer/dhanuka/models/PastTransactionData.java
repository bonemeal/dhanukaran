
package com.dhanuka.customer.dhanuka.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PastTransactionData {

    @SerializedName("product_code")
    @Expose
    private String productCode;
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("product_quantity")
    @Expose
    private String productQuantity;
    @SerializedName("mrp")
    @Expose
    private String mrp;
    @SerializedName("seller")
    @Expose
    private String seller;
    @SerializedName("date_of_transaction")
    @Expose
    private String dateOfTransaction;
    @SerializedName("commitment_ammount")
    @Expose
    private String commitmentAmmount;
    @SerializedName("commitment_date")
    @Expose
    private String commitmentDate;
    @SerializedName("payed_ammount")
    @Expose
    private String payedAmmount;
    @SerializedName("payed_on")
    @Expose
    private String payedOn;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(String dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public String getCommitmentAmmount() {
        return commitmentAmmount;
    }

    public void setCommitmentAmmount(String commitmentAmmount) {
        this.commitmentAmmount = commitmentAmmount;
    }

    public String getCommitmentDate() {
        return commitmentDate;
    }

    public void setCommitmentDate(String commitmentDate) {
        this.commitmentDate = commitmentDate;
    }

    public String getPayedAmmount() {
        return payedAmmount;
    }

    public void setPayedAmmount(String payedAmmount) {
        this.payedAmmount = payedAmmount;
    }

    public String getPayedOn() {
        return payedOn;
    }

    public void setPayedOn(String payedOn) {
        this.payedOn = payedOn;
    }

}
