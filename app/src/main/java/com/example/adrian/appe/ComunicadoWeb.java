package com.example.adrian.appe;

/**
 * Created by Adrian on 23/10/2017.
 */

public class ComunicadoWeb {
    private String titulo;
    private String hora;
    private String descripcion;
    private String liga;

    public ComunicadoWeb(String titulo, String hora, String descripcion, String liga){
        this.titulo=titulo;
        this.hora=hora;
        this.descripcion=descripcion;
        this.liga=liga;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getHora(){
        return hora;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public String getLiga(){
        return liga;
    }
}
