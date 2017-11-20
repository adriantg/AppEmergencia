package com.example.adrian.appe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.os.Build.ID;
import static android.os.FileObserver.CREATE;
import static java.sql.Types.INTEGER;

/**
 * Created by Adrian on 04/11/2017.
 */

public class AuxSQLFormGen extends SQLiteOpenHelper{


        String sqlTabla1 = "CREATE TABLE FormGen1 (ID TEXT PRIMARY KEY,APaterno TEXT,AMaterno TEXT,Nombre TEXT,Edad TEXT," +
                "Ocupacion TEXT,Sexo TEXT,Nacionalidad TEXT,Identificacion BLOB,Calle TEXT,NumExterior TEXT,NumInterior TEXT," +
                "Colonia TEXT,CP TEXT,Delegacion TEXT,Estado TEXT,Domicilio BLOB,Telefono TEXT,Celular TEXT,Correo TEXT," +
                "RefNombre TEXT,RefTelefono TEXT,RefCorreo TEXT,Actividad TEXT,UNIQUE (ID))";

        String sqlTabla2 = "CREATE TABLE FormGen2 (ID TEXT PRIMARY KEY,Facebook TEXT,Twitter TEXT,Instagram TEXT,Snapchat TEXT," +
                "Institucion TEXT,Escombros TEXT,Acordonar TEXT,RevisionEstructuras TEXT,RedElectrica TEXT,Carpinteria TEXT," +
                "SustanciasQuimicas TEXT,Construccion TEXT,PrimerosAuxilios TEXT,ZonaLider TEXT,Zona TEXT,Lugar TEXT,Mujer TEXT," +
                "Hombre TEXT,Ninos TEXT,Mascotas TEXT,Botas TEXT,Chaleco TEXT,Casco TEXT,Guantes TEXT,Cubrebocas TEXT,Lentes TEXT," +
                "Lunes TEXT,Martes TEXT,Miercoles TEXT,Jueves TEXT,Viernes TEXT,Sabado TEXT,Domingo TEXT,DosAmSeisAm TEXT,SeisAmDiezAm TEXT," +
                "DiezAmDosPm TEXT,DosPmSeisPm TEXT,SeisPmDiezPm TEXT,DiezPmDosAm TEXT,Experiencia TEXT,Certificados TEXT,FotoCertificado BLOB," +
                "Automovil TEXT,Motocicleta TEXT,Bicicleta TEXT,Camion TEXT,Camioneta TEXT,Van TEXT,Otros TEXT,Miembros TEXT," +
                "FotoActividadesLider BLOB,DireccionNuevoLugar TEXT,DescripcionNuevoLugar TEXT,CapacidadAlbergue TEXT,FotoNuevoLugar BLOB," +
                "DescripcionActividadesRealizadas TEXT,FotoActividades BLOB,OtroEquipo TEXT,UNIQUE (ID)";


        public AuxSQLFormGen(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
            }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(sqlTabla1);
            db.execSQL(sqlTabla2);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS FormGen1");
            db.execSQL(sqlTabla1);
            db.execSQL("DROP TABLE IF EXISTS FormGen2");
            db.execSQL(sqlTabla2);
        }

}
