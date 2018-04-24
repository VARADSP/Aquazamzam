package com.example.dell_lapy.aquazamzam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DELL_LAPY on 4/22/2018.
 */

public class database extends SQLiteOpenHelper {
    public static final String DATABASE_Name="Book.db";
    public static final String TABLE_NAME="BookingSystem";
    public static final String COL_1="Name";
    public static final String COL_2="Mobile";
    public static final String COL_3="Address";
    public static final String COL_4="Date";


    public database(Context context) {
        super(context, DATABASE_Name,null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" (Name TEXT,Mobile TEXT,Address TEXT,Date TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
    public boolean insertdata(String Name, String Mobile, String Address, String Date)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,Name);
        contentValues.put(COL_2,Mobile);
        contentValues.put(COL_3,Address);
        contentValues.put(COL_4,Date);


        long result= db.insert(TABLE_NAME,null,contentValues);//this method will return rows affected
        //if no rows affected it will return -1
        if (result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getAllData()//cursor class provied random read write
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }


}






