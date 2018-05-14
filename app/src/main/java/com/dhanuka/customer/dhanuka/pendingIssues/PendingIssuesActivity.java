package com.dhanuka.customer.dhanuka.pendingIssues;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.brandAdditions.BrandAdditionsAdapter;
import com.dhanuka.customer.dhanuka.models.BrandAddition;
import com.dhanuka.customer.dhanuka.models.BrandAdditionData;
import com.dhanuka.customer.dhanuka.models.PendingIssues;
import com.dhanuka.customer.dhanuka.models.PendingIssuesData;
import com.dhanuka.customer.dhanuka.retrofit.NetworkClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PendingIssuesActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private PendingIssuesAdapter mAdapter;
    private List<PendingIssuesData> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.pending_issues);
        setContentView(R.layout.activity_pending_issues);
        ButterKnife.bind(this);
        data=new ArrayList<>();
        final ProgressDialog dialog = ProgressDialog.show(this, "",
                "Loading. Please wait...", true);
        NetworkClient.getConnectoApis(getBaseContext())
                .getPendingIssues("36241")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PendingIssues>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PendingIssues response) {
                        mAdapter.updateData(response.getData());
                        dialog.dismiss();

                    }

                    @Override
                    public void onError(Throwable e) {
//                        Toast.makeText(getParent(), "something went wrong", Toast.LENGTH_SHORT).show();
                        Log.d("error",e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        mAdapter = new PendingIssuesAdapter(data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
}
