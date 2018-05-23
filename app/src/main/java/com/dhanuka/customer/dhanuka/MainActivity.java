package com.dhanuka.customer.dhanuka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dhanuka.customer.dhanuka.customerOutstanding.CustomerOutstandingActivity;
import com.dhanuka.customer.dhanuka.incentives.IncentivesActivity;
import com.dhanuka.customer.dhanuka.models.PaymentAdherence;
import com.dhanuka.customer.dhanuka.models.PaymentCommitment;
import com.dhanuka.customer.dhanuka.pastTransactions.PastTransactionsActivity;
import com.dhanuka.customer.dhanuka.brandAdditions.BrandAdditionsActivity;
import com.dhanuka.customer.dhanuka.convertionRate.ConvertionRateActivity;
import com.dhanuka.customer.dhanuka.flvisit.FlVisitActivity;
import com.dhanuka.customer.dhanuka.paymentAdherence.PaymentAdherenceActivity;
import com.dhanuka.customer.dhanuka.paymentCommitment.PaymentCommitmentActivity;
import com.dhanuka.customer.dhanuka.pendingIssues.PendingIssuesActivity;
import com.dhanuka.customer.dhanuka.pendingOrders.PendingOrdersActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    @BindView(R.id.bt_customer_outstanding)
    Button bt_customer_outstanding;
    @BindView(R.id.bt_payment_commitment)
    Button bt_payment_commitment;
    @BindView(R.id.bt_payment_adherence)
    Button bt_payment_adherence;
    @BindView(R.id.bt_incentives)
    Button bt_incentives;


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
        final Intent i7 = new Intent(this, CustomerOutstandingActivity.class);
        final Intent i8 = new Intent(this, PaymentCommitmentActivity.class);
        final Intent i9 = new Intent(this, PaymentAdherenceActivity.class);
        final Intent i10 = new Intent(this, IncentivesActivity.class);


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
        bt_customer_outstanding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i7);

            }
        });
        bt_payment_commitment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i8);

            }
        });
        bt_payment_adherence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i9);

            }
        });
        bt_incentives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i10);

            }
        });


    }
}
