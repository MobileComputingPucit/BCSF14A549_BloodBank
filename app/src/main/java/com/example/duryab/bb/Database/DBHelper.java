package com.example.duryab.bb.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.duryab.bb.Models.UserLogin;
import com.example.duryab.bb.UserRegister;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by abc on 1/18/18.
 *
 * @package pk.edu.pucit.mobilecomputing.database.Database
 * @project Database
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "User";

    //COLUMN NAMES
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String ADDRESS = "address";
    public static final String PHONE = "phone";
    public static final String BLOOD = "bloodg";
    public static final String PASS = "password";

    //COLUMN TYPES
    public static final String TYPE_TEXT = " TEXT ";
    public static final String TYPE_INT = " INTEGER ";
    public static final String SEPERATOR = ", ";
    private static final String DATABASE_NAME = "bb.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_query = "Create table " + TABLE_NAME + " ("
                //need to make primary key NOT NULL
                // and AUTOINCREMENT instead of AUTO_INCREMENT
                + ID + TYPE_INT + " PRIMARY KEY AUTOINCREMENT NOT NULL " + SEPERATOR
                + NAME + TYPE_TEXT + SEPERATOR
                + EMAIL + TYPE_TEXT + SEPERATOR
                + PHONE + TYPE_TEXT + SEPERATOR
                + BLOOD + TYPE_TEXT + SEPERATOR
                + PASS + TYPE_TEXT + SEPERATOR
                + ADDRESS + TYPE_TEXT + ");";
        db.execSQL(create_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            String drop_query = "drop database if exists " + DATABASE_NAME;
            db.execSQL(drop_query);
            onCreate(db);
        }
    }

    /**
     * This function inserts data into database
     *
     * @param name    takes a string user name
     * @param email   takes a string type email
     * @param address takes a string type address
     * @return true when data inserted false when failed
     */
    public long insert(String name,String email, String add,String blood, String phone, String pass)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(PHONE, phone);
        values.put(BLOOD, blood);
        values.put(EMAIL, email);
        values.put(ADDRESS, add);
        values.put(PASS, pass);
        // Inserting Row
        long i=db.insert(TABLE_NAME, null, values);
        db.close(); // Closing database connection  return i;
        return i;
    }

    public List<UserRegister> getdata(){
        // DataModel dataModel = new DataModel();
        List<UserRegister> data=new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select * from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        UserRegister dataModel = null;

            while (cursor.moveToNext()) {
            dataModel= new UserRegister();
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String phone = cursor.getString(3);
                String blood = cursor.getString(4);
                String pass = cursor.getString(5);
                String add = cursor.getString(6);

            dataModel.setName(name);
            dataModel.setPhone(phone);
            dataModel.setBlood(blood);
            dataModel.setEmail(email);
            dataModel.setAddress(add);
            dataModel.setPassword(pass);

            //stringBuffer.append(dataModel);
            data.add(dataModel);
        }

        return data;
    }
}
