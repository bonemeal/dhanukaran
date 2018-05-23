package com.dhanuka.customer.dhanuka.customerOutstanding;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.models.Data.CustomerOutstandingsData;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

class CustomerOutstandingAdapter extends RecyclerView.Adapter<CustomerOutstandingAdapter.ViewHolder> {
    List<CustomerOutstandingsData> data;

    public CustomerOutstandingAdapter(List<CustomerOutstandingsData> data) {
        this.data = data;
    }


    @Override
    public int getItemViewType(int position) {

        return R.layout.customer_outstanding_row;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, null);
        ViewHolder viewHolder = null;

        switch (viewType) {
            case R.layout.customer_outstanding_row:
                viewHolder = new CustomerOutstandingView(view);
                break;
        }
        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder , int position) {

        ((CustomerOutstandingView) holder).onBind(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void updateData(List<CustomerOutstandingsData> data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    class CustomerOutstandingView extends ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_created)
        TextView tv_created;
        @BindView(R.id.tv_outstanding)
        TextView tv_outstanding;

        public CustomerOutstandingView(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        public void onBind(CustomerOutstandingsData data) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(
                    "yyyy-MM-dd  HH:mm:ss", Locale.getDefault());
            Date date = new Date();
            tv_outstanding.setText(data.getOutstanding()+"");
            tv_created.setText(dateFormat.format(date)+"");

        }

        @Override
        public void onClick(View view) {
        }
    }


    abstract class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
