package com.example.adrian.appe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class FormularioGeneral2 extends AppCompatActivity {

    Button btnRegresar;
    LinearLayout lytSeccionLugarActividades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_general2);

        Instanciar();

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormularioGeneral2.this,FormularioGeneral.class);
                startActivity(intent);
            }
        });

        //lytSeccionLugarActividades.removeAllViewsInLayout(); //Elimina el contenido de los layouts no deseados
        //Si lo ponemos dentro de un if con condición la actividad seleccionada en el spiner podríamos usar solo una vista.


    }

    private void Instanciar() {

        btnRegresar = (Button) findViewById(R.id.btn_Regresar);
        lytSeccionLugarActividades=(LinearLayout) findViewById(R.id.Seccion_LugarActividades);

    }

}
