package com.dhanuka.customer.dhanuka.db.table;

public class PastTransactionTable {
    public static final String TABLE_NAME = "PastTransaction";

    public static final String ID = "id";
    public static final String CUSTOMER_CODE = "CustomerCode";
    public static final String DATE = "Date";
    public static final String DOCUMENT_TYPE = "DocumentType";
    public static final String DOCUMENT_NUMBER = "DocumentNumber";
    public static final String AMMOUNT = "Ammount";

    public static String getPastTransactionCreateQuery() {

        StringBuilder query = new StringBuilder("CREATE TABLE ");
        query.append(TABLE_NAME);
        query.append(" ( ");
        query.append(ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ");
        query.append(CUSTOMER_CODE + " TEXT, ");
        query.append(DATE + " TEXT, ");
        query.append(DOCUMENT_TYPE + " TEXT, ");
        query.append(DOCUMENT_NUMBER + " INTEGER, ");
        query.append(AMMOUNT + " INTEGER");

        query.append(" )");
        return query.toString();
    }
}
