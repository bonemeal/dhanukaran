package com.dhanuka.customer.dhanuka.pendingOrders;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.models.PendingOrdersData;
import com.dhanuka.customer.dhanuka.models.PendingOrders;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.pending_orders);
        setContentView(R.layout.activity_pending_orders);
        ButterKnife.bind(this);
        data=new ArrayList<>();
        final ProgressDialog dialog = ProgressDialog.show(this, "",
                "Loading. Please wait...", true);

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

        mAdapter = new PendingOrdersAdapter(data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }
}
