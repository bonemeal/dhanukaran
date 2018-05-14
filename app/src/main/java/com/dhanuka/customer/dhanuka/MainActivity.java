package com.dhanuka.customer.dhanuka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dhanuka.customer.dhanuka.PastTransactions.PastTransactionsActivity;
import com.dhanuka.customer.dhanuka.brandAdditions.BrandAdditionsActivity;
import com.dhanuka.customer.dhanuka.convertionRate.ConvertionRateActivity;
import com.dhanuka.customer.dhanuka.flvisit.FlVisitActivity;
import com.dhanuka.customer.dhanuka.models.PastTransactions;
import com.dhanuka.customer.dhanuka.models.PendingIssues;
import com.dhanuka.customer.dhanuka.models.PendingOrders;
import com.dhanuka.customer.dhanuka.pendingIssues.PendingIssuesActivity;
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
    @BindView(R.id.bt_past_transactions)
    Button bt_past_transactions;
    @BindView(R.id.bt_convertion_rate)
    Button bt_convertion_rate;
    @BindView(R.id.bt_brand_addition)
    Button bt_brand_addition;
    @BindView(R.id.bt_pending_isssues)
    Button bt_pending_isssues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        tv = (TextView) findViewById(R.id.hello) ;

        final Intent i = new Intent(this, PendingOrdersActivity.class);
        final Intent i2 = new Intent(this, FlVisitActivity.class);
        final Intent i3 = new Intent(this, PastTransactionsActivity.class);
        final Intent i4 = new Intent(this, ConvertionRateActivity.class);
        final Intent i5 = new Intent(this, BrandAdditionsActivity.class);
        final Intent i6 = new Intent(this, PendingIssuesActivity.class);


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
        bt_past_transactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i3);

            }
        });
        bt_convertion_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i4);

            }
        });
        bt_brand_addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i5);

            }
        });
        bt_pending_isssues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i6);

            }
        });


    }
}
