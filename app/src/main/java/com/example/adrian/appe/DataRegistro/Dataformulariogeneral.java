package com.example.adrian.appe.DataRegistro;

import android.content.ContentValues;

/**
 * Created by Adrian on 28/10/2017.
 */

public class Dataformulariogeneral {
    private String apellidopaterno;
    private String apellidomaterno;
    private String nombre;

    public Dataformulariogeneral(String apellidomaterno,String apellidopaterno, String nombre){
        this.apellidomaterno=apellidomaterno;
        this.apellidopaterno=apellidopaterno;
        this.nombre=nombre;


    }

    public ContentValues toContentValues(){
        //Contenedor de valores
        ContentValues values=new ContentValues();

        values.put(DataformulariogeneralContract.DataformulariogeneralEntry.APELLIDO_MATERNO,apellidomaterno);
        values.put(DataformulariogeneralContract.DataformulariogeneralEntry.APELLIDO_PATERNO,apellidopaterno);
        values.put(DataformulariogeneralContract.DataformulariogeneralEntry.NOMBRE,nombre);

        return values;

    }

    public String getApellidomaterno(){
        return apellidomaterno;
    }

    public String getApellidopaterno(){
        return apellidopaterno;
    }

    public String getNombre(){
        return nombre;
    }


}
