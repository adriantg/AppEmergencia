package com.example.adrian.appe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class FormularioGeneral extends AppCompatActivity {

    Button btnIngresa;
    Button btnVerificado;

    Spinner spinUsuarios;

    /*Button btnSweb;
    Button btnSbrigadista;
    Button btnStransporte;
    Button btnSparamedico;
    Button btnSdesastre;
    Button btnSacopio;
    Button btnSalbergue;*/

    CheckBox chkFemenino;
    CheckBox chkMasculino;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_general);

        chkFemenino = (CheckBox) findViewById(R.id.chk_Femenino);
        chkMasculino = (CheckBox) findViewById(R.id.chk_Masculino);

        btnIngresa = (Button) findViewById(R.id.btn_Ingresa);
        btnIngresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormularioGeneral.this, Ingresa.class);
                startActivity(intent);

            }
        });

        btnVerificado = (Button) findViewById(R.id.btn_Verificado);
        btnVerificado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormularioGeneral.this, Inicio.class);
                startActivity(intent);

            }
        });


        spinUsuarios =(Spinner)findViewById(R.id.spin_Usuarios);
        String[] Tipousuarios = {"Elige una opción...", "Recopilar información web", "Líder de brigadistas", "Líder de transporte",
                "Líder de paramédicos", "Verificar información en zona de desastre", "Verificar información en albergue",
                "Verificar información en centro de acopio"};
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Tipousuarios) {
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = null;

                // If this is the initial dummy entry, make it hidden
                if (position == 0) {
                    TextView tv = new TextView(getContext());
                    tv.setHeight(0);
                    tv.setVisibility(View.GONE);
                    v = tv;
                } else {
                    // Pass convertView as null to prevent reuse of special case views
                    v = super.getDropDownView(position, null, parent);
                }

                // Hide scroll bar because it appears sometimes unnecessarily, this does not prevent scrolling
                parent.setVerticalScrollBarEnabled(false);
                return v;
            }
        };

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinUsuarios.setAdapter(dataAdapter);

        spinUsuarios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        break;
                    case 1:
                        Intent intent1 = new Intent(FormularioGeneral.this, Sweb.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(FormularioGeneral.this, Sbrigadista.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(FormularioGeneral.this, Stransporte.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(FormularioGeneral.this, Sparamedico.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(FormularioGeneral.this, Sdesastre.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(FormularioGeneral.this, Salbergue.class);
                        startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(FormularioGeneral.this, Sacopio.class);
                        startActivity(intent7);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*xlwUsuarios=(ExpandableListView)findViewById(R.id.xlw_Usuarios);
        String[] Tipousuarios = {"Elige una opción...", "Recopilar información web", "Líder de brigadistas", "Líder de transporte",
                "Líder de paramédicos", "Verificar información en zona de desastre", "Verificar información en albergue",
                "Verificar información en centro de acopio"};
        xlwUsuarios.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,Tipousuarios));*/


        /*btnSweb=(Button)findViewById(R.id.btn_Sweb);
        btnSweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormularioGeneral.this,Sweb.class);
                startActivity(intent);
            }
        });

        btnSbrigadista=(Button)findViewById(R.id.btn_Sbrigada);
        btnSbrigadista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormularioGeneral.this,Sbrigadista.class);
                startActivity(intent);
            }
        });

        btnStransporte=(Button)findViewById(R.id.btn_STransporte);
        btnStransporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormularioGeneral.this,Stransporte.class);
                startActivity(intent);
            }
        });

        btnSparamedico=(Button)findViewById(R.id.btn_SParamedico);
        btnSparamedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormularioGeneral.this,Sparamedico.class);
                startActivity(intent);
            }
        });

        btnSdesastre=(Button)findViewById(R.id.btn_Szona);
        btnSdesastre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormularioGeneral.this,Sdesastre.class);
                startActivity(intent);
            }
        });

        btnSacopio=(Button)findViewById(R.id.btn_Sacopio);
        btnSacopio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormularioGeneral.this,Sacopio.class);
                startActivity(intent);
            }
        });

        btnSalbergue=(Button)findViewById(R.id.btn_Salbergue);
        btnSalbergue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormularioGeneral.this,Salbergue.class);
                startActivity(intent);
            }
        });
    }

    */
    }

    public void Femenino(View Checkbox){
        chkMasculino.setChecked(false);
        chkFemenino.setChecked(true);
    }

    public void Masculino(View Checkbox){
        chkMasculino.setChecked(true);
        chkFemenino.setChecked(false);
    }

}

