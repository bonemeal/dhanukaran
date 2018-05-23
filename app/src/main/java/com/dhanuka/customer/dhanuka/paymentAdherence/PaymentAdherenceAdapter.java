package com.dhanuka.customer.dhanuka.paymentAdherence;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.models.Data.PaymentAdherenceData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.dhanuka.customer.dhanuka.R.*;

public class PaymentAdherenceAdapter extends RecyclerView.Adapter<PaymentAdherenceAdapter.ViewHolder> {
    List<PaymentAdherenceData> data;

    public PaymentAdherenceAdapter(List<PaymentAdherenceData> data) {
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
                viewHolder = new PaymentAdherenceView(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder , int position) {

        ((PaymentAdherenceView) holder).onBind(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void updateData(List<PaymentAdherenceData> data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    class PaymentAdherenceView extends PaymentAdherenceAdapter.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_product_code)
        TextView tv_product_code;
        @BindView(R.id.tv_product_name)
        TextView tv_product_name;
        @BindView(R.id.tv_pending_order_qty)
        TextView tv_pending_order_qty;

        public PaymentAdherenceView(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        public void onBind(PaymentAdherenceData data) {
            tv_pending_order_qty.setText(data.getPymtCommRec());
            tv_product_name.setText(data.getPymtRec());
            tv_product_code.setText(data.getCustomerCode());

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
