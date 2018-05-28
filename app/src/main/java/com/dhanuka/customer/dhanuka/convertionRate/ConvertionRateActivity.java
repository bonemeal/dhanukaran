package com.dhanuka.customer.dhanuka.convertionRate;

import android.app.ProgressDialog;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.models.ConvertionRate;
import com.dhanuka.customer.dhanuka.models.Data.ConvertionRateData;
import com.dhanuka.customer.dhanuka.retrofit.NetworkClient;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ConvertionRateActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    ArrayList<Float> arl = new ArrayList<Float>();

    private ConvertionRateAdapter mAdapter;
    private List<ConvertionRateData> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.convertion_rate);
        setContentView(R.layout.activity_convertion_rate);
        ButterKnife.bind(this);
        data = new ArrayList<>();
        final ProgressDialog dialog = ProgressDialog.show(this, "",
                "Loading. Please wait...", true);

        NetworkClient.getConnectoApis(getBaseContext())
                .getConversionRate("37758")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ConvertionRate>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onNext(ConvertionRate response) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat(
                                "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
                        Date date = null;
                        float avg = 0;


                        for (int i = 0; i < 12; i++) {
                            avg = 0;
                            for (ConvertionRateData item : response.getData()) {
                                try {
                                    date = dateFormat.parse(item.getDateField());
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (date.getMonth() == i) {
                                    avg = avg + (((float) item.getOrderedQuantity() / (float) item.getSuggestedQuantity()) *100);
                                }
                            }
                            arl.add(avg);
                        }
                        mAdapter.updateData(response.getData(), arl);
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

        mAdapter = new ConvertionRateAdapter(data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
}
