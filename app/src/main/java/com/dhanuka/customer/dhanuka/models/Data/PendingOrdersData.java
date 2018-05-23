
package com.dhanuka.customer.dhanuka.models.Data;

import com.dhanuka.customer.dhanuka.models.PendingOrdersProduct;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PendingOrdersData {

    @SerializedName("brandName")
    @Expose
    private String brandName;
    @SerializedName("products")
    @Expose
    private List<PendingOrdersProduct> products = null;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<PendingOrdersProduct> getProducts() {
        return products;
    }

    public void setProducts(List<PendingOrdersProduct> products) {
        this.products = products;
    }

}