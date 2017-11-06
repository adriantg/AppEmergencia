package com.example.adrian.appe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FormularioGeneral2 extends AppCompatActivity {

    int ID;
    String Actividad;

    Button btnRegresar;
    LinearLayout lytSeccionWeb;
    LinearLayout lytSeccionLider;
    LinearLayout lytSeccionCertificados;
    LinearLayout lytSeccionTransportes;
    LinearLayout lytSeccionActividadesBrigada;
    LinearLayout lytSeccionLugarActividades;
    LinearLayout lytSeccionAgregarLugar;
    LinearLayout lytSeccionAgregarAlbergue;
    LinearLayout lytSeccionEquipoDisponible;

    TextView txtTitulo;
    TextView txtDescripcion;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_general2);

        Instanciar();

        //Recibiendo extras
        Intent siguiente= getIntent();
        ID= siguiente.getIntExtra("ID", 0);
        Actividad=siguiente.getStringExtra("Actividad");
        Toast.makeText(this,""+Actividad,Toast.LENGTH_SHORT).show();

        //Control de lo que se despliega y lo que no
        CargarViews();



        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormularioGeneral2.this,FormularioGeneral.class);
                startActivity(intent);
            }
        });

        //lytSeccionLugarActividades.removeAllViewsInLayout(); //Elimina el contenido de los layouts no deseados
        //lytSeccionAgregarLugar.removeAllViewsInLayout();
        //Si lo ponemos dentro de un if con condición la actividad seleccionada en el spiner podríamos usar solo una vista.


    }

    private void Instanciar() {

        btnRegresar = (Button) findViewById(R.id.btn_Regresar);


        lytSeccionWeb=(LinearLayout)findViewById(R.id.Seccion_Web);

        lytSeccionLider=(LinearLayout)findViewById(R.id.Seccion_Lider);
        lytSeccionCertificados=(LinearLayout)findViewById(R.id.Seccion_Certificados);
        lytSeccionTransportes=(LinearLayout)findViewById(R.id.Seccion_Transportes);
        lytSeccionActividadesBrigada=(LinearLayout)findViewById(R.id.Seccion_ActividadesBrigada);

        lytSeccionLugarActividades=(LinearLayout) findViewById(R.id.Seccion_LugarActividades);
        lytSeccionAgregarLugar=(LinearLayout)findViewById(R.id.Seccion_AgregarLugar);
        lytSeccionAgregarAlbergue=(LinearLayout)findViewById(R.id.Seccion_AgregarAlbergue);
        lytSeccionEquipoDisponible=(LinearLayout)findViewById(R.id.Seccion_EquipoDisponible);

        txtTitulo=(TextView)findViewById(R.id.txt_TituloActividad);
        txtDescripcion=(TextView)findViewById(R.id.txt_DescripcionActividad);


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

    }

    private void CargarViews(){

        if(Actividad.equals("Usuario Web")){
            txtTitulo.setText("Usuario web");
            txtDescripcion.setText("\nEste tipo de usuario es el encargado de publicar en la aplicación comunicados oficiales. Tiene la obligación de estar al pendiente de las páginas oficiales de una institución pública y recopilar los avisos, los comunicados e información relevante publicada en ellas.\n");
            lytSeccionLider.removeAllViewsInLayout();
            lytSeccionLugarActividades.removeAllViewsInLayout();

        }
        else if(Actividad.equals("Líder brigadista")){
            txtTitulo.setText("Líder de brigada");
            txtDescripcion.setText("\nEste tipo de usuario tiene organizado un grupo de voluntarios con conocimientos adecuados capaces de ejercer como brigadistas. Tiene la información de otros voluntarios y es capaz de organizarlos para ayudar donde se necesite. Es capaz de compartir sus conocimientos a otras personas, por lo que puede organizar grupos de capacitación para sumarse a su equipo de trabajo. En la aplicación puede solicitar voluntarios para su grupo, convocar a cursos de capacitación o ponerse a disposición de otros usuarios para ayudar.\n");
            lytSeccionWeb.removeAllViewsInLayout();
            lytSeccionTransportes.removeAllViewsInLayout();
            lytSeccionLugarActividades.removeAllViewsInLayout();

        }
        else if(Actividad.equals("Líder transporte")){
            txtTitulo.setText("Líder de transportistas");
            txtDescripcion.setText("\nOrganiza a aquellas personas que poseen al menos una forma de movilizar personas, víveres, herramienta o material especializado a las zonas en las que se necesiten. En la aplicación puede solicitar voluntarios para su grupo, convocar a cursos de capacitación o ponerse a disposición de otros usuarios para ayudar.\n");
            lytSeccionWeb.removeAllViewsInLayout();
            lytSeccionActividadesBrigada.removeAllViewsInLayout();
            lytSeccionCertificados.removeAllViewsInLayout();
            lytSeccionLugarActividades.removeAllViewsInLayout();

        }
        else if(Actividad.equals("Líder paramédicos")){
            txtTitulo.setText("Líder de paramédicos");
            txtDescripcion.setText("\nEste tipo de usuario tiene organizado un grupo de voluntarios con conocimientos adecuados capaces de ejercer como paramédicos. Tiene la información de otros voluntarios y es capaz de organizarlos para ayudar donde se necesite. Es capaz de compartir sus conocimientos a otras personas, por lo que puede organizar grupos de capacitación para sumarse a su equipo de trabajo. En la aplicación puede solicitar voluntarios para su grupo, convocar a cursos de capacitación o ponerse a disposición de otros usuarios para ayudar donde se necesite.\n");
            lytSeccionWeb.removeAllViewsInLayout();
            lytSeccionTransportes.removeAllViewsInLayout();
            lytSeccionActividadesBrigada.removeAllViewsInLayout();
            lytSeccionLugarActividades.removeAllViewsInLayout();
        }
        else if(Actividad.equals("Información desastre")){
            txtTitulo.setText("Voluntatrio en zona de desastre");
            txtDescripcion.setText("\nEste tipo de usuario es el encargado de estar presente en una zona de afectación, por ejemplo: zona de derrumbe o inundación. Tiene la tarea de reportar las necesidades del lugar en tiempo real, tanto de bienes materiales como de recursos humanos. Debe reportar sucesos relevantes, como identificación de las personas afectadas y el estado de las mismas.\n");
            lytSeccionWeb.removeAllViewsInLayout();
            lytSeccionLider.removeAllViewsInLayout();
            lytSeccionAgregarAlbergue.removeAllViewsInLayout();


        }
        else if(Actividad.equals("Información albergue")){
            txtTitulo.setText("Voluntatrio en albergue");
            txtDescripcion.setText("\nEste tipo de usuario es el encargado de estar presente en un albergue. Tiene la tarea de reportar las necesidades del lugar en tiempo real, tanto de bienes materiales como de recursos humanos. Debe ser un usuario que esté familiarizado con el trabajo en el albergue.\n");
            lytSeccionWeb.removeAllViewsInLayout();
            lytSeccionLider.removeAllViewsInLayout();
            lytSeccionEquipoDisponible.removeAllViewsInLayout();

        }
        else if(Actividad.equals("Información acopio")){
            txtTitulo.setText("Voluntatrio en centro de acopio");
            txtDescripcion.setText("\nEste tipo de usuario es el encargado de estar presente en un centro de acopio. Tiene la tarea de reportar las necesidades del lugar en tiempo real, tanto de bienes materiales como de recursos humanos. Debe ser un usuario que esté familiarizado con el trabajo en el centro de acopio.\n");
            lytSeccionWeb.removeAllViewsInLayout();
            lytSeccionLider.removeAllViewsInLayout();
            lytSeccionAgregarAlbergue.removeAllViewsInLayout();
            lytSeccionEquipoDisponible.removeAllViewsInLayout();
        }
        else{
            Intent regresar=new Intent(FormularioGeneral2.this,FormularioGeneral.class);
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
            startActivity(regresar);
        }
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
