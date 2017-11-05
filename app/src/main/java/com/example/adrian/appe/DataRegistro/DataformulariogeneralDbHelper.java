package com.example.adrian.appe.DataRegistro;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Adrian on 28/10/2017.
 */

public class DataformulariogeneralDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Dataformulariogeneral.db";

    public DataformulariogeneralDbHelper(Context context,Dataformulariogeneral persona){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        saveDataformulariogeneral(persona);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        //Comandos para SQLite
        sqLiteDatabase.execSQL("CREATE TABLE "+ DataformulariogeneralContract.DataformulariogeneralEntry.TABLE_NAME
            + "("
            + DataformulariogeneralContract.DataformulariogeneralEntry._ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
            + DataformulariogeneralContract.DataformulariogeneralEntry.APELLIDO_MATERNO+ " TEXT NOT NULL,"
            + DataformulariogeneralContract.DataformulariogeneralEntry.APELLIDO_PATERNO+ " TEXT NOT NULL,"
            + DataformulariogeneralContract.DataformulariogeneralEntry.NOMBRE+ " TEXT NOT NULL,"
            + "UNIQUE (" + DataformulariogeneralContract.DataformulariogeneralEntry._ID + "))");

    }

    //Agregar datos
        public long saveDataformulariogeneral(Dataformulariogeneral data){
            SQLiteDatabase sqLiteDatabase=getWritableDatabase();

        return sqLiteDatabase.insert(DataformulariogeneralContract.DataformulariogeneralEntry.TABLE_NAME,null,data.toContentValues());

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //Operaciones para actualizar base de datos
    }

}
