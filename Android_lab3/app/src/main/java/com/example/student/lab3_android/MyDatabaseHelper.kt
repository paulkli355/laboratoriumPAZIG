package com.example.student.lab3_android

import android.content.ContentValues
import android.content.Context
import android.database.DatabaseErrorHandler
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by student on 2020-01-15.
 */
class MyDatabaseHelper (context: Context?)
    : SQLiteOpenHelper(context, DATABASE_NAME, null, 1){

    companion object{
        var DATABASE_NAME = "MojaBaza"
        var TABLE_NAME = "MojaTabela"
    }
    override fun onCreate(p0: SQLiteDatabase?){
        TODO("not implemented")
        p0?.execSQL("CREATE TABLE IF EXISTS $TABLE_NAME(id INTIGER PRIMAREY KEY AUTOINCREMENT," +
        "'kolumna1 TEXT, kolumna2 TEXT)")
    }

    fun insert(dystans: String, data: String){
        var db = this.writableDatabase
        var cv = ContentValues()
        cv.apply {
            put("kolumna1", dystans)
            put("kolumna2", data)
        }
        db.insert(TABLE_NAME, null, cv)

    }

    fun selectAll() : ArrayList<String> {
        var db = this.readableDatabase
        var cursor = db.rawQuery("SELECT ' FROM $TABLE_NAME", null)

        var dane = ArrayList<String>()

        cursor.moveToFirst()
        while(cursor.isAfterLast){
            dane.add("${cursor.getString(0)} ${cursor.getString(1)} ${cursor.getString(2)}")
            cursor.moveToNext()
        }
        db.close()
        return dane
    }


    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

}



