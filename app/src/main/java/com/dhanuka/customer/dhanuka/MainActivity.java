package com.dhanuka.customer.dhanuka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dhanuka.customer.dhanuka.flvisit.FlVisitActivity;
import com.dhanuka.customer.dhanuka.models.PendingOrders;
import com.dhanuka.customer.dhanuka.pendingOrders.PendingOrdersActivity;
import com.dhanuka.customer.dhanuka.retrofit.NetworkClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bt_pending_orders)
    Button bt_pending_orders;
    @BindView(R.id.bt_fl_visit)
    Button bt_fl_visit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        tv = (TextView) findViewById(R.id.hello) ;

        final Intent i = new Intent(this, PendingOrdersActivity.class);
        final Intent i2 = new Intent(this, FlVisitActivity.class);


        bt_pending_orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);

            }
        });
        bt_fl_visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i2);

            }
        });


    }
}
