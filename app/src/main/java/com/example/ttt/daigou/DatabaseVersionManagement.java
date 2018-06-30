package com.example.ttt.daigou;

import android.database.sqlite.SQLiteDatabase;

/**
 * ���ݿ�汾����
 * 
 * */
public class DatabaseVersionManagement {

	/**
	 * ���ݿ�汾������1 to 2
	 * */
	public static void UpgradedVersion1To2(SQLiteDatabase db) {

		try {
			db.execSQL("alter table user rename to temp_user");

			db.execSQL("drop table if exists user");

			db.execSQL("create table if not exists user(id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(10), remark varchar(50), age varchar(10))");

			db.execSQL("insert into user select id, name, remark, 'age_lala' from temp_user");

			db.execSQL("drop table if exists temp_user");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
