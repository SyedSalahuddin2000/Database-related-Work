package com.example.register;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static final String database_name="Customer.db";
    public Database(@Nullable Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table user(id integer primary key autoincrement,email text,user_name text,password text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        onCreate(db);

    }
    public Boolean insert_data(String email,String user_name,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("email",email);
        c.put("user_name",user_name);
        c.put("password",password);
        long r=db.insert("user",null,c);
        if (r==-1)
        {
            return false;
        }
        else{
            return true;
        }

    }
}
