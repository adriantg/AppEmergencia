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
    EditText txtFotoActividadesLider; //Cambiar por un archivo de imagen
    EditText txtDireccionNuevoLugar;
    EditText txtDescripcionNuevoLugar;
    EditText txtCapacidadAlbergue; //VERIFICAR ID CON CHK
    EditText txtFotosNuevoLugar; //Cambiar por un archivo de imagen
    EditText txtDescripcionActividadesRealizadas;
    EditText txtFotoActividades; //Cambiar por un archivo de imagen
    EditText txtOtroEquipo;

    //Variables para guardar la información
    String Institucion;

    String Escombros="No";
    String Acordonar="No";
    String RevisionEstructuras="No";
    String RedElectrica="No";
    String Carpinteria="No";
    String SustanciasQuimicas="No";
    String Construccion="No";
    String PrimerosAuxilios="No";

    String ZonaLider;

    String Zona;
    String Lugar;
    String Mujer="No";
    String Hombre="No";
    String Ninos="No";
    String Mascotas="No";
    String Botas="No";
    String Chaleco="No";
    String Casco="No";
    String Guantes="No";
    String Cubrebocas="No";
    String Lentes="No";

    String Lunes="No";
    String Martes="No";
    String Miercoles="No";
    String Jueves="No";
    String Viernes="No";
    String Sabado="No";
    String Domingo="No";
    String DosAmSeisAm="No";
    String SeisAmDiezAm="No";
    String DiezAmDosPm="No";
    String DosPmSeisPm="No";
    String SeisPmDiezPm="No";
    String DiezPmDosAm="No";

    String Experiencia;  //VERIFICAR ID CON CHK
    String Certificados;
    String FotoCertificado; //Cambiar por un archivo de imagen
    String Automovil;
    String Motocicleta;
    String Bicicleta;
    String Camion;
    String Camioneta;
    String Van;
    String Otros;
    String NombreMiembro;
    String FotoActividadesLider; //Cambiar por un archivo de imagen
    String DireccionNuevoLugar;
    String DescripcionNuevoLugar;
    String CapacidadAlbergue; //VERIFICAR ID CON CHK
    String FotosNuevoLugar; //Cambiar por un archivo de imagen
    String DescripcionActividadesRealizadas;
    String FotoActividades; //Cambiar por un archivo de imagen
    String OtroEquipo;


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

        // COMPLETADO Sección de editText
        txtExperiencia=(EditText) findViewById(R.id.txt_Experiencia);
        txtCertificados=(EditText) findViewById(R.id.txt_Certificado);
        txtFotoCertificado=(EditText) findViewById(R.id.txt_FotoCertificado);//Cambiar por un archivo de imagen
        txtAutomovil=(EditText) findViewById(R.id.txt_Auto);
        txtMotocicleta=(EditText) findViewById(R.id.txt_Moto);
        txtBicicleta=(EditText) findViewById(R.id.txt_Bici);
        txtCamion=(EditText) findViewById(R.id.txt_Camion);
        txtCamioneta=(EditText) findViewById(R.id.txt_Camioneta);
        txtVan=(EditText) findViewById(R.id.txt_Van);
        txtOtros=(EditText) findViewById(R.id.txt_Otrobrigadista);
        txtNombreMiembro=(EditText) findViewById(R.id.txt_NombreMiembro);
        txtFotoActividadesLider=(EditText) findViewById(R.id.txt_FotoActividadesLider);//Cambiar por un archivo de imagen
        txtDireccionNuevoLugar=(EditText) findViewById(R.id.txt_DireccionNuevoLugar);
        txtDescripcionNuevoLugar=(EditText) findViewById(R.id.txt_DescripcionNuevoLugar);
        txtCapacidadAlbergue=(EditText) findViewById(R.id.txt_CapacidadAlbergue);
        txtFotosNuevoLugar=(EditText) findViewById(R.id.txt_FotosNuevoLugar);//Cambiar por un archivo de imagen
        txtDescripcionActividadesRealizadas=(EditText) findViewById(R.id.txt_DescripcionActividadesRealizadas);
        txtFotoActividades=(EditText) findViewById(R.id.txt_FotoActividades);
        txtOtroEquipo=(EditText) findViewById(R.id.txt_OtroEquipo);

    }

    //EXTRAER INFORMACIÓN
    private void ExtraerData(){
        Experiencia=txtExperiencia.getText().toString();
        Certificados=txtCertificados.getText().toString();
        FotoCertificado=txtFotoCertificado.getText().toString();
        Automovil=txtAutomovil.getText().toString();
        Motocicleta=txtMotocicleta.getText().toString();
        Bicicleta=txtBicicleta.getText().toString();
        Camion=txtCamion.getText().toString();
        Camioneta=txtCamioneta.getText().toString();
        Van=txtVan.getText().toString();
        Otros=txtOtros.getText().toString();
        NombreMiembro=txtNombreMiembro.getText().toString();
        FotoActividadesLider=txtFotoActividadesLider.getText().toString();
        DireccionNuevoLugar=txtDireccionNuevoLugar.getText().toString();
        DescripcionNuevoLugar=txtDescripcionNuevoLugar.getText().toString();
        CapacidadAlbergue=txtCapacidadAlbergue.getText().toString();
        FotosNuevoLugar=txtFotosNuevoLugar.getText().toString();
        DescripcionActividadesRealizadas=txtDescripcionActividadesRealizadas.getText().toString();
        FotoActividades=txtFotoActividades.getText().toString();
        OtroEquipo=txtOtroEquipo.getText().toString();
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


//METODOS SELECCION UNICA
    private void UncheckedInstitucion(){
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

    private void UncheckedZonaLider(){
        chkZona1Lider.setChecked(false);
        chkZona2Lider.setChecked(false);
        chkZona3Lider.setChecked(false);
    }

    private void UncheckedZona(){
        chkZona1.setChecked(false);
        chkZona2.setChecked(false);
        chkZona3.setChecked(false);
    }

    private void UncheckedLugar(){
        chkLugar1.setChecked(false);
        chkLugar2.setChecked(false);
        chkLugar3.setChecked(false);
    }


    //EXTRACCION DATOS DE LOS CHECKBOX


    //INSTITUCION
    public void Proteccion(View CheckBox){
        UncheckedInstitucion();
        chkProteccion.toggle();
        Institucion="Protección civil";
    }

    public void Sismologico(View CheckBox){
        UncheckedInstitucion();
        chkSismologico.toggle();
        Institucion="Sismológico Nacional";
    }

    public void Meteorologico(View CheckBox){
        UncheckedInstitucion();
        chkMeteorologico.toggle();
        Institucion="Meteorologico Nacional";
    }

    public void Cruzroja(View CheckBox){
        UncheckedInstitucion();
        chkCruzroja.toggle();
        Institucion="Cruz Roja";
    }

    public void Gfederal(View CheckBox){
        UncheckedInstitucion();
        chkGfederal.toggle();
        Institucion="Gobierno federal";
    }

    public void Glocal(View CheckBox){
        UncheckedInstitucion();
        chkGlocal.toggle();
        Institucion="Gobierno local";
    }

    public void Pfederal(View CheckBox){
        UncheckedInstitucion();
        chkPfederal.toggle();
        Institucion="Policía federal";
    }

    public void Bomberos(View CheckBox){
        UncheckedInstitucion();
        chkBomberos.toggle();
        Institucion="Bomberos";
    }

    public void Sedena(View CheckBox){
        UncheckedInstitucion();
        chkSedena.toggle();
        Institucion="SEDENA";
    }

    public void Sep(View CheckBox){
        UncheckedInstitucion();
        chkSep.toggle();
        Institucion="SEP";
    }

    public void Unam(View CheckBox){
        UncheckedInstitucion();
        chkUnam.toggle();
        Institucion="UNAM";
    }

    public void Ipn(View CheckBox){
        UncheckedInstitucion();
        chkIpn.toggle();
        Institucion="IPN";
    }

    public void Uam(View CheckBox){
        UncheckedInstitucion();
        chkUam.toggle();
        Institucion="UAM";
    }


    //ACTIVIDADES BRIGADA
    public void Escombros(View CheckBox){
        if(Escombros.equals("No")){
            Escombros="Si";
        }
        else if(Escombros.equals("Si")){
            Escombros="No";
        }
    }

    public void Acordonar(View CheckBox){
        if(Acordonar.equals("No")){
            Acordonar="Si";
        }
        else if(Acordonar.equals("Si")){
            Acordonar="No";
        }
    }

    public void RevisionEstructuras(View CheckBox){
        if(RevisionEstructuras.equals("No")){
            RevisionEstructuras="Si";
        }
        else if(RevisionEstructuras.equals("Si")){
            RevisionEstructuras="No";
        }
    }

    public void RedElectrica(View CheckBox){
        if(RedElectrica.equals("No")){
            RedElectrica="Si";
        }
        else if(RedElectrica.equals("Si")){
            RedElectrica="No";
        }
    }

    public void Carpinteria(View CheckBox){
        if(Carpinteria.equals("No")){
            Carpinteria="Si";
        }
        else if(Carpinteria.equals("Si")){
            Carpinteria="No";
        }
    }

    public void SustanciasQuimicas(View CheckBox){
        if(SustanciasQuimicas.equals("No")){
            SustanciasQuimicas="Si";
        }
        else if(SustanciasQuimicas.equals("Si")){
            SustanciasQuimicas="No";
        }
    }

    public void Construccion(View CheckBox){
        if(Construccion.equals("No")){
            Construccion="Si";
        }
        else if(Construccion.equals("Si")){
            Construccion="No";
        }
    }

    public void PrimerosAuxilios(View CheckBox){
        if(PrimerosAuxilios.equals("No")){
            PrimerosAuxilios="Si";
        }
        else if(PrimerosAuxilios.equals("Si")){
            PrimerosAuxilios="No";
        }
    }


    //ZONA LIDER
    public void Zona1Lider(View CheckBox){
        UncheckedZonaLider();
        chkZona1Lider.toggle();
        ZonaLider="Zona 1";
    }
    public void Zona2Lider(View CheckBox){
        UncheckedZonaLider();
        chkZona2Lider.toggle();
        ZonaLider="Zona 2";
    }
    public void Zona3Lider(View CheckBox){
        UncheckedZonaLider();
        chkZona3Lider.toggle();
        ZonaLider="Zona 3";
    }


    //ZONA
    public void Zona1(View CheckBox){
        UncheckedZona();
        chkZona1.toggle();
        Zona="Zona 1";
    }
    public void Zona2(View CheckBox){
        UncheckedZona();
        chkZona2.toggle();
        Zona="Zona 2";
    }
    public void Zona3(View CheckBox){
        UncheckedZona();
        chkZona3.toggle();
        Zona="Zona 3";
    }


    //LUGAR
    public void Lugar1(View CheckBox){
        UncheckedLugar();
        chkLugar1.toggle();
        Lugar="Lugar 1";
    }
    public void Lugar2(View CheckBox){
        UncheckedLugar();
        chkLugar2.toggle();
        Lugar="Lugar 2";
    }
    public void Lugar3(View CheckBox){
        UncheckedLugar();
        chkLugar3.toggle();
        Lugar="Lugar 3";
    }


    //RESIDENTES
    public void Mujer(View CheckBox){
        if(Mujer.equals("No")){
            Mujer="Si";
        }
        else if(Mujer.equals("Si")){
            Mujer="No";
        }
    }
    public void Hombre(View CheckBox){
        if(Hombre.equals("No")){
            Hombre="Si";
        }
        else if(Hombre.equals("Si")){
            Hombre="No";
        }
    }
    public void Ninos(View CheckBox){
        if(Ninos.equals("No")){
            Ninos="Si";
        }
        else if(Ninos.equals("Si")){
            Ninos="No";
        }
    }
    public void Mascotas(View CheckBox){
        if(Mascotas.equals("No")){
            Mascotas="Si";
        }
        else if(Mascotas.equals("Si")){
            Mascotas="No";
        }
    }


    //EQUIPO
    public void Botas(View CheckBox){
        if(Botas.equals("No")){
            Botas="Si";
        }
        else if(Botas.equals("Si")){
            Botas="No";
        }
    }
    public void Chaleco(View CheckBox){
        if(Chaleco.equals("No")){
            Chaleco="Si";
        }
        else if(Chaleco.equals("Si")){
            Chaleco="No";
        }
    }
    public void Casco(View CheckBox){
        if(Casco.equals("No")){
            Casco="Si";
        }
        else if(Casco.equals("Si")){
            Casco="No";
        }
    }
    public void Guantes(View CheckBox){
        if(Guantes.equals("No")){
            Guantes="Si";
        }
        else if(Guantes.equals("Si")){
            Guantes="No";
        }
    }
    public void Cubrebocas(View CheckBox){
        if(Cubrebocas.equals("No")){
            Cubrebocas="Si";
        }
        else if(Cubrebocas.equals("Si")){
            Cubrebocas="No";
        }
    }
    public void Lentes(View CheckBox){
        if(Lentes.equals("No")){
            Lentes="Si";
        }
        else if(Lentes.equals("Si")){
            Lentes="No";
        }
    }

    //DISPONIBILIDAD
    public void Lunes(View CheckBox){
        if(Lunes.equals("No")){
            Lunes="Si";
        }
        else if(Lunes.equals("Si")){
            Lunes="No";
        }
    }
    public void Martes(View CheckBox){
        if(Martes.equals("No")){
            Martes="Si";
        }
        else if(Martes.equals("Si")){
            Martes="No";
        }
    }
    public void Miercoles(View CheckBox){
        if(Miercoles.equals("No")){
            Miercoles="Si";
        }
        else if(Miercoles.equals("Si")){
            Miercoles="No";
        }
    }
    public void Jueves(View CheckBox){
        if(Jueves.equals("No")){
            Jueves="Si";
        }
        else if(Jueves.equals("Si")){
            Jueves="No";
        }
    }
    public void Viernes(View CheckBox){
        if(Viernes.equals("No")){
            Viernes="Si";
        }
        else if(Viernes.equals("Si")){
            Viernes="No";
        }
    }
    public void Sabado(View CheckBox){
        if(Sabado.equals("No")){
            Sabado="Si";
        }
        else if(Sabado.equals("Si")){
            Sabado="No";
        }
    }
    public void Domingo(View CheckBox){
        if(Domingo.equals("No")){
            Domingo="Si";
        }
        else if(Domingo.equals("Si")){
            Domingo="No";
        }
    }

    public void DosAmSeisAm(View CheckBox){
        if(DosAmSeisAm.equals("No")){
            DosAmSeisAm="Si";
        }
        else if(DosAmSeisAm.equals("Si")){
            DosAmSeisAm="No";
        }
    }
    public void SeisAmDiezAm(View CheckBox){
        if(SeisAmDiezAm.equals("No")){
            SeisAmDiezAm="Si";
        }
        else if(SeisAmDiezAm.equals("Si")){
            SeisAmDiezAm="No";
        }
    }
    public void DiezAmDosPm(View CheckBox){
        if(DiezAmDosPm.equals("No")){
            DiezAmDosPm="Si";
        }
        else if(DiezAmDosPm.equals("Si")){
            DiezAmDosPm="No";
        }
    }
    public void DosPmSeisPm(View CheckBox){
        if(DosPmSeisPm.equals("No")){
            DosPmSeisPm="Si";
        }
        else if(DosPmSeisPm.equals("Si")){
            DosPmSeisPm="No";
        }
    }
    public void SeisPmDiezPm(View CheckBox){
        if(SeisPmDiezPm.equals("No")){
            SeisPmDiezPm="Si";
        }
        else if(SeisPmDiezPm.equals("Si")){
            SeisPmDiezPm="No";
        }
    }
    public void DiezPmDosAm(View CheckBox){
        if(DiezPmDosAm.equals("No")){
            DiezPmDosAm="Si";
        }
        else if(DiezPmDosAm.equals("Si")){
            DiezPmDosAm="No";
        }
    }

}
