package com.dhanuka.customer.dhanuka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dhanuka.customer.dhanuka.models.BaseResponse;
import com.dhanuka.customer.dhanuka.models.Response;
import com.dhanuka.customer.dhanuka.retrofit.NetworkClient;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindViews(R.id.hello)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tv = (TextView) findViewById(R.id.hello) ;
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkClient.getConnectoApis(getBaseContext())
                        .getClassAndAlbums()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Response>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Response response) {
                                Log.d("Test12345",response.toString());

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });

            }
        });


    }
}
