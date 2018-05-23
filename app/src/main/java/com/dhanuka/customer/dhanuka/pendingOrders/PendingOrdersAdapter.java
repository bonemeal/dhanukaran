package com.dhanuka.customer.dhanuka.pendingOrders;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.models.Data.PendingOrdersData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PendingOrdersAdapter extends RecyclerView.Adapter<PendingOrdersAdapter.ViewHolder> {
    List<PendingOrdersData> data;
    Context context;
    public PendingOrdersAdapter(List<PendingOrdersData> data, Context context) {
        this.context=context;
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
                viewHolder = new PendingOrderView(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,PendingOrdersProductActivity.class);
                i.putParcelableArrayListExtra("data", (ArrayList<? extends Parcelable>) data.get(position).getProducts());
                i.putExtra("position", position);
                context.startActivity((i));


            }
        });

        ((PendingOrderView) holder).onBind(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void updateData(List<PendingOrdersData> data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    class PendingOrderView extends ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_product_code)
        TextView tv_product_code;
        @BindView(R.id.tv_product_name)
        TextView tv_product_name;
        @BindView(R.id.tv_pending_order_qty)
        TextView tv_pending_order_qty;
        PendingOrdersData orders;


        public PendingOrderView(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        public void onBind(PendingOrdersData orders) {
            this.orders=orders;
            tv_product_name.setText(orders.getBrandName()+"");
            tv_pending_order_qty.setText(orders.getProducts().size()+"");

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
