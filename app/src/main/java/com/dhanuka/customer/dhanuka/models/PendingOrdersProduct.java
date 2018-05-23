package com.dhanuka.customer.dhanuka.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PendingOrdersProduct implements Parcelable {

    @SerializedName("pc")
    @Expose
    private String pc;
    @SerializedName("pq")
    @Expose
    private String pq;
    public PendingOrdersProduct() {
    }

    public PendingOrdersProduct(Parcel in) {
        pc = in.readString();
        pq = in.readString();
    }

    public static final Creator<PendingOrdersProduct> CREATOR = new Creator<PendingOrdersProduct>() {
        @Override
        public PendingOrdersProduct createFromParcel(Parcel in) {
            return new PendingOrdersProduct(in);
        }

        @Override
        public PendingOrdersProduct[] newArray(int size) {
            return new PendingOrdersProduct[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pc);
        dest.writeString(pq);
    }
}