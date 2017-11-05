package com.example.adrian.appe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Adrian on 04/11/2017.
 */

public class AuxSQLFormGen extends SQLiteOpenHelper{

        String sqlTabla = "CREATE TABLE FormGen1(CURP INTEGER PRIMARY KEY, APaterno TEXT, AMaterno TEXT, Nombre TEXT, Edad INTEGER, " +
                "Ocupacion TEXT, Sexo TEXT, Nacionalidad TEXT, Identificacion TEXT, Calle TEXT, NumExterior INTEGER, NumInterior INTEGER," +
                "Colonia TEXT, CP INTEGER, Delegacion TEXT, Estado TEXT, Domicilio TEXT, Telefono INTEGER, Celular INTEGER, Correo TEXT" +
                "RefNombre TEXT, RefTelefono INTEGER, RefCorreo TEXT, Actividad TEXT)";  //Identificacion y Domicilio posteriormente se cambian por BLOB

        public AuxSQLFormGen(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(sqlTabla);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS FormGen1");
            db.execSQL(sqlTabla);
        }

}
