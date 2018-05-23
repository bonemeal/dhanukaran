package com.dhanuka.customer.dhanuka.db.table;

public class CustomerOutstandingTable {
    public static final String TABLE_NAME = "CustomerOutstanding";

    public static final String ID = "id";
    public static final String CREATED_ON = "CreatedOn";
    public static final String CUSTOMER_CODE = "CustomerCode";
    public static final String OUTSTANDING = "Outstanding";

    public static String getCustomerOutstandingCreateQuery() {

        StringBuilder query = new StringBuilder("CREATE TABLE ");
        query.append(TABLE_NAME);
        query.append(" ( ");
        query.append(ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ");
        query.append(CREATED_ON + " TEXT, ");
        query.append(CUSTOMER_CODE + " TEXT, ");
        query.append(OUTSTANDING + " TEXT");

        query.append(" )");
        return query.toString();
    }

}
