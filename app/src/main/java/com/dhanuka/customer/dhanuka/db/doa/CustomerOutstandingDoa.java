package com.dhanuka.customer.dhanuka.db.doa;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dhanuka.customer.dhanuka.db.DBUtils;
import com.dhanuka.customer.dhanuka.db.DhanukaDb;
import com.dhanuka.customer.dhanuka.db.table.CustomerOutstandingTable;
import com.dhanuka.customer.dhanuka.models.Data.CustomerOutstandingsData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CustomerOutstandingDoa extends CustomerOutstandingTable{

    private DhanukaDb mDbHelper = null;

    @Inject
    public CustomerOutstandingDoa(DhanukaDb mDbHelper) {
        this.mDbHelper = mDbHelper;
    }

    public synchronized void saveOutstandingList(List<CustomerOutstandingsData> outstandingsDataList) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        db.beginTransaction();
        int count = 1;
        for (CustomerOutstandingsData item : outstandingsDataList) {
            ContentValues values = new ContentValues();
            values.put(ID, count);
            values.put(CREATED_ON, item.getCreatedOn());
            values.put(CUSTOMER_CODE, "CAHM-0005");
            values.put(OUTSTANDING, item.getOutstanding());
            db.insert(TABLE_NAME, null, values);
            count++;
        }
        db.setTransactionSuccessful();
        db.endTransaction();

    }

    public List<CustomerOutstandingsData> getAllOutstanding() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        List<CustomerOutstandingsData> list = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            list.add(getBeat(cursor));
        }
        cursor.close();
        return list;
    }
    private CustomerOutstandingsData getBeat(Cursor cursor) {
        CustomerOutstandingsData outstandingsData = new CustomerOutstandingsData();
        outstandingsData.setCreatedOn(DBUtils.getString(cursor, CREATED_ON));
        outstandingsData.setOutstanding(DBUtils.getString(cursor, OUTSTANDING));
        return outstandingsData;
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
