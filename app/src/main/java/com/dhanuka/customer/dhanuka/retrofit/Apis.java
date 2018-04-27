package com.dhanuka.customer.dhanuka.retrofit;

import com.dhanuka.customer.dhanuka.models.BaseResponse;
import com.dhanuka.customer.dhanuka.models.Response;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apis {

    @GET("/api/v1/customer/37758/pendingOrders")
    Observable<Response> getClassAndAlbums();
}
