package com.dhanuka.customer.dhanuka.paymentCommitment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.models.Data.PaymentCommitmentData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentCommitmentAdapter extends RecyclerView.Adapter<PaymentCommitmentAdapter.ViewHolder> {
        List<PaymentCommitmentData> data;

public PaymentCommitmentAdapter(List<PaymentCommitmentData> data) {
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
        viewHolder = new PaymentCommitmentView(view);
        break;
        }
        return viewHolder;
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder holder , int position) {

        ((PaymentCommitmentView) holder).onBind(data.get(position));

        }

@Override
public int getItemCount() {
        return data.size();
        }
public void updateData(List<PaymentCommitmentData> data){
        this.data.addAll(data);
        notifyDataSetChanged();
        }

class PaymentCommitmentView extends PaymentCommitmentAdapter.ViewHolder implements View.OnClickListener {
    @BindView(R.id.tv_outstanding)
    TextView tv_outstanding;
    @BindView(R.id.tv_created)
    TextView tv_created;

    public PaymentCommitmentView(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(this);
    }

    public void onBind(PaymentCommitmentData orders) {
        tv_created.setText(orders.getOutletName());
        tv_outstanding.setText(orders.getCommitmentAmmount());

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
