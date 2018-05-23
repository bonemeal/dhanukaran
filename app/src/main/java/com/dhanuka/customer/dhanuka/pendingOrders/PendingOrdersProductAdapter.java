package com.dhanuka.customer.dhanuka.pendingOrders;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.models.PendingOrdersProduct;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PendingOrdersProductAdapter extends RecyclerView.Adapter<PendingOrdersProductAdapter.ViewHolder> {
    List<PendingOrdersProduct> data;
    Context context;
    public PendingOrdersProductAdapter(List<PendingOrdersProduct> data, Context context) {
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
                viewHolder = new PendingProductView(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        ((PendingProductView) holder).onBind(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void updateData(List<PendingOrdersProduct> data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    class PendingProductView extends ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_product_code)
        TextView tv_product_code;
        @BindView(R.id.tv_product_name)
        TextView tv_product_name;
        @BindView(R.id.tv_pending_order_qty)
        TextView tv_pending_order_qty;


        public PendingProductView(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        public void onBind(PendingOrdersProduct orders) {
            tv_product_name.setText(orders.getPc()+"");
            tv_pending_order_qty.setText(orders.getPq()+"");

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
