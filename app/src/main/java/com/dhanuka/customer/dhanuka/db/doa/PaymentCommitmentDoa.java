package com.dhanuka.customer.dhanuka.db.doa;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dhanuka.customer.dhanuka.db.DBUtils;
import com.dhanuka.customer.dhanuka.db.DhanukaDb;
import com.dhanuka.customer.dhanuka.db.table.CustomerOutstandingTable;
import com.dhanuka.customer.dhanuka.db.table.PaymentCommitmentTable;
import com.dhanuka.customer.dhanuka.models.Data.CustomerOutstandingsData;
import com.dhanuka.customer.dhanuka.models.Data.PaymentCommitmentData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PaymentCommitmentDoa extends PaymentCommitmentTable {

    private DhanukaDb mDbHelper = null;

    @Inject
    public PaymentCommitmentDoa(DhanukaDb mDbHelper) {
        this.mDbHelper = mDbHelper;
    }

    public synchronized void saveCommitmentList(List<PaymentCommitmentData> paymentCommitmentDataList) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        db.beginTransaction();
        int count = 1;
        for (PaymentCommitmentData item : paymentCommitmentDataList) {
            ContentValues values = new ContentValues();
            values.put(ID, count);
            values.put(OUTLET_NAME, item.getOutletName());
            values.put(AMMOUNT, item.getCommitmentAmmount());
            values.put(CUSTOMER_CODE, "CAHM-0005");
            db.insert(TABLE_NAME, null, values);
            count++;
        }
        db.setTransactionSuccessful();
        db.endTransaction();

    }

    public List<PaymentCommitmentData> getAllCommitment() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        List<PaymentCommitmentData> list = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            list.add(getBeat(cursor));
        }
        cursor.close();
        return list;
    }
    private PaymentCommitmentData getBeat(Cursor cursor) {
        PaymentCommitmentData paymentCommitmentData = new PaymentCommitmentData();
        paymentCommitmentData.setOutletName(DBUtils.getString(cursor, OUTLET_NAME));
        paymentCommitmentData.setCommitmentAmmount(DBUtils.getString(cursor, AMMOUNT));
        return paymentCommitmentData;
    }
    public boolean isTableExists() {
        boolean isExist = false;
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '" + TABLE_NAME + "'", null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                isExist = true;
            }
            cursor.close();
        }
        return isExist;
    }
}
