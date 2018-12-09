package com.example.pei.map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "event.db";
    public static final String Table_NAME = "event_table";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "HOST";
    public static final String COL_4 = "DESCRIPTION";
    public static final String COL_5 = "LOCATION";
    public static final String COL_6 = "DATE";
    public static final String COL_7 = "STARTTIME";
    public static final String COL_8 = "ENDTIME";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_NAME + " ( " +
                "NAME TEXT, HOST TEXT, DESCRIPTION TEXT,LOCATION INTEGER, DATE INTEGER," +
                "STARTTIME INTEGER, ENDTIME INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String host, String description,Integer location,
                              Integer date, Integer start,Integer end){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,host);
        contentValues.put(COL_4,description);
        contentValues.put(COL_5,location);
        contentValues.put(COL_6,date);
        contentValues.put(COL_7,start);
        contentValues.put(COL_8,end);
        long result = db.insert(Table_NAME, null, contentValues);
        if (result ==-1)
            return false;
        else
            return true;
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Integer locationCode=1;

        String query ="SELECT * FROM event_table WHERE location =" + locationCode;
        Cursor res = db.rawQuery(query,null);
        return res;
    }

}