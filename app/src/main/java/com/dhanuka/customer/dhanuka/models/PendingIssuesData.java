package com.dhanuka.customer.dhanuka.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PendingIssuesData {

    @SerializedName("total_recieved")
    @Expose
    private String totalRecieved;
    @SerializedName("total_resolved")
    @Expose
    private String totalResolved;
    @SerializedName("overdue")
    @Expose
    private String overdue;

    public String getTotalRecieved() {
        return totalRecieved;
    }

    public void setTotalRecieved(String totalRecieved) {
        this.totalRecieved = totalRecieved;
    }

    public String getTotalResolved() {
        return totalResolved;
    }

    public void setTotalResolved(String totalResolved) {
        this.totalResolved = totalResolved;
    }

    public String getOverdue() {
        return overdue;
    }

    public void setOverdue(String overdue) {
        this.overdue = overdue;
    }

}