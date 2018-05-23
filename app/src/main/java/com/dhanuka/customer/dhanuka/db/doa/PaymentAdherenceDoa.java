package com.dhanuka.customer.dhanuka.db.doa;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dhanuka.customer.dhanuka.db.DBUtils;
import com.dhanuka.customer.dhanuka.db.DhanukaDb;
import com.dhanuka.customer.dhanuka.db.table.BrandAdditionTable;
import com.dhanuka.customer.dhanuka.db.table.PaymentAdherenceTable;
import com.dhanuka.customer.dhanuka.models.Data.BrandAdditionData;
import com.dhanuka.customer.dhanuka.models.Data.PaymentAdherenceData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PaymentAdherenceDoa extends PaymentAdherenceTable {

    private DhanukaDb mDbHelper = null;

    @Inject
    public PaymentAdherenceDoa(DhanukaDb mDbHelper) {
        this.mDbHelper = mDbHelper;
    }

    public synchronized void savePaymentAdherenceList(List<PaymentAdherenceData> paymentAdherenceDataList) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        db.beginTransaction();
        int count = 1;
        for (PaymentAdherenceData item : paymentAdherenceDataList) {
            ContentValues values = new ContentValues();
            values.put(ID, count);
            values.put(CUSTOMER_CODE, item.getCustomerCode());
            values.put(PAYCOMREC, item.getPymtCommRec());
            values.put(REC, item.getPymtRec());
            db.insert(TABLE_NAME, null, values);
            count++;
        }
        db.setTransactionSuccessful();
        db.endTransaction();

    }

    public List<PaymentAdherenceData> getAllPaymentAdherence() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        List<PaymentAdherenceData> list = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            list.add(getBeat(cursor));
        }
        cursor.close();
        return list;
    }
    private PaymentAdherenceData getBeat(Cursor cursor) {
        PaymentAdherenceData paymentAdherenceData = new PaymentAdherenceData();
        paymentAdherenceData.setCustomerCode(DBUtils.getString(cursor, CUSTOMER_CODE));
        paymentAdherenceData.setPymtCommRec(DBUtils.getInteger(cursor, PAYCOMREC));
        paymentAdherenceData.setPymtRec(DBUtils.getInteger(cursor, REC));
        return paymentAdherenceData;
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
