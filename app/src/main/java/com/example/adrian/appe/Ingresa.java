package com.example.adrian.appe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Ingresa extends AppCompatActivity {

    Button btnRegistro;
    Button btnVerificado;
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresa);

        btnRegistro=(Button)findViewById(R.id.btn_Registro_Ingresa);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Ingresa.this,FormularioGeneral.class);
                startActivity(intent);

            }
        });

        btnVerificado=(Button)findViewById(R.id.btn_Verificado_Ingresa);
        btnVerificado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Ingresa.this,Inicio.class);
                startActivity(intent);

            }
        });

        btnLogin=(Button)findViewById(R.id.btn_Login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Ingresa.this,Inicio.class);
                Toast.makeText(Ingresa.this,"Bienvenido usuario",Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });

    }
}
