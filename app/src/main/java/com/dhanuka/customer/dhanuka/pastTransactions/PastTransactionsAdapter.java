package com.dhanuka.customer.dhanuka.pastTransactions;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhanuka.customer.dhanuka.R;
import com.dhanuka.customer.dhanuka.models.Data.PastTransactionData;

import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    @RequiresApi(api = Build.VERSION_CODES.N)
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
        @BindView(R.id.tv_customer_code)
        TextView tv_customer_code;
        @BindView(R.id.tv_date)
        TextView tv_date;
        @BindView(R.id.tv_document_type)
        TextView tv_document_type;
        @BindView(R.id.tv_document_no)
        TextView tv_document_no;
        @BindView(R.id.tv_ammount)
        TextView tv_ammount ;

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

        @RequiresApi(api = Build.VERSION_CODES.N)
        public void onBind(PastTransactionData orders) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(
                    "yyyy-MM-dd  HH:mm:ss", Locale.getDefault());
            Date date = new Date();
            tv_customer_code.setText(orders.getCustomerCode());
            tv_date.setText(dateFormat.format(date)+"");
            tv_document_type.setText(orders.getDocumentType());
            tv_document_no.setText(orders.getDocumentNo().toString());
            tv_ammount.setText(orders.getAmount().toString());


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
