package com.dhanuka.customer.dhanuka.convertionRate;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.models.ConvertionRateData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConvertionRateAdapter extends RecyclerView.Adapter<ConvertionRateAdapter.ViewHolder> {
    List<ConvertionRateData> data;

    public ConvertionRateAdapter(List<ConvertionRateData> data) {
        this.data = data;
    }


    @Override
    public int getItemViewType(int position) {

        return R.layout.convertion_rate_row;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, null);
        ViewHolder viewHolder = null;

        switch (viewType) {
            case R.layout.convertion_rate_row:
                viewHolder = new ConvectionRateView(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ((ConvectionRateView) holder).onBind(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void updateData(List<ConvertionRateData> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    class ConvectionRateView extends ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_date)
        TextView tv_date;
        @BindView(R.id.tv_suggested_quantity)
        TextView tv_suggested_quantity;
        @BindView(R.id.tv_ordered_quantity)
        TextView tv_ordered_quantity;

        public ConvectionRateView(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void onBind(ConvertionRateData data) {

            tv_date.setText(data.getDate());
            tv_suggested_quantity.setText(data.getSuggestedQuantity());
            tv_ordered_quantity.setText(data.getOrderedQuantity());
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
