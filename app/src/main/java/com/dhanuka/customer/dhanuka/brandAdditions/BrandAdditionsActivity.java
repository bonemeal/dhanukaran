package com.dhanuka.customer.dhanuka.brandAdditions;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.models.BrandAddition;
import com.dhanuka.customer.dhanuka.models.BrandAdditionData;
import com.dhanuka.customer.dhanuka.retrofit.NetworkClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class BrandAdditionsActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private BrandAdditionsAdapter mAdapter;
    private List<BrandAdditionData> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.brand_addition);
        setContentView(R.layout.activity_brand_additions);
        ButterKnife.bind(this);
        data=new ArrayList<>();
        final ProgressDialog dialog = ProgressDialog.show(this, "",
                "Loading. Please wait...", true);
        NetworkClient.getConnectoApis(getBaseContext())
                .getBrandAdditions("36241")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BrandAddition>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BrandAddition response) {
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

        mAdapter = new BrandAdditionsAdapter(data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
}
