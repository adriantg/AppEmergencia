package com.example.adrian.appe.DataRegistro;

import android.provider.BaseColumns;

/**
 * Created by Adrian on 28/10/2017.
 */

public class DataformulariogeneralContract {

    public static abstract class DataformulariogeneralEntry implements BaseColumns{
        //Creando títulos de las columnas
        public static final String TABLE_NAME="Solicitudes de registro";

        public static final String APELLIDO_MATERNO="Apelllido materno";
        public static final String APELLIDO_PATERNO="Apellido paterno";
        public static final String NOMBRE="Nombre";
    }


}
