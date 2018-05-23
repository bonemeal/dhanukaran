package com.dhanuka.customer.dhanuka.pendingOrders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.models.PendingOrdersProduct;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PendingOrdersProductActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    List<PendingOrdersProduct> data;

    private PendingOrdersProductAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.product_info);
        setContentView(R.layout.activity_pending_orders_product);
        ButterKnife.bind(this);

        data=getIntent().<PendingOrdersProduct>getParcelableArrayListExtra("data");


        mAdapter = new PendingOrdersProductAdapter(data,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
}
