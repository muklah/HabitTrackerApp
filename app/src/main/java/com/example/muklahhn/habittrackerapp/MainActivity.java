package com.example.muklahhn.habittrackerapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.muklahhn.habittrackerapp.data.HabitContract;
import com.example.muklahhn.habittrackerapp.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitDbHelper habitDbHelper = new HabitDbHelper(this);

        mDb = habitDbHelper.getWritableDatabase();
    }

    private Cursor getDrugs() {
        return mDb.query(
                HabitContract.HabitEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                HabitContract.HabitEntry._ID
        );
    }

    private long addNewDrug(String name, int hour) {
        ContentValues cv = new ContentValues();
        cv.put(HabitContract.HabitEntry.COLUMN_DRUG_NAME, name);
        cv.put(HabitContract.HabitEntry.COLUMN_DRUG_HOUR, hour);
        return mDb.insert(HabitContract.HabitEntry.TABLE_NAME, null, cv);
    }

    private boolean removeDrug(long id) {
        return mDb.delete(HabitContract.HabitEntry.TABLE_NAME, HabitContract.HabitEntry._ID + "=" + id, null) > 0;
    }

}
