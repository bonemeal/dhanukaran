package com.dhanuka.customer.dhanuka.paymentCommitment;

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
import com.dhanuka.customer.dhanuka.db.doa.BrandAdditionDoa;
import com.dhanuka.customer.dhanuka.db.doa.PaymentCommitmentDoa;
import com.dhanuka.customer.dhanuka.flvisit.FlVisitAdapter;
import com.dhanuka.customer.dhanuka.models.Data.FlVisitData;
import com.dhanuka.customer.dhanuka.models.Data.PaymentCommitmentData;
import com.dhanuka.customer.dhanuka.models.FlVisit;
import com.dhanuka.customer.dhanuka.models.PaymentCommitment;
import com.dhanuka.customer.dhanuka.retrofit.NetworkClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PaymentCommitmentActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private PaymentCommitmentAdapter mAdapter;
    private List<PaymentCommitmentData> data;
    PaymentCommitmentDoa paymentCommitmentDoa;
    DhanukaDb dhanukaDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.payment_commitment);
        setContentView(R.layout.activity_payment_commitment);
        ButterKnife.bind(this);
        data=new ArrayList<>();
        final ProgressDialog dialog = ProgressDialog.show(this, "",
                "Loading. Please wait...", true);
        dhanukaDb=new DhanukaDb(this);
        paymentCommitmentDoa=new PaymentCommitmentDoa(dhanukaDb);

        mAdapter = new PaymentCommitmentAdapter(data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        if(paymentCommitmentDoa.isTableExists()&&!isNetworkConnected()){

            mAdapter.updateData(paymentCommitmentDoa.getAllCommitment());

            dialog.dismiss();


        }
        else if( isNetworkConnected() ) {
            NetworkClient.getConnectoApis(getBaseContext())
                    .getPaymentCommitment("43192")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<PaymentCommitment>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(PaymentCommitment response) {
                            mAdapter.updateData(response.getData());
                            paymentCommitmentDoa.saveCommitmentList(response.getData());
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
