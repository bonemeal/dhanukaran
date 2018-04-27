package com.dhanuka.customer.dhanuka.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlVisitData {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("contactNo")
    @Expose
    private String contactNo;
    @SerializedName("visitDate")
    @Expose
    private String visitDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

}
