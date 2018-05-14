package com.dhanuka.customer.dhanuka.retrofit;

import com.dhanuka.customer.dhanuka.models.BrandAddition;
import com.dhanuka.customer.dhanuka.models.ConvertionRate;
import com.dhanuka.customer.dhanuka.models.FlVisit;
import com.dhanuka.customer.dhanuka.models.PastTransactionData;
import com.dhanuka.customer.dhanuka.models.PastTransactions;
import com.dhanuka.customer.dhanuka.models.PendingIssues;
import com.dhanuka.customer.dhanuka.models.PendingOrders;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Apis {

    @GET("/api/v1/customers/{id}/orders/pending")
    Observable<PendingOrders> getPendingOrders(@Path("id") String idCustomer);
    @GET("/api/v1/customers/{id}/visits/flVisits")
    Observable<FlVisit> getFlVisit(@Path("id") String idCustomer);
    @GET("/api/v1/customers/{id}/transactions/last3months")
    Observable<PastTransactions> getPastTransaction(@Path("id") String idCustomer);
    @GET("/api/v1/customers/{id}/conversionRate")
    Observable<ConvertionRate> getConversionRate(@Path("id") String idCustomer);
    @GET("/api/v1/customers/{id}/brandAdditions")
    Observable<BrandAddition> getBrandAdditions(@Path("id") String idCustomer);
    @GET("/api/v1/customers/{id}/issues/pending")
    Observable<PendingIssues> getPendingIssues(@Path("id") String idCustomer);
}
