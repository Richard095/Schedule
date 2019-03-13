package com.example.schedule;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SubjectDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE = "subjects.db";
    public SubjectDBHelper(Context context){
        super(context,DATABASE,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    String SUBJECT_DATABASE = "CREATE TABLE " + SubjectContract.subjectColumns.TABLE_NAME + " (" +

            SubjectContract.subjectColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            SubjectContract.subjectColumns.DAY + " INTEGER NOT NULL, " +
            SubjectContract.subjectColumns.SUBJECT_NAME + " TEXT NOT NULL, " +
            SubjectContract.subjectColumns.TEACHER + " TEXT NOT NULL, " +
            SubjectContract.subjectColumns.CLASSROOM + " TEXT NOT NULL, " +
            SubjectContract.subjectColumns.HOUR_START_CLASS + " INTEGER NOT NULL, " +
            SubjectContract.subjectColumns.HOUR_END_CLASS + " INTEGER NOT NULL, " +
            SubjectContract.subjectColumns.INDICATOR + " TEXT NOT NULL, " +
            SubjectContract.subjectColumns.KEY + " INTEGER NOT NULL " +
            ")";

            sqLiteDatabase.execSQL(SUBJECT_DATABASE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DATABASE);
        onCreate(sqLiteDatabase);
    }
}
