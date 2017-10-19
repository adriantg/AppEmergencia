package com.example.adrian.appe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Sacopio extends AppCompatActivity {

    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sacopio);

        btnRegresar=(Button)findViewById(R.id.btn_Regresar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CheckBox casilla=(CheckBox)findViewById(R.id.chk_Sacopio);
                casilla.toggle();
                Intent intent=new Intent(Sacopio.this,FormularioGeneral.class);
                startActivity(intent);


            }
        });

    }
}
