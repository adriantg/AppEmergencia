package com.example.adrian.appe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Salbergue extends AppCompatActivity {

    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salbergue);

        btnRegresar=(Button)findViewById(R.id.btn_Regresar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Salbergue.this,FormularioGeneral.class);
                startActivity(intent);


            }
        });

    }
}
