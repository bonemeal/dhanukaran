package com.dhanuka.customer.dhanuka.PastTransactions;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.flvisit.FlVisitAdapter;
import com.dhanuka.customer.dhanuka.models.FlVisit;
import com.dhanuka.customer.dhanuka.models.FlVisitData;
import com.dhanuka.customer.dhanuka.models.PastTransactionData;
import com.dhanuka.customer.dhanuka.models.PastTransactions;
import com.dhanuka.customer.dhanuka.retrofit.NetworkClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PastTransactionsActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private PastTransactionsAdapter mAdapter;
    private List<PastTransactionData> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.past_transactions);
        setContentView(R.layout.activity_past_transactions);
        ButterKnife.bind(this);
        data=new ArrayList<>();
        final ProgressDialog dialog = ProgressDialog.show(this, "",
                "Loading. Please wait...", true);

        NetworkClient.getConnectoApis(getBaseContext())
                .getPastTransaction("36240")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PastTransactions>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PastTransactions response) {
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

        mAdapter = new PastTransactionsAdapter(data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
}
