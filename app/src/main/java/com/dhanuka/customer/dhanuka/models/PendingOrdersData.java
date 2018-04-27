
package com.dhanuka.customer.dhanuka.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PendingOrdersData {

    @SerializedName("product_code")
    @Expose
    private String productCode;
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("pending_order_qty")
    @Expose
    private String pendingOrderQty;

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

    public String getPendingOrderQty() {
        return pendingOrderQty;
    }

    public void setPendingOrderQty(String pendingOrderQty) {
        this.pendingOrderQty = pendingOrderQty;
    }

}