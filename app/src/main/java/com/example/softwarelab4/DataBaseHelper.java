package com.example.softwarelab4;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {


    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String COLUMN_CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final String COIUMN_CUSTOMER_AGE = "CUSTOMER_AGE";
    public static final String COLUMN_ACTIVE_CUSTOMER = "ACTIVE_CUSTOMER";
    public static final String CUSTOMER_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "customer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateTableStatment = "CREATE TABLE " + CUSTOMER_TABLE + " (" + CUSTOMER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COLUMN_CUSTOMER_NAME + " TEXT , " + COIUMN_CUSTOMER_AGE + " INT, " + COLUMN_ACTIVE_CUSTOMER + " BOOL)";
          db.execSQL(CreateTableStatment);
    }
/*
    public boolean addOne(customerModel cm) {
      SQLiteDatabase  db = getWritableDatabase();

      ContentValues cv = new ContentValues();

    }
    */


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne (CustomerModel cm) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CUSTOMER_NAME , cm.getName());
        cv.put(COIUMN_CUSTOMER_AGE , cm.getAge());
        cv.put(COLUMN_ACTIVE_CUSTOMER , cm.isActive());

        long insert =       db.insert(CUSTOMER_TABLE , null , cv);

        if( insert == -1) {
            return false;
        }
        else {
            return true;

        }



    }


}
