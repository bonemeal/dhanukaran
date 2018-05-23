package com.dhanuka.customer.dhanuka.db.table;

public class BrandAdditionTable {
    public static final String TABLE_NAME = "BrandAddition";

    public static final String ID = "id";
    public static final String LAST_YEAR = "LastYear";
    public static final String CUSTOMER_CODE = "CustomerCode";
    public static final String CURRENT_YEAR = "CurrentYear";

    public static String getBrandAddditionCreateQuery() {

        StringBuilder query = new StringBuilder("CREATE TABLE ");
        query.append(TABLE_NAME);
        query.append(" ( ");
        query.append(ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ");
        query.append(LAST_YEAR + " TEXT, ");
        query.append(CUSTOMER_CODE + " TEXT, ");
        query.append(CURRENT_YEAR + " TEXT");

        query.append(" )");
        return query.toString();
    }
}
