package com.filmygeekstudio.mytext;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by piyush on 10/1/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "signup.db";
    private static final String TABLE_NAME = "signup";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FNAME = "fname";
    private static final String COLUMN_LNAME = "lname";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";

    private static final String COLUMN_MOBILE = "mobile";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table signup ( id integer primary key not null ," + "fname text not null , lname text not null ,uname text not null ,password text not null ,email text not null,mobile double not null );";

    public DatabaseHelper(Context context) {
        super(context , DATABASE_NAME , null ,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertContact(com.filmygeekstudio.mytext.Contact c) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from signup";

        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_FNAME,c.getFname());
        values.put(COLUMN_LNAME,c.getLname());
        values.put(COLUMN_EMAIL,c.getEmail());
        values.put(COLUMN_UNAME,c.getUname());
        values.put(COLUMN_PASSWORD,c.getPass());
        values.put(COLUMN_MOBILE,c.getMobile());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchUser(String email ) {
        db = this.getReadableDatabase();
        String query1 = "select email,password from "+ TABLE_NAME;
        Cursor cursor = db.rawQuery(query1,null);
        String a,b;
        b= "not Found";
        if(cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);

                if(a.equals(email)) {
                    b = cursor.getString(1);
                    break;
                }
            }while (cursor.moveToNext());
        }
        db.close();
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS" + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

}