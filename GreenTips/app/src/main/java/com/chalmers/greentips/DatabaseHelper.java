package com.chalmers.greentips;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "GreenTips.db";
    public static final String TABLE_NAME = "greentips_table";
    public static final String COL1 = "ID";
    public static final String COL2 = "CATEGORY";
    public static final String COL3 = "TIP";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, CATEGORY TEXT, TIP TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    /* public boolean insertData(String category, String tip){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, category);
        contentValues.put(COL3, tip);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        } else {
            return true;
        }
    } */

    public Cursor getAllData(){
        SQLiteDatabase dB = this.getWritableDatabase();
        Cursor res = dB.rawQuery("SELECT *FROM " + TABLE_NAME, null);
        return res;
    }

    public boolean updateData(String id, String category, String tip){
        SQLiteDatabase dB = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, id);
        contentValues.put(COL2, category);
        contentValues.put(COL3, tip);
        dB.update(TABLE_NAME, contentValues, "ID = ?", new String[] {id});
        return true;
    }
}
