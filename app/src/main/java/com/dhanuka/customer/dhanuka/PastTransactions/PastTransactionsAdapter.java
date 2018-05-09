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

        return R.layout.past_transactions_row;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, null);
        ViewHolder viewHolder = null;

        switch (viewType) {
            case R.layout.past_transactions_row:
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
        @BindView(R.id.tv_product_code_qty)
        TextView tv_product_code_qty;
        @BindView(R.id.tv_mrp)
        TextView tv_mrp;
        @BindView(R.id.tv_commitment_ammount)
        TextView tv_commitment_ammount;
        @BindView(R.id.tv_payed_on)
        TextView tv_payed_on;
        @BindView(R.id.tv_seller_name)
        TextView tv_seller_name;
        @BindView(R.id.tv_commitment_date)
        TextView tv_commitment_date;
        @BindView(R.id.tv_payed_ammount)
        TextView tv_payed_ammount;
        @BindView(R.id.tv_date_of_transaction)
        TextView tv_date_of_transaction;

        public PastTransactionView(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

//        public void onBind(PastTransactionData orders) {
//            tv_commitment_ammount.setText("Amount: "+orders.getCommitmentAmmount());
//            tv_commitment_date.setText("commitment date: "+orders.getCommitmentDate());
//            tv_date_of_transaction.setText("date: "+orders.getDateOfTransaction());
//            tv_mrp.setText("Mrp: "+orders.getMrp());
//            tv_payed_ammount.setText("payed ammount: "+orders.getPayedAmmount());
//            tv_payed_on.setText("payed on:"+orders.getPayedOn());
//            tv_product_code.setText("code: "+orders.getProductCode());
//            tv_product_name.setText(orders.getProductName());
//            tv_seller_name.setText("seller name:"+orders.getSeller());
//            tv_product_code_qty.setText(orders.getProductQuantity());
//
//
//        }

        public void onBind(PastTransactionData orders) {
            tv_commitment_ammount.setText(orders.getCommitmentAmmount());
            tv_commitment_date.setText(orders.getCommitmentDate());
            tv_date_of_transaction.setText(orders.getDateOfTransaction());
            tv_mrp.setText(orders.getMrp());
            tv_payed_ammount.setText(orders.getPayedAmmount());
            tv_payed_on.setText(orders.getPayedOn());
            tv_product_code.setText(orders.getProductCode());
            tv_product_name.setText(orders.getProductName());
            tv_seller_name.setText(orders.getSeller());
            tv_product_code_qty.setText(orders.getProductQuantity());


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
