package com.dhanuka.customer.dhanuka.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dhanuka.customer.dhanuka.models.Data.PendingIssuesData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitch on 2016-05-13.
 */
public class DBHelper extends SQLiteOpenHelper {


    public static final String TABLE_NAME = "PendingIssues";

    public static final String ID = "id";
    public static final String TOTLE_ISSUES = "TotalIssues";
    public static final String TOTAL_RESOLVED = "TotalResolved";
    public static final String OVERDUE = "Overdue";


    public static final int DATABASE_VERSION = 1;
    private static final String DB_NAME = "dhanuks.db";
    private static final String INTERNAL_DB_NAME = DB_NAME;
    private static final String EXTERNAL_DB_NAME = "/sdcard/tft/" + DB_NAME;

    public static final String DATABASE_NAME = INTERNAL_DB_NAME;


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder query = new StringBuilder("CREATE TABLE ");
        query.append(TABLE_NAME);
        query.append(" ( ");
        query.append(ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ");
        query.append(TOTLE_ISSUES + " TEXT, ");
        query.append(TOTAL_RESOLVED + " TEXT, ");
        query.append(OVERDUE + " TEXT");

        query.append(" )");
        db.execSQL(String.valueOf(query));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public synchronized void savePendingIssueList(List<PendingIssuesData> pendingIssuesDataList) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.beginTransaction();
        int count = 1;
        for (PendingIssuesData item : pendingIssuesDataList) {
            ContentValues values = new ContentValues();
            values.put(ID, count);
            values.put(TOTLE_ISSUES, item.getTotalRecieved());
            values.put(TOTAL_RESOLVED, item.getTotalResolved());
            values.put(OVERDUE, item.getOverdue());
            db.insert(TABLE_NAME, null, values);
            count++;
        }
        db.setTransactionSuccessful();
        db.endTransaction();

    }

    public List<PendingIssuesData> getAllIssues() {
        SQLiteDatabase db = this.getWritableDatabase();
        List<PendingIssuesData> list = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            list.add(getPendingIssues(cursor));
        }
        cursor.close();
        return list;
    }
    private PendingIssuesData getPendingIssues(Cursor cursor) {
        PendingIssuesData pendingIssuesData = new PendingIssuesData();
        return pendingIssuesData;
    }
    public boolean isTableExists() {
        boolean isExist = false;
        SQLiteDatabase db = this.getWritableDatabase();
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