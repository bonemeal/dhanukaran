package com.dhanuka.customer.dhanuka.pendingOrders;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.models.PendingOrders;
import com.dhanuka.customer.dhanuka.models.PendingOrdersData;
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

public class PendingOrdersProductActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    List<PendingOrdersProduct> data;

    private PendingOrdersAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.pending_orders);
        setContentView(R.layout.activity_pending_orders_product);
        ButterKnife.bind(this);


//        mAdapter = new PendingOrdersAdapter(data);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(mAdapter);
    }
}
