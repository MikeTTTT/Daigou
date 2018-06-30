package com.example.ttt.daigou;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {
	public static final int database_version = 1;

	public DatabaseHelper(Context context) {
		super(context, "Daigou_DB", null, database_version);
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d("Database","successful create!");
		db.execSQL("create table student(_id integer primary key autoincrement, name char(10), age integer, no integer, cpp float, math float, english float)");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.d("MainActivity", "数据库升级成功！");
		System.out.println("DBHelper onUpgrade");

//		try {
//
//			for (int i = oldVersion; i < newVersion; i++) {
//				switch (i) {
//				case 1:
//					DatabaseVersionManagement.UpgradedVersion1To2(db);
//					break;
//
//				default:
//					break;
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
