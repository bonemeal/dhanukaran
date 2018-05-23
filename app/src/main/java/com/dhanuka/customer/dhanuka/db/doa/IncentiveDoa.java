package com.dhanuka.customer.dhanuka.db.doa;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dhanuka.customer.dhanuka.db.DhanukaDb;
import com.dhanuka.customer.dhanuka.db.table.IncentiveTable;
import com.dhanuka.customer.dhanuka.models.Data.IncentivesData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class IncentiveDoa extends IncentiveTable {

    private DhanukaDb mDbHelper = null;

    @Inject
    public IncentiveDoa(DhanukaDb mDbHelper) {
        this.mDbHelper = mDbHelper;
    }

    public synchronized void savePastTransactionList(List<IncentivesData> incentivesDataList) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        db.beginTransaction();
        int count = 1;
        for (IncentivesData item : incentivesDataList) {
            ContentValues values = new ContentValues();
            values.put(ID, count);
            values.put(CUSTOMER_CODE, item.getCustomerCode());
//            values.put(DATE, item.getPostingDate());
//            values.put(DOCUMENT_TYPE, item.getDocumentType());
//            values.put(DOCUMENT_NUMBER, item.getDocumentNo());
//            values.put(AMMOUNT, item.getAmount());
            db.insert(TABLE_NAME, null, values);
            count++;
        }
        db.setTransactionSuccessful();
        db.endTransaction();

    }

    public List<IncentivesData> getAllPastTransaction() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        List<IncentivesData> list = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            list.add(getBeat(cursor));
        }
        cursor.close();
        return list;
    }
    private IncentivesData getBeat(Cursor cursor) {
        IncentivesData incentivesData = new IncentivesData();
//        pastTransactionData.setCustomerCode(DBUtils.getString(cursor, CUSTOMER_CODE));
//        pastTransactionData.setAmount(DBUtils.getInteger(cursor, AMMOUNT));
        return incentivesData;
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