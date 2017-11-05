package com.example.adrian.appe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Sweb extends AppCompatActivity {

    Button btnRegresar;

    CheckBox chkProteccion;
    CheckBox chkSismologico;
    CheckBox chkMeteorologico;
    CheckBox chkCruzroja;
    CheckBox chkGfederal;
    CheckBox chkGlocal;
    CheckBox chkPfederal;
    CheckBox chkBomberos;
    CheckBox chkSedena;
    CheckBox chkSep;
    CheckBox chkUnam;
    CheckBox chkIpn;
    CheckBox chkUam;
    FormularioGeneral hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweb);

        chkProteccion=(CheckBox)findViewById(R.id.chk_Proteccion);
        chkSismologico=(CheckBox)findViewById(R.id.chk_Sismologico);
        chkMeteorologico=(CheckBox)findViewById(R.id.chk_Meteorologico);
        chkCruzroja=(CheckBox)findViewById(R.id.chk_Cruzroja);
        chkGfederal=(CheckBox)findViewById(R.id.chk_Gobiernofederal);
        chkGlocal=(CheckBox)findViewById(R.id.chk_Gobiernolocal);
        chkPfederal=(CheckBox)findViewById(R.id.chk_Policiafederal);
        chkBomberos=(CheckBox)findViewById(R.id.chk_Bomberos);
        chkSedena=(CheckBox)findViewById(R.id.chk_SEDENA);
        chkSep=(CheckBox)findViewById(R.id.chk_SEP);
        chkUnam=(CheckBox)findViewById(R.id.chk_UNAM);
        chkIpn=(CheckBox)findViewById(R.id.chk_IPN);
        chkUam=(CheckBox)findViewById(R.id.chk_UAM);

        btnRegresar=(Button)findViewById(R.id.btn_Regresar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Sweb.this,FormularioGeneral.class);
                startActivity(intent);


            }
        });

    }

    private void Unchecked(){
        chkProteccion.setChecked(false);
        chkSismologico.setChecked(false);
        chkMeteorologico.setChecked(false);
        chkCruzroja.setChecked(false);
        chkGfederal.setChecked(false);
        chkGlocal.setChecked(false);
        chkPfederal.setChecked(false);
        chkBomberos.setChecked(false);
        chkSedena.setChecked(false);
        chkSep.setChecked(false);
        chkUnam.setChecked(false);
        chkIpn.setChecked(false);
        chkUam.setChecked(false);
    }

    public void Proteccion(View CheckBox){
        Unchecked();
        chkProteccion.toggle();
    }

    public void Sismologico(View CheckBox){
        Unchecked();
        chkSismologico.toggle();
    }

    public void Meteorologico(View CheckBox){
        Unchecked();
        chkMeteorologico.toggle();
    }

    public void Cruzroja(View CheckBox){
        Unchecked();
        chkCruzroja.toggle();
    }

    public void Gfederal(View CheckBox){
        Unchecked();
        chkGfederal.toggle();
    }

    public void Glocal(View CheckBox){
        Unchecked();
        chkGlocal.toggle();
    }

    public void Pfederal(View CheckBox){
        Unchecked();
        chkPfederal.toggle();
    }

    public void Bomberos(View CheckBox){
        Unchecked();
        chkBomberos.toggle();
    }

    public void Sedena(View CheckBox){
        Unchecked();
        chkSedena.toggle();
    }

    public void Sep(View CheckBox){
        Unchecked();
        chkSep.toggle();
    }

    public void Unam(View CheckBox){
        Unchecked();
        chkUnam.toggle();
    }

    public void Ipn(View CheckBox){
        Unchecked();
        chkIpn.toggle();
    }

    public void Uam(View CheckBox){
        Unchecked();
        chkUam.toggle();
    }

}
