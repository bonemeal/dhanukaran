package com.dhanuka.customer.dhanuka.db.doa;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dhanuka.customer.dhanuka.db.DBUtils;
import com.dhanuka.customer.dhanuka.db.DhanukaDb;
import com.dhanuka.customer.dhanuka.db.table.CustomerOutstandingTable;
import com.dhanuka.customer.dhanuka.db.table.PastTransactionTable;
import com.dhanuka.customer.dhanuka.models.Data.CustomerOutstandingsData;
import com.dhanuka.customer.dhanuka.models.Data.PastTransactionData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PastTransactionDoa extends PastTransactionTable {

    private DhanukaDb mDbHelper = null;

    @Inject
    public PastTransactionDoa(DhanukaDb mDbHelper) {
        this.mDbHelper = mDbHelper;
    }

    public synchronized void savePastTransactionList(List<PastTransactionData> pastTransactionDataList) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        db.beginTransaction();
        int count = 1;
        for (PastTransactionData item : pastTransactionDataList) {
            ContentValues values = new ContentValues();
            values.put(ID, count);
            values.put(CUSTOMER_CODE, item.getCustomerCode());
            values.put(DATE, item.getPostingDate());
            values.put(DOCUMENT_TYPE, item.getDocumentType());
            values.put(DOCUMENT_NUMBER, item.getDocumentNo());
            values.put(AMMOUNT, item.getAmount());
            db.insert(TABLE_NAME, null, values);
            count++;
        }
        db.setTransactionSuccessful();
        db.endTransaction();

    }

    public List<PastTransactionData> getAllPastTransaction() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        List<PastTransactionData> list = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            list.add(getBeat(cursor));
        }
        cursor.close();
        return list;
    }
    private PastTransactionData getBeat(Cursor cursor) {
        PastTransactionData pastTransactionData = new PastTransactionData();
        pastTransactionData.setCustomerCode(DBUtils.getString(cursor, CUSTOMER_CODE));
        pastTransactionData.setAmount(DBUtils.getInteger(cursor, AMMOUNT));
        pastTransactionData.setDocumentNo(DBUtils.getInteger(cursor, DOCUMENT_NUMBER));
        pastTransactionData.setDocumentType(DBUtils.getString(cursor, DOCUMENT_TYPE));
        pastTransactionData.setPostingDate(DBUtils.getString(cursor, DATE));
        return pastTransactionData;
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