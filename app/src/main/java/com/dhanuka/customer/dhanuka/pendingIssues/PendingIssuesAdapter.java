package com.dhanuka.customer.dhanuka.pendingIssues;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.models.PendingIssuesData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PendingIssuesAdapter extends RecyclerView.Adapter<PendingIssuesAdapter.ViewHolder> {
    List<PendingIssuesData> data;

    public PendingIssuesAdapter(List<PendingIssuesData> data) {
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
                viewHolder = new PendingIssuesView(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder , int position) {

        ((PendingIssuesView) holder).onBind(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void updateData(List<PendingIssuesData> data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    class PendingIssuesView extends ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_total_issues)
        TextView tv_total_issues;
        @BindView(R.id.tv_total_resolved)
        TextView tv_total_resolved;
        @BindView(R.id.tv_total_overdue)
        TextView tv_total_overdue;

        public PendingIssuesView(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        public void onBind(PendingIssuesData data) {
            tv_total_issues.setText(data.getTotalRecieved()+"");
            tv_total_resolved.setText(data.getTotalResolved()+"");
            tv_total_overdue.setText(data.getOverdue()+"");

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
