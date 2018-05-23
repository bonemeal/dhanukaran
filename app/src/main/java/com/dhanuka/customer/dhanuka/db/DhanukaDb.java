package com.dhanuka.customer.dhanuka.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dhanuka.customer.dhanuka.db.doa.PendingOrdersDoa;
import com.dhanuka.customer.dhanuka.db.table.BrandAdditionTable;
import com.dhanuka.customer.dhanuka.db.table.CustomerOutstandingTable;
import com.dhanuka.customer.dhanuka.db.table.PastTransactionTable;
import com.dhanuka.customer.dhanuka.db.table.PaymentCommitmentTable;
import com.dhanuka.customer.dhanuka.db.table.PendingIssueTable;

import javax.inject.Inject;

public class DhanukaDb extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    private static final String DB_NAME = "dhanuk.db";
    private static final String INTERNAL_DB_NAME = DB_NAME;
    private static final String EXTERNAL_DB_NAME = "/sdcard/tft/" + DB_NAME;

    public static final String DATABASE_NAME = INTERNAL_DB_NAME;

    @Inject
    public DhanukaDb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(PendingIssueTable.getPendingIssueCreateQuery());
        db.execSQL(BrandAdditionTable.getBrandAddditionCreateQuery());
        db.execSQL(CustomerOutstandingTable.getCustomerOutstandingCreateQuery());
        db.execSQL(PaymentCommitmentTable.getCommitmentCreateQuery());
        db.execSQL(PastTransactionTable.getPastTransactionCreateQuery());
        db.execSQL(PendingOrdersDoa.getPendingOrdersCreateQuery());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


}
