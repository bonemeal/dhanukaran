package com.dhanuka.customer.dhanuka.db.table;

public class PendingOrdersTable {public static final String TABLE_NAME = "PendingOrders";

    public static final String ID = "id";
    public static final String BRAND_NAME = "BrandName";
    public static final String PC = "PC";
    public static final String CUSTOMER_CODE = "CustomerCode";
    public static final String PQ = "PQ";

    public static String getPendingOrdersCreateQuery() {

        StringBuilder query = new StringBuilder("CREATE TABLE ");
        query.append(TABLE_NAME);
        query.append(" ( ");
        query.append(ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ");
        query.append(BRAND_NAME + " TEXT, ");
        query.append(CUSTOMER_CODE + " TEXT, ");
        query.append(PC + " TEXT, ");
        query.append(PQ + " TEXT");

        query.append(" )");
        return query.toString();
    }
}
