package com.example.adrian.appe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class FormularioGeneral extends AppCompatActivity {

    Button btnIngresa;
    Button btnVerificado;

    Button btnSweb;
    Button btnSbrigadista;
    Button btnStransporte;
    Button btnSparamedico;
    Button btnSdesastre;
    Button btnSacopio;
    Button btnSalbergue;

    CheckBox chkFemenino;
    CheckBox chkMasculino;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_general);

        chkFemenino=(CheckBox) findViewById(R.id.chk_Femenino);
        chkMasculino=(CheckBox)findViewById(R.id.chk_Masculino);
        chkFemenino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chkFemenino.toggle();
                if(chkMasculino.isChecked()){
                    chkMasculino.toggle();
                }

            }
        });
        chkMasculino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chkMasculino.toggle();
                if(chkFemenino.isChecked()){
                    chkFemenino.toggle();
                }

            }
        });

        btnIngresa=(Button)findViewById(R.id.btn_Ingresa);
        btnIngresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(FormularioGeneral.this,Ingresa.class);
                startActivity(intent);

            }
        });

        btnVerificado=(Button)findViewById(R.id.btn_Verificado);
        btnVerificado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(FormularioGeneral.this,Inicio.class);
                startActivity(intent);

            }
        });

        btnSweb=(Button)findViewById(R.id.chk_Sweb);
        btnSweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormularioGeneral.this,Sweb.class);
                startActivity(intent);
            }
        });

        btnSbrigadista=(Button)findViewById(R.id.chk_Sbrigada);
        btnSbrigadista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormularioGeneral.this,Sbrigadista.class);
                startActivity(intent);
            }
        });

        btnStransporte=(Button)findViewById(R.id.chk_STransporte);
        btnStransporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormularioGeneral.this,Stransporte.class);
                startActivity(intent);
            }
        });

        btnSparamedico=(Button)findViewById(R.id.chk_SParamedico);
        btnSparamedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormularioGeneral.this,Sparamedico.class);
                startActivity(intent);
            }
        });

        btnSdesastre=(Button)findViewById(R.id.chk_Szona);
        btnSdesastre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormularioGeneral.this,Sdesastre.class);
                startActivity(intent);
            }
        });

        btnSacopio=(Button)findViewById(R.id.chk_Sacopio);
        btnSacopio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormularioGeneral.this,Sacopio.class);
                startActivity(intent);
            }
        });

        btnSalbergue=(Button)findViewById(R.id.chk_Salbergue);
        btnSalbergue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormularioGeneral.this,Salbergue.class);
                startActivity(intent);
            }
        });
    }
}
