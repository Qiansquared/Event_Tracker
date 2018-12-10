package com.example.pei.map;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class myDbAdapter {

    myDbHelper myhelper;
   public  myDbAdapter(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    public long insertData(String name, String host, String description, int location, int date, int starttime, int endtime)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.HOST, host);
        contentValues.put(myDbHelper.DESCRIPTION, description);
        contentValues.put(myDbHelper.LOCATION, location);
        contentValues.put(myDbHelper.DATE, date);
        contentValues.put(myDbHelper.STARTTIME, starttime);
        contentValues.put(myDbHelper.ENDTIME, endtime);

        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }

    public String getData()
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID,myDbHelper.NAME,myDbHelper.HOST};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String name =cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.HOST));
            buffer.append(cid+ "   " + name + "   " + password +" \n");
        }
        return buffer.toString();
    }

    public String[] getLocationNamesData(int location, int date, int hour)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.NAME};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,myDbHelper.LOCATION +" = " + location + myDbHelper.DATE + " = " + date + myDbHelper.ENDTIME + " > " + hour,null,null,null,myDbHelper.STARTTIME + " ASC ");
        //StringBuffer buffer= new StringBuffer();
        int index = 0;
        String[] nameArray = new String[100];

        while (cursor.moveToNext())
        {
            //int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String name =cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            //String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            nameArray[index] = name;
            index ++;
        }
        return nameArray;
    }

    public String[] getLocationHostData(int location, int date, int hour)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.HOST};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,myDbHelper.LOCATION + " = " + location + myDbHelper.DATE + " = " + date + myDbHelper.ENDTIME + " > " + hour,null,null,null,myDbHelper.STARTTIME +" ASC ");
        //StringBuffer buffer= new StringBuffer();
        int index = 0;
        String[] nameArray = new String[100];

        while (cursor.moveToNext())
        {
            //int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String name =cursor.getString(cursor.getColumnIndex(myDbHelper.HOST));
            //String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            nameArray[index] = name;
            index ++;
        }
        return nameArray;
    }

    public String[] getLocationIDData(int location, int date, int hour)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,myDbHelper.LOCATION + " = " + location + myDbHelper.DATE + " = " + date + myDbHelper.ENDTIME + " > " + hour,null,null,null,myDbHelper.STARTTIME + " ASC ");
        //StringBuffer buffer= new StringBuffer();
        int index = 0;
        String[] nameArray = new String[100];

        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            //String name =cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            //String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            nameArray[index] = Integer.toString(cid);
            index ++;
        }
        return nameArray;
    }

    public String[] getLocationStartData(int location, int date, int hour)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.STARTTIME};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,myDbHelper.LOCATION + " = " + location + myDbHelper.DATE + " = " + date + myDbHelper.ENDTIME + " > " + hour,null,null,null,myDbHelper.STARTTIME + " ASC ");
        //StringBuffer buffer= new StringBuffer();
        int index = 0;
        String[] nameArray = new String[100];

        while (cursor.moveToNext())
        {
            //int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            int name =cursor.getInt(cursor.getColumnIndex(myDbHelper.STARTTIME));
            //String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            nameArray[index] = Integer.toString(name);
            index ++;
        }
        return nameArray;
    }

    public String[] getLocationEndData(int location, int date, int hour)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.ENDTIME};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,myDbHelper.LOCATION + " = " + location + myDbHelper.DATE + " = " + date + myDbHelper.ENDTIME + " > " + hour,null,null,null,myDbHelper.STARTTIME + " ASC ");
        //StringBuffer buffer= new StringBuffer();
        int index = 0;
        String[] nameArray = new String[100];

        while (cursor.moveToNext())
        {
            //int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            int name =cursor.getInt(cursor.getColumnIndex(myDbHelper.ENDTIME));
            //String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            nameArray[index] = Integer.toString(name);
            index ++;
        }
        return nameArray;
    }

    public String[] getAllNamesData(int date, int hour)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.NAME};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns, myDbHelper.DATE + " = " + date + myDbHelper.ENDTIME + " > " + hour,null,null,null,myDbHelper.DATE + "ASC"+ myDbHelper.STARTTIME + " ASC ");
        //StringBuffer buffer= new StringBuffer();
        int index = 0;
        String[] nameArray = new String[100];

        while (cursor.moveToNext())
        {
            //int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String name =cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            //String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            nameArray[index] = name;
            index ++;
        }
        return nameArray;
    }

    public String[] getAllIDData(int date, int hour)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns, myDbHelper.DATE + " = " + date + myDbHelper.ENDTIME + " > " + hour,null,null,null,myDbHelper.DATE +" ASC,"+ myDbHelper.STARTTIME +" ASC ");
        //StringBuffer buffer= new StringBuffer();
        int index = 0;
        String[] nameArray = new String[100];

        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            //String name =cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            //String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            nameArray[index] = Integer.toString(cid);
            index ++;
        }
        return nameArray;
    }

    public String[] getAllStartData(int date, int hour)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.STARTTIME};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns, myDbHelper.DATE + "=" + date + myDbHelper.ENDTIME + ">" + hour,null,null,null,myDbHelper.DATE+"ASC,"+ myDbHelper.STARTTIME+"ASC");
        //StringBuffer buffer= new StringBuffer();
        int index = 0;
        String[] nameArray = new String[100];

        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.STARTTIME));
            //String name =cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            //String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            nameArray[index] = Integer.toString(cid);
            index ++;
        }
        return nameArray;
    }

    public String[] getAllEndData(int date, int hour)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.ENDTIME};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns, myDbHelper.DATE + "=" + date + myDbHelper.ENDTIME + ">" + hour,null,null,null,myDbHelper.DATE+"ASC,"+ myDbHelper.STARTTIME+"ASC");
        //StringBuffer buffer= new StringBuffer();
        int index = 0;
        String[] nameArray = new String[100];

        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.ENDTIME));
            //String name =cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            //String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            nameArray[index] = Integer.toString(cid);
            index ++;
        }
        return nameArray;
    }

    public String[] getAllDateData(int date, int hour)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.DATE};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns, myDbHelper.DATE + "=" + date + myDbHelper.ENDTIME + ">" + hour,null,null,null,myDbHelper.DATE+"ASC,"+ myDbHelper.STARTTIME+"ASC");
        //StringBuffer buffer= new StringBuffer();
        int index = 0;
        String[] nameArray = new String[100];

        while (cursor.moveToNext())
        {
            //int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            int name =cursor.getInt(cursor.getColumnIndex(myDbHelper.DATE));
            //String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            nameArray[index] = Integer.toString(name);
            index ++;
        }
        return nameArray;
    }

    public String[] getAllLocationData(int date, int hour)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.LOCATION};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns, myDbHelper.DATE + "=" + date + myDbHelper.ENDTIME + ">" + hour,null,null,null,myDbHelper.DATE+"ASC,"+ myDbHelper.STARTTIME+"ASC");
        //StringBuffer buffer= new StringBuffer();
        int index = 0;
        String[] nameArray = new String[100];

        while (cursor.moveToNext())
        {
            //int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            int name =cursor.getInt(cursor.getColumnIndex(myDbHelper.LOCATION));
            //String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            nameArray[index] = Integer.toString(name);
            index ++;
        }
        return nameArray;
    }

    public String[] getDetailsData(int ID)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.NAME, myDbHelper.HOST, myDbHelper.DESCRIPTION, myDbHelper.LOCATION, myDbHelper.DATE, myDbHelper.STARTTIME, myDbHelper.ENDTIME};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns, myDbHelper.UID + "=" + ID,null,null,null,null);
        //StringBuffer buffer= new StringBuffer();
        int index = 0;
        String[] nameArray = new String[7];

        String name =cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
        nameArray[0] = name;
        String host =cursor.getString(cursor.getColumnIndex(myDbHelper.HOST));
        nameArray[1] = host;
        String descr =cursor.getString(cursor.getColumnIndex(myDbHelper.DESCRIPTION));
        nameArray[2] = descr;
        int loc =cursor.getInt(cursor.getColumnIndex(myDbHelper.LOCATION));
        nameArray[3] = Integer.toString(loc);
        int date =cursor.getInt(cursor.getColumnIndex(myDbHelper.DATE));
        nameArray[4] = Integer.toString(date);
        int start =cursor.getInt(cursor.getColumnIndex(myDbHelper.STARTTIME));
        nameArray[5] = Integer.toString(start);
        int end =cursor.getInt(cursor.getColumnIndex(myDbHelper.ENDTIME));
        nameArray[6] = Integer.toString(end);
        return nameArray;
    }

    public  int delete(String uname)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] whereArgs ={uname};

        int count =db.delete(myDbHelper.TABLE_NAME ,myDbHelper.NAME +" = ?",whereArgs);
        return  count;
    }

    public int updateName(String oldName , String newName)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME,newName);
        String[] whereArgs= {oldName};
        int count =db.update(myDbHelper.TABLE_NAME,contentValues, myDbHelper.NAME +" = ?",whereArgs );
        return count;
    }

    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "myDatabase";    // Database Name
        private static final String TABLE_NAME = "myTable";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version
        private static final String UID="_id";     // Column I (Primary Key)
        private static final String NAME = "Name";    //Column II
        private static final String HOST= "Host";    // Column III
        private static final String DESCRIPTION= "Description";    // Column III
        private static final String LOCATION= "Location";    // Column III
        private static final String DATE= "Date";    // Column III
        private static final String STARTTIME= "Start_Time";    // Column III
        private static final String ENDTIME= "End_Time";    // Column III

        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT," +NAME+ " VARCHAR(255)," + HOST+ " VARCHAR(255),"+DESCRIPTION+" VARCHAR(255), "+LOCATION +" INTEGER, " + DATE+" INTEGER, "+STARTTIME+" INTEGER, "+ENDTIME+" INTEGER);";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                com.example.pei.map.Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                com.example.pei.map.Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {

                com.example.pei.map.Message.message(context,""+e);
            }
        }
    }
}
