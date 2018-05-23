package com.dhanuka.customer.dhanuka.db.table;

public class PendingIssueTable {

    public static final String TABLE_NAME = "PendingIssues";

    public static final String ID = "id";
    public static final String TOTLE_ISSUES = "TotalIssues";
    public static final String CUSTOMER_CODE = "CustomerCode";
    public static final String TOTAL_RESOLVED = "TotalResolved";
    public static final String OVERDUE = "Overdue";

    public static String getPendingIssueCreateQuery() {

        StringBuilder query = new StringBuilder("CREATE TABLE ");
        query.append(TABLE_NAME);
        query.append(" ( ");
        query.append(ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ");
        query.append(TOTLE_ISSUES + " TEXT, ");
        query.append(TOTAL_RESOLVED + " TEXT, ");
        query.append(CUSTOMER_CODE + " TEXT, ");
        query.append(OVERDUE + " TEXT");

        query.append(" )");
        return query.toString();
    }

}

