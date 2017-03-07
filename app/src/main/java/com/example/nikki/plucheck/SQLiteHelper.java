package com.example.nikki.plucheck;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Nikki on 28/2/17.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Fresh.db";
    private SQLiteDatabase database;
    private Context context;

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public static final String TABLE_NAME = "FRESH";
    public static final String COLUMN_BRAND = "BRAND";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_SKU = "SKU";
    public static final String COLUMN_PLU = "PLU";
    public static final String COLUMN_PRICE = "PRICE";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table" + TABLE_NAME + " ( " + "BRAND" + COLUMN_BRAND + "VARCHAR, " + COLUMN_NAME +
                "VARCHAR, " + COLUMN_SKU + "INTEGER" + COLUMN_PLU + "INTEGER" + COLUMN_PRICE + "VARCHAR");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertRecord(Fresh Product) {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_BRAND, Product.getBrand());
        contentValues.put(COLUMN_NAME, Product.getName());
        contentValues.put(COLUMN_SKU, Product.getSKU());
        contentValues.put(COLUMN_PLU, Product.getPLU());
        contentValues.put(COLUMN_PRICE, Product.getPrice());
        long id = database.insert(TABLE_NAME, null, contentValues);

        if (id != -1) {
            Product.setBrand("" + id);
            Toast.makeText(context, "New record inserted with Brand = " + id, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Error inserting new record", Toast.LENGTH_SHORT).show();
        }

        database.close();
    }


    public ArrayList<Fresh> getAllRecords() {
        database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);

        ArrayList<Fresh> products = new ArrayList<Fresh>();
        Fresh product;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                // if got mistake check this one.
                product = new Fresh();
                product.setBrand(cursor.getString(0));
                product.setName(cursor.getString(1));
                product.setSKU(cursor.getString(2));
                product.setPLU(cursor.getString(3));
                product.setPrice(cursor.getString(4));

                products.add(product);
            }
        }
        cursor.close();
        database.close();

        return products;
    }
}