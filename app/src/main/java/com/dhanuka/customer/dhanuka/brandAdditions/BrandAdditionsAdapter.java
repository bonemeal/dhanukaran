package com.dhanuka.customer.dhanuka.brandAdditions;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.models.BrandAdditionData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BrandAdditionsAdapter extends RecyclerView.Adapter<BrandAdditionsAdapter.ViewHolder> {
    List<BrandAdditionData> data;

    public BrandAdditionsAdapter(List<BrandAdditionData> data) {
        this.data = data;
    }


    @Override
    public int getItemViewType(int position) {

        return R.layout.brand_additions_row;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, null);
        ViewHolder viewHolder = null;

        switch (viewType) {
            case R.layout.brand_additions_row:
                viewHolder = new BrandAdditionView(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ((BrandAdditionView) holder).onBind(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void updateData(List<BrandAdditionData> data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    class BrandAdditionView extends BrandAdditionsAdapter.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_current_year)
        TextView tv_current_year;
        @BindView(R.id.tv_past_year)
        TextView tv_past_year;

        public BrandAdditionView(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        public void onBind(BrandAdditionData data) {
            tv_past_year.setText(data.getCountOfBrandLastYear()+"");
            tv_current_year.setText(data.getCountOfBrandCurrentYear()+"");

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