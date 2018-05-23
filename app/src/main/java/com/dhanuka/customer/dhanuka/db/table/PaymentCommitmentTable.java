package com.dhanuka.customer.dhanuka.db.table;

public class PaymentCommitmentTable {
    public static final String TABLE_NAME = "PaymentCommitment";

    public static final String ID = "id";
    public static final String CUSTOMER_CODE = "CustomerCode";
    public static final String OUTLET_NAME = "OutletName";
    public static final String AMMOUNT = "AMMOUNT";

    public static String getCommitmentCreateQuery() {

        StringBuilder query = new StringBuilder("CREATE TABLE ");
        query.append(TABLE_NAME);
        query.append(" ( ");
        query.append(ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ");
        query.append(CUSTOMER_CODE + " TEXT, ");
        query.append(OUTLET_NAME + " TEXT, ");
        query.append(AMMOUNT + " TEXT");

        query.append(" )");
        return query.toString();
    }
}
