package com.dhanuka.customer.dhanuka.db.table;

public class PaymentAdherenceTable {
    public static final String TABLE_NAME = "PendingIssues";

    public static final String ID = "id";
    public static final String CUSTOMER_CODE = "CustomerCode";
    public static final String PAYCOMREC = "pymt_comm_rec";
    public static final String REC = "pymt_rec";

    public static String getPendingIssueCreateQuery() {

        StringBuilder query = new StringBuilder("CREATE TABLE ");
        query.append(TABLE_NAME);
        query.append(" ( ");
        query.append(ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ");
        query.append(CUSTOMER_CODE + " TEXT, ");
        query.append(PAYCOMREC + " TEXT, ");
        query.append(REC + " TEXT");

        query.append(" )");
        return query.toString();
    }
}
