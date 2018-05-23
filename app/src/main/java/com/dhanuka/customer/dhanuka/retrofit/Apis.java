package com.dhanuka.customer.dhanuka.retrofit;

import com.dhanuka.customer.dhanuka.models.BrandAddition;
import com.dhanuka.customer.dhanuka.models.ConvertionRate;
import com.dhanuka.customer.dhanuka.models.CustomerOutstandings;
import com.dhanuka.customer.dhanuka.models.FlVisit;
import com.dhanuka.customer.dhanuka.models.Incentives;
import com.dhanuka.customer.dhanuka.models.PastTransactions;
import com.dhanuka.customer.dhanuka.models.PaymentAdherence;
import com.dhanuka.customer.dhanuka.models.PaymentCommitment;
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
    @GET("/api/v1/customers/{id}/transactions/last10")
    Observable<PastTransactions> getPastTransaction(@Path("id") String idCustomer);
    @GET("/api/v1/customers/{id}/conversionRateData")
    Observable<ConvertionRate> getConversionRate(@Path("id") String idCustomer);
    @GET("/api/v1/customers/{id}/brandAdditions")
    Observable<BrandAddition> getBrandAdditions(@Path("id") String idCustomer);
    @GET("/api/v1/customers/{id}/issues/pending")
    Observable<PendingIssues> getPendingIssues(@Path("id") String idCustomer);
    @GET("/api/v1/customers/{id}/outstanding")
    Observable<CustomerOutstandings> getCustomerOutstanding(@Path("id") String idCustomer);
    @GET("/api/v1/customers/{id}/pymtCommitments/today")
    Observable<PaymentCommitment> getPaymentCommitment(@Path("id") String idCustomer);
    @GET("/api/v1/customers/{id}/paymentAdherence")
    Observable<PaymentAdherence> getPaymentAdherence(@Path("id") String idCustomer);
    @GET("/api/v1/customers/{id}/incentives")
    Observable<Incentives> getIncentives(@Path("id") String idCustomer);
}
