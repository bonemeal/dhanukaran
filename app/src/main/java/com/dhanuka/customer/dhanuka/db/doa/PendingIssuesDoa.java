package com.dhanuka.customer.dhanuka.db.doa;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.dhanuka.customer.dhanuka.db.DBUtils;
import com.dhanuka.customer.dhanuka.db.DhanukaDb;
import com.dhanuka.customer.dhanuka.db.table.PendingIssueTable;
import com.dhanuka.customer.dhanuka.models.Data.PendingIssuesData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PendingIssuesDoa extends PendingIssueTable{

        private DhanukaDb mDbHelper = null;

        @Inject
        public PendingIssuesDoa(DhanukaDb mDbHelper) {
            this.mDbHelper = mDbHelper;
        }

        public synchronized void savePendingIssueList(List<PendingIssuesData> pendingIssuesDataList) {
            SQLiteDatabase db = mDbHelper.getWritableDatabase();

            db.beginTransaction();
            int count = 1;
            for (PendingIssuesData item : pendingIssuesDataList) {
                ContentValues values = new ContentValues();
                values.put(TOTLE_ISSUES, item.getTotalRecieved());
                values.put(TOTAL_RESOLVED, item.getTotalResolved());
                values.put(OVERDUE, item.getOverdue());
                values.put(CUSTOMER_CODE, "CAHM-0005");
                db.insert(TABLE_NAME, null, values);
                count++;
            }
            db.setTransactionSuccessful();
            db.endTransaction();

        }

        public List<PendingIssuesData> getAllIssues() {
            SQLiteDatabase db = mDbHelper.getReadableDatabase();
            List<PendingIssuesData> list = new ArrayList<>();

            Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                list.add(getBeat(cursor));
            }
            cursor.close();
            return list;
        }
        private PendingIssuesData getBeat(Cursor cursor) {
            PendingIssuesData pendingIssuesData = new PendingIssuesData();
            pendingIssuesData.setOverdue(DBUtils.getString(cursor, OVERDUE));
            pendingIssuesData.setTotalRecieved(DBUtils.getString(cursor, TOTLE_ISSUES));
            pendingIssuesData.setTotalResolved(DBUtils.getString(cursor, TOTAL_RESOLVED));
            return pendingIssuesData;
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
