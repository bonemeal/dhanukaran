package com.dhanuka.customer.dhanuka.db.doa;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dhanuka.customer.dhanuka.db.DBUtils;
import com.dhanuka.customer.dhanuka.db.DhanukaDb;
import com.dhanuka.customer.dhanuka.db.table.BrandAdditionTable;
import com.dhanuka.customer.dhanuka.models.Data.BrandAdditionData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class BrandAdditionDoa extends BrandAdditionTable{

    private DhanukaDb mDbHelper = null;

    @Inject
    public BrandAdditionDoa(DhanukaDb mDbHelper) {
        this.mDbHelper = mDbHelper;
    }

    public synchronized void saveBrandAdditionList(List<BrandAdditionData> pendingIssuesDataList) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        db.beginTransaction();
        int count = 1;
        for (BrandAdditionData item : pendingIssuesDataList) {
            ContentValues values = new ContentValues();
            values.put(ID, count);
            values.put(LAST_YEAR, item.getCountOfBrandLastYear());
            values.put(CURRENT_YEAR, item.getCountOfBrandCurrentYear());
            values.put(CUSTOMER_CODE, item.getOutletAccount());
            db.insert(TABLE_NAME, null, values);
            count++;
        }
        db.setTransactionSuccessful();
        db.endTransaction();

    }

    public List<BrandAdditionData> getAllBrandAddition() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        List<BrandAdditionData> list = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            list.add(getBeat(cursor));
        }
        cursor.close();
        return list;
    }
    private BrandAdditionData getBeat(Cursor cursor) {
        BrandAdditionData brandAdditionData = new BrandAdditionData();
        brandAdditionData.setCountOfBrandLastYear(DBUtils.getInteger(cursor, LAST_YEAR));
        brandAdditionData.setCountOfBrandCurrentYear(DBUtils.getInteger(cursor, CURRENT_YEAR));
        brandAdditionData.setOutletAccount(DBUtils.getString(cursor, CUSTOMER_CODE));
        return brandAdditionData;
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
