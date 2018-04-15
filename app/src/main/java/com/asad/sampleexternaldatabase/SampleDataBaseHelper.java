package com.asad.sampleexternaldatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SampleDataBaseHelper extends SQLiteAssetHelper {

    private static SampleDataBaseHelper sInstance;
    private AtomicInteger mOpenContainer = new AtomicInteger();
    private SQLiteDatabase mDatabase;

    private static final String DATABASE_NAME = "my_database.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_CONTACTS = "contacts";

    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_FAMILY = "family";
    public static final String KEY_PHONE = "phone";

    public SampleDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized SampleDataBaseHelper getsInstance(Context context) {
        if (sInstance == null) {
            sInstance = new SampleDataBaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    public synchronized SQLiteDatabase openDataBase() {
        if (mOpenContainer.incrementAndGet() == 1) {
            mDatabase = sInstance.getWritableDatabase();
        }
        return mDatabase;
    }

    public synchronized void closeDataBase() {
        if (mOpenContainer.decrementAndGet() == 0) {
            mDatabase.close();
            mDatabase = null;
        }
    }

    public List<Contact> getContactList() {
        List<Contact> contactList = new ArrayList<>();
        SQLiteDatabase db = openDataBase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CONTACTS, null);
        if (cursor.moveToFirst()) {
            do {
                Contact currentContact = new Contact(
                        cursor.getInt(cursor.getColumnIndexOrThrow(KEY_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(KEY_NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(KEY_FAMILY)),
                        cursor.getString(cursor.getColumnIndexOrThrow(KEY_PHONE))
                );
                contactList.add(currentContact);
            } while (cursor.moveToNext());

        }
        cursor.close();
        closeDataBase();
        return contactList;
    }

}
