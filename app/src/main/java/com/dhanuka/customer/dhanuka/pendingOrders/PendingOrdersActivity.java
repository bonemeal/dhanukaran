package com.dhanuka.customer.dhanuka.pendingOrders;

import android.app.ProgressDialog;
import android.content.ContentValues;
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
import android.widget.Toast;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.db.DhanukaDb;
import com.dhanuka.customer.dhanuka.db.doa.PendingOrdersDoa;
import com.dhanuka.customer.dhanuka.models.Data.PendingOrdersData;
import com.dhanuka.customer.dhanuka.models.PendingOrders;
import com.dhanuka.customer.dhanuka.models.PendingOrdersProduct;
import com.dhanuka.customer.dhanuka.retrofit.NetworkClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PendingOrdersActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private PendingOrdersAdapter mAdapter;
    private List<PendingOrdersData> data;
    PendingOrdersDoa pendingOrdersDoa;
    DhanukaDb dhanukaDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.pending_orders);
        setContentView(R.layout.activity_pending_orders);
        ButterKnife.bind(this);
        data=new ArrayList<>();
        dhanukaDb=new DhanukaDb(this);
        pendingOrdersDoa=new PendingOrdersDoa(dhanukaDb);

        mAdapter = new PendingOrdersAdapter(data,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        final ProgressDialog dialog = ProgressDialog.show(this, "",
                "Loading. Please wait...", true);
        if(pendingOrdersDoa.isTableExists()&&!isNetworkConnected()){
            for (PendingOrdersData item : pendingOrdersDoa.getAllOrders()) {
                for (PendingOrdersProduct product : item.getProducts()) {
                }
                }

            mAdapter.updateData(pendingOrdersDoa.getAllOrders());

            dialog.dismiss();


        }

        else if( isNetworkConnected() ) {
            NetworkClient.getConnectoApis(getBaseContext())
                    .getPendingOrders("37758")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<PendingOrders>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(PendingOrders response) {
                            mAdapter.updateData(response.getData());
                            pendingOrdersDoa.savePendingIssueList(response.getData());

                            for (PendingOrdersData item : response.getData()) {
                                for (PendingOrdersProduct product : item.getProducts()) {
                                }
                            }

                            dialog.dismiss();

                        }

                        @Override
                        public void onError(Throwable e) {

                            Toast.makeText(getParent(), "something went wrong", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
        else{
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
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
