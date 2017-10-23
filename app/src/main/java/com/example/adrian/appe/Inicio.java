package com.example.adrian.appe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {

    Button btnRegistro;
    Button btnIngresa;
    Button btnWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btnRegistro=(Button)findViewById(R.id.btn_Registro);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Inicio.this,FormularioGeneral.class);
                startActivity(intent);

            }
        });

        btnIngresa=(Button)findViewById(R.id.btn_Ingresa);
        btnIngresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Inicio.this,Ingresa.class);
                startActivity(intent);

            }
        });

        btnWeb=(Button)findViewById(R.id.btn_Web);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Inicio.this,Web.class);
                startActivity(intent);

            }
        });


    }
}
