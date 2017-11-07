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

    //COMPLETADO sección de botónes
    Button btnRegresar;
    Button btnEnviarRegistro;
    Button btnIngresa;

    //COMPLETADO sección de Layout
    LinearLayout lytSeccionWeb;
    LinearLayout lytSeccionLider;
    LinearLayout lytSeccionCertificados;
    LinearLayout lytSeccionTransportes;
    LinearLayout lytSeccionActividadesBrigada;
    LinearLayout lytSeccionLugarActividades;
    LinearLayout lytSeccionAgregarLugar;
    LinearLayout lytSeccionAgregarAlbergue;
    LinearLayout lytSeccionEquipoDisponible;

    //Seccción TEXVIEW
    TextView txtTitulo;
    TextView txtDescripcion;

    // COMPLETADO Sección de Checkbox
    CheckBox chkFacebook;
    CheckBox chkTwitter;
    CheckBox chkInstagram;
    CheckBox chkSnapchat;
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
    CheckBox chkEscombros;
    CheckBox chkAcordonar;
    CheckBox chkRevisionEstructuras;
    CheckBox chkRedElectrica;
    CheckBox chkCarpinteria;
    CheckBox chkSustanciasQuimicas;
    CheckBox chkConstruccion;
    CheckBox chkPrimerosAuxilios;
    CheckBox chkZona1Lider; //modificar por menús desplegables
    CheckBox chkZona2Lider;//modificar por menús desplegables
    CheckBox chkZona3Lider;//modificar por menús desplegables
    CheckBox chkZona1;//modificar por menús desplegables
    CheckBox chkZona2;//modificar por menús desplegables
    CheckBox chkZona3;//modificar por menús desplegables
    CheckBox chkLugar1;//modificar por menús desplegables
    CheckBox chkLugar2;//modificar por menús desplegables
    CheckBox chkLugar3;//modificar por menús desplegables
    CheckBox chkAgregarLugar; //modificar por submenú
    CheckBox chkMixto;
    CheckBox chkHombre;
    CheckBox chkMujer;
    CheckBox chkNinos;
    CheckBox chkMascotas;
    CheckBox chkBotas;
    CheckBox chkChaleco;
    CheckBox chkCasco;
    CheckBox chkGuantes;
    CheckBox chkCubrebocas;
    CheckBox chkLentes;
    CheckBox chkLunes;
    CheckBox chkMartes;
    CheckBox chkMiercoles;
    CheckBox chkJueves;
    CheckBox chkViernes;
    CheckBox chkSabado;
    CheckBox chkDomingo;
    CheckBox chk0206;
    CheckBox chk0610;
    CheckBox chk1014;
    CheckBox chk1418;
    CheckBox chk1822;
    CheckBox chk2202;

    //Seccción EDITTEXT
    EditText txtExperiencia;  //VERIFICAR ID CON CHK
    EditText txtCertificados;
    EditText txtFotoCertificado; //Cambiar por un archivo de imagen
    EditText txtAutomovil;
    EditText txtMotocicleta;
    EditText txtBicicleta;
    EditText txtCamion;
    EditText txtCamioneta;
    EditText txtVan;
    EditText txtOtros;
    EditText txtNombreMiembro;
    EditText txtFotoActividad; //Cambiar por un archivo de imagen
    EditText txtDireccionNuevoLugar;
    EditText txtDescripcionNuevoLugar;
    EditText txtCapacidadAlbergue; //VERIFICAR ID CON CHK
    






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


        btnEnviarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormularioGeneral2.this,Inicio.class);
                Toast.makeText(FormularioGeneral2.this,"Datos guardados",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });



    }

    private void Instanciar() {

        btnRegresar = (Button) findViewById(R.id.btn_Regresar);
        btnEnviarRegistro=(Button)findViewById(R.id.btn_Enviar_Registro);
        btnIngresa=(Button)findViewById(R.id.btn_IngresarMiembro);


        lytSeccionWeb=(LinearLayout)findViewById(R.id.Seccion_Web);

        lytSeccionLider=(LinearLayout)findViewById(R.id.Seccion_Lider);
        lytSeccionCertificados=(LinearLayout)findViewById(R.id.Seccion_Certificados);
        lytSeccionTransportes=(LinearLayout)findViewById(R.id.Seccion_Transportes);
        lytSeccionActividadesBrigada=(LinearLayout)findViewById(R.id.Seccion_ActividadesBrigada);

        lytSeccionLugarActividades=(LinearLayout) findViewById(R.id.Seccion_LugarActividades);
        lytSeccionAgregarLugar=(LinearLayout)findViewById(R.id.Seccion_AgregarLugar);
        lytSeccionAgregarAlbergue=(LinearLayout)findViewById(R.id.Seccion_AgregarAlbergue);
        lytSeccionEquipoDisponible=(LinearLayout)findViewById(R.id.Seccion_EquipoDisponible);

        //Sección de Texview
        txtTitulo=(TextView)findViewById(R.id.txt_TituloActividad);
        txtDescripcion=(TextView)findViewById(R.id.txt_DescripcionActividad);

        // COMPLETADO Sección de checkbox
        chkFacebook=(CheckBox)findViewById(R.id.chk_Facebook);
        chkTwitter=(CheckBox)findViewById(R.id.chk_Twitter);
        chkInstagram=(CheckBox)findViewById(R.id.chk_Instagram);
        chkSnapchat=(CheckBox)findViewById(R.id.chk_Snapchat);
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
        chkEscombros=(CheckBox)findViewById(R.id.chk_Recoger_escombros);
        chkAcordonar=(CheckBox)findViewById(R.id.chk_Acordonar_area);
        chkRevisionEstructuras=(CheckBox)findViewById(R.id.chk_Revision_estructuras);
        chkRedElectrica=(CheckBox)findViewById(R.id.chk_Red_electrica);
        chkCarpinteria=(CheckBox)findViewById(R.id.chk_Carpinteria);
        chkSustanciasQuimicas=(CheckBox)findViewById(R.id.chk_Sustancias_quimicas);
        chkConstruccion=(CheckBox)findViewById(R.id.chk_Construccion);
        chkPrimerosAuxilios=(CheckBox)findViewById(R.id.chk_Primeros_auxilios);
        chkZona1Lider=(CheckBox)findViewById(R.id.chk_Zona1Lider);
        chkZona2Lider=(CheckBox)findViewById(R.id.chk_Zona2Lider);
        chkZona3Lider=(CheckBox)findViewById(R.id.chk_Zona3Lider);
        chkZona1=(CheckBox)findViewById(R.id.chk_Zona1); //modificar para solo poder elegir una
        chkZona2=(CheckBox)findViewById(R.id.chk_Zona2);//modificar para solo poder elegir una
        chkZona3=(CheckBox)findViewById(R.id.chk_Zona3);//modificar para solo poder elegir una
        chkLugar1=(CheckBox)findViewById(R.id.chk_Lugar1);
        chkLugar2=(CheckBox)findViewById(R.id.chk_Lugar2);
        chkLugar3=(CheckBox)findViewById(R.id.chk_Lugar3);
        chkAgregarLugar=(CheckBox)findViewById(R.id.chk_Agregar_Lugar);
        chkMixto=(CheckBox)findViewById(R.id.chk_ResidentesMixtoAlbergue);
        chkHombre=(CheckBox)findViewById(R.id.chk_ResidentesHombresAlbergue);
        chkMujer=(CheckBox)findViewById(R.id.chk_ResidentesMujeresAlbergue);
        chkNinos=(CheckBox)findViewById(R.id.chk_ResidentesNinosAlbergue);
        chkMascotas=(CheckBox)findViewById(R.id.chk_ResidentesMascotasAlbergue);
        chkBotas=(CheckBox)findViewById(R.id.chk_Botas);
        chkChaleco=(CheckBox)findViewById(R.id.chk_Chaleco);
        chkCasco=(CheckBox)findViewById(R.id.chk_Casco);
        chkGuantes=(CheckBox)findViewById(R.id.chk_Guantes);
        chkCubrebocas=(CheckBox)findViewById(R.id.chk_Cubrebocas);
        chkLentes=(CheckBox)findViewById(R.id.chk_Lentes);
        chkLunes=(CheckBox)findViewById(R.id.chk_Lunes);
        chkMartes=(CheckBox)findViewById(R.id.chk_Martes);
        chkMiercoles=(CheckBox)findViewById(R.id.chk_Miercoles);
        chkJueves=(CheckBox)findViewById(R.id.chk_Jueves);
        chkViernes=(CheckBox)findViewById(R.id.chk_Viernes);
        chkSabado=(CheckBox)findViewById(R.id.chk_Sabado);
        chkDomingo=(CheckBox)findViewById(R.id.chk_Domingo);
        chk0206=(CheckBox)findViewById(R.id.chk_0206);
        chk0610=(CheckBox)findViewById(R.id.chk_0610);
        chk1014=(CheckBox)findViewById(R.id.chk_1014);
        chk1418=(CheckBox)findViewById(R.id.chk_1418);
        chk1822=(CheckBox)findViewById(R.id.chk_1822);
        chk2202=(CheckBox)findViewById(R.id.chk_2202);



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
//¿QUÉ INSTIRUCIÓN TE GUSTARÍA CUBRIR?
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
    //¿?


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
