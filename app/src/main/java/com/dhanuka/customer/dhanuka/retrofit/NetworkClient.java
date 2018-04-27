package com.dhanuka.customer.dhanuka.retrofit;

import android.content.Context;
import android.text.TextUtils;

import com.dhanuka.customer.dhanuka.constants.Constants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {
    private static Retrofit retrofit;

    private NetworkClient() {
    }

    private NetworkClient(Context context) {

//        final String auth = Utils.getAuthToken(context);
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        // set your desired log level
//        logging.setLevel(HttpLoggingInterceptor.Level.NONE);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(1, TimeUnit.MINUTES);
        httpClient.readTimeout(30, TimeUnit.SECONDS);
        httpClient.writeTimeout(30, TimeUnit.SECONDS);
//        httpClient.addInterceptor(logging);
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

//                if (!TextUtils.isEmpty(auth)) {
//                    Request request = original.newBuilder()
//                            .header("Access-Token", auth)
//                            .method(original.method(), original.body())
//                            .build();
//                    return chain.proceed(request);
//                }

                return chain.proceed(original);
            }
        });

        OkHttpClient client = httpClient.build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.REQUEST_HEADER_SHORT1)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Apis getConnectoApis(Context context) {
        if (retrofit == null)
            new NetworkClient(context);
        return retrofit.create(Apis.class);
    }

    public static void clearRetrofitInstance() {
        retrofit = null;
    }

}
