package com.dhanuka.customer.dhanuka.pastTransactions;

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
import android.widget.Toast;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.db.DhanukaDb;
import com.dhanuka.customer.dhanuka.db.doa.PastTransactionDoa;
import com.dhanuka.customer.dhanuka.models.Data.PastTransactionData;
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
    DhanukaDb db;
    PastTransactionDoa pastTransactionDoa;
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.past_transactions);
        setContentView(R.layout.activity_past_transactions);
        ButterKnife.bind(this);
        data=new ArrayList<>();
        db=new DhanukaDb(this);
        pastTransactionDoa= new PastTransactionDoa(db);
        final ProgressDialog dialog = ProgressDialog.show(this, "",
                "Loading. Please wait...", true);
        mAdapter = new PastTransactionsAdapter(data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        if(pastTransactionDoa.isTableExists()&&!isNetworkConnected()){

            mAdapter.updateData(pastTransactionDoa.getAllPastTransaction());

            dialog.dismiss();


        }
        else if( isNetworkConnected() ) {
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
                            pastTransactionDoa.savePastTransactionList(response.getData());

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
                        }
                    }).show();
        }

    }
}
