package com.dhanuka.customer.dhanuka.retrofit;

import com.dhanuka.customer.dhanuka.models.FlVisit;
import com.dhanuka.customer.dhanuka.models.PastTransactionData;
import com.dhanuka.customer.dhanuka.models.PastTransactions;
import com.dhanuka.customer.dhanuka.models.PendingOrders;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Apis {

    @GET("/api/v1/customer/37758/pendingOrders")
    Observable<PendingOrders> getPendingOrders();
    @GET("/api/v1/customer/37758/visits/flVisits")
    Observable<FlVisit> getFlVisit();
    @GET("/api/v1/customer/37758/transactions/last3months")
    Observable<PastTransactions> getPastTransaction();
}
