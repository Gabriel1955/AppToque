package com.example.gabrielpaulino.appbebe;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.BitmapFactory;

import com.example.gabrielpaulino.appbebe.TiposDesafios.DesafiosAnimais;

/**
 * Created by GabrielPaulino on 24/11/2016.
 */

public class Database extends SQLiteOpenHelper {
    private static final String DataBase = "bancodedados";
    private static final  int Version = 1;
    public Database(Context context) {
        super(context, DataBase, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS user (name TEXT);");
      //  db.execSQL("CREATE TABLE IF NOT EXISTS tiposdesafios (name TEXT, currentquestion INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public String getNameUser(){
        String name= null;
        Cursor cursor;
        SQLiteDatabase db =this.getReadableDatabase();
        cursor = db.query("user",new String[]{"name"},null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            name = cursor.getString(cursor.getColumnIndex("name"));
        }
        db.close();
        return name;
    }
    public void setNameUser(String nameUser){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE user SET name = '"+nameUser+"' ");
        db.close();
    }
    public void setCurrentQuestion(String tipoDesafio){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE tiposdesafios SET currentquestion = currentquestion +1 WHERE name = '"+tipoDesafio+"'" );
        db.close();
    }
    public int getCurrentQuestion(String tipoDesafio){
        int id = -1;
        Cursor cursor;
        SQLiteDatabase db =this.getReadableDatabase();
        cursor = db.query("tiposdesafios",new String[]{"currentquestion"},"name=?",new String[]{tipoDesafio},null,null,null,null);
        if(cursor.moveToFirst()){
            id = cursor.getInt(cursor.getColumnIndex("currentquestion"));
        }
        return id;
    }
    public void ZeroCurrentQuestion(String tipoDesafio){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE tiposdesafios SET currentquestion = 0 WHERE name = '"+tipoDesafio+"'" );
        db.close();
    }

}
