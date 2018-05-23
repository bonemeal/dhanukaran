package com.dhanuka.customer.dhanuka.db.doa;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.dhanuka.customer.dhanuka.db.DBUtils;
import com.dhanuka.customer.dhanuka.db.DhanukaDb;
import com.dhanuka.customer.dhanuka.db.table.PendingIssueTable;
import com.dhanuka.customer.dhanuka.db.table.PendingOrdersTable;
import com.dhanuka.customer.dhanuka.models.Data.PendingIssuesData;
import com.dhanuka.customer.dhanuka.models.Data.PendingOrdersData;
import com.dhanuka.customer.dhanuka.models.PendingOrdersProduct;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PendingOrdersDoa extends PendingOrdersTable {

    private DhanukaDb mDbHelper = null;

    @Inject
    public PendingOrdersDoa(DhanukaDb mDbHelper) {
        this.mDbHelper = mDbHelper;
    }

    public synchronized void savePendingIssueList(List<PendingOrdersData> pendingOrdersDataList) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        for (PendingOrdersData item : pendingOrdersDataList) {
            for (PendingOrdersProduct product : item.getProducts()) {
                Log.d("test123456","======  "+item.getBrandName()+"   "+ product.getPc()+"\n");
            }
        }

        db.beginTransaction();
        int count = 1;
        for (PendingOrdersData item : pendingOrdersDataList) {
            for (PendingOrdersProduct product : item.getProducts()) {
                ContentValues values = new ContentValues();
                values.put(BRAND_NAME, item.getBrandName());
                values.put(PC, product.getPc());
                values.put(PQ, product.getPq());
                values.put(CUSTOMER_CODE, "CAHM-0005");
                db.insert(TABLE_NAME, null, values);
                count++;
            }
        }
        db.setTransactionSuccessful();
        db.endTransaction();

    }

    public List<PendingOrdersData> getAllOrders() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        List<PendingOrdersData> list = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, BRAND_NAME);
        while (cursor.moveToNext()) {
            list.add(getBeat(cursor));
        }
        cursor.close();
        return list;
    }

    private PendingOrdersData getBeat(Cursor cursor) {
        PendingOrdersData pendingOrdersData = new PendingOrdersData();
        pendingOrdersData.setBrandName(DBUtils.getString(cursor, BRAND_NAME));
        String name = DBUtils.getString(cursor, BRAND_NAME);
        int count =1;
//        Log.d("test12345","IM INSIDE"+"    "+DBUtils.getString(cursor, BRAND_NAME)+"    "+name);
        List<PendingOrdersProduct> list = new ArrayList<>();
        while (cursor.moveToNext()&&(name.equals(DBUtils.getString(cursor, BRAND_NAME)))) {
            PendingOrdersProduct pendingOrdersProduct = new PendingOrdersProduct();
            pendingOrdersProduct.setPc(DBUtils.getString(cursor, PC));
            pendingOrdersProduct.setPq(DBUtils.getString(cursor, PQ));
            list.add(pendingOrdersProduct);
//            Log.d("test12345","IM INSIDE"+"    "+DBUtils.getString(cursor, BRAND_NAME)+"    "+name);
            count++;
        }
        pendingOrdersData.setProducts(list);
        return pendingOrdersData;
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

