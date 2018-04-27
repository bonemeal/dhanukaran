package com.dhanuka.customer.dhanuka.PastTransactions;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.models.PastTransactionData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PastTransactionsAdapter extends RecyclerView.Adapter<PastTransactionsAdapter.ViewHolder> {
    List<PastTransactionData> data;

    public PastTransactionsAdapter(List<PastTransactionData> data) {
        this.data = data;
    }


    @Override
    public int getItemViewType(int position) {

        return R.layout.pending_orders_row;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, null);
        ViewHolder viewHolder = null;

        switch (viewType) {
            case R.layout.pending_orders_row:
                viewHolder = new PastTransactionView(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder , int position) {

        ((PastTransactionView) holder).onBind(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void updateData(List<PastTransactionData> data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    class PastTransactionView extends PastTransactionsAdapter.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_product_code)
        TextView tv_product_code;
        @BindView(R.id.tv_product_name)
        TextView tv_product_name;
        @BindView(R.id.tv_pending_order_qty)
        TextView tv_pending_order_qty;

        public PastTransactionView(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        public void onBind(PastTransactionData orders) {
//            tv_pending_order_qty.setText(orders.getVisitDatgit

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
