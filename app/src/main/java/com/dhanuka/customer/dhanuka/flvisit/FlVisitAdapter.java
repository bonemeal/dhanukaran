package com.dhanuka.customer.dhanuka.flvisit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.models.Data.FlVisitData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlVisitAdapter extends RecyclerView.Adapter<FlVisitAdapter.ViewHolder> {
    List<FlVisitData> data;

    public FlVisitAdapter(List<FlVisitData> data) {
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
                viewHolder = new FlVisitView(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder , int position) {

        ((FlVisitView) holder).onBind(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void updateData(List<FlVisitData> data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    class FlVisitView extends FlVisitAdapter.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_product_code)
        TextView tv_product_code;
        @BindView(R.id.tv_product_name)
        TextView tv_product_name;
        @BindView(R.id.tv_pending_order_qty)
        TextView tv_pending_order_qty;

        public FlVisitView(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        public void onBind(FlVisitData orders) {
            tv_pending_order_qty.setText(orders.getVisitDate());
            tv_product_code.setText(orders.getContactNo());
            tv_product_name.setText(orders.getName());

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
