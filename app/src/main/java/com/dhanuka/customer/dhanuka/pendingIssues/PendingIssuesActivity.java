package com.dhanuka.customer.dhanuka.pendingIssues;

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
import com.dhanuka.customer.dhanuka.db.DBHelper;
import com.dhanuka.customer.dhanuka.db.DhanukaDb;
import com.dhanuka.customer.dhanuka.db.doa.PendingIssuesDoa;
import com.dhanuka.customer.dhanuka.models.PendingIssues;
import com.dhanuka.customer.dhanuka.models.Data.PendingIssuesData;
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
    PendingIssuesDoa pendingIssuesDoa;
    DBHelper myDB;
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.pending_issues);
        setContentView(R.layout.activity_pending_issues);
        ButterKnife.bind(this);

        myDB = new DBHelper(this);

        DhanukaDb dhanukaDb= new DhanukaDb(this);
        pendingIssuesDoa=new PendingIssuesDoa(dhanukaDb);
        data=new ArrayList<>();
        final ProgressDialog dialog = ProgressDialog.show(this, "",
                "Loading. Please wait...", true);

        mAdapter = new PendingIssuesAdapter(data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        if(pendingIssuesDoa.isTableExists()&&!isNetworkConnected()){

            mAdapter.updateData(pendingIssuesDoa.getAllIssues());

            dialog.dismiss();


        }
        else if( isNetworkConnected() ) {
            NetworkClient.getConnectoApis(getBaseContext())
                    .getPendingIssues("39360")
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
                            pendingIssuesDoa.savePendingIssueList(response.getData());
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d("error", e.getMessage());

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
        else{
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
