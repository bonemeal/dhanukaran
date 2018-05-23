package com.dhanuka.customer.dhanuka.customerOutstanding;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.db.DhanukaDb;
import com.dhanuka.customer.dhanuka.db.doa.CustomerOutstandingDoa;
import com.dhanuka.customer.dhanuka.models.CustomerOutstandings;
import com.dhanuka.customer.dhanuka.models.Data.CustomerOutstandingsData;
import com.dhanuka.customer.dhanuka.retrofit.NetworkClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CustomerOutstandingActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private CustomerOutstandingAdapter mAdapter;
    private List<CustomerOutstandingsData> data;
    DhanukaDb myDB;
    CustomerOutstandingDoa customerOutstandingDoa;

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.customer_outstanding);
        setContentView(R.layout.activity_customer_outstanding);
        ButterKnife.bind(this);
        data = new ArrayList<>();
        final ProgressDialog dialog = ProgressDialog.show(this, "",
                "Loading. Please wait...", true);
        myDB = new DhanukaDb(this);
        customerOutstandingDoa = new CustomerOutstandingDoa(myDB);


        mAdapter = new CustomerOutstandingAdapter(data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        if (customerOutstandingDoa.isTableExists() && !isNetworkConnected()) {

            mAdapter.updateData(customerOutstandingDoa.getAllOutstanding());

            dialog.dismiss();


        } else if (isNetworkConnected()) {


            NetworkClient.getConnectoApis(getBaseContext())
                    .getCustomerOutstanding("39360")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<CustomerOutstandings>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(CustomerOutstandings response) {
                            mAdapter.updateData(response.getData());
                            dialog.dismiss();
                            customerOutstandingDoa.saveOutstandingList(response.getData());
//                        myDB.saveBrandAdditionList(response.getData());
//                        Log.d("test12345",myDB.getAllBrandAddition().get(0).getOverdue());
                        }

                        @Override
                        public void onError(Throwable e) {
//                        Toast.makeText(getParent(), "something went wrong", Toast.LENGTH_SHORT).show();
                            Log.d("error", e.getMessage());

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } else {
            dialog.dismiss();
            new AlertDialog.Builder(this)
                    .setTitle("No Connection")
                    .setMessage("")
                    .setCancelable(false)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Whatever...
                        }
                    }).show();

        }
    }

}
