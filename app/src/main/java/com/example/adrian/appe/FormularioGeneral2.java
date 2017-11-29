package com.example.adrian.appe;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class FormularioGeneral2 extends AppCompatActivity {

    private String APP_DIRECTORY= "AppE/";
    private String MEDIA_DIRECTORY = APP_DIRECTORY + "ImagenesAppE";
    private final int MY_PERMISSIONS = 10;
    private final int PHOTO_CODE = 20;
    private final int SELECT_PICTURE = 30;
    private String mPath;
    private Bitmap camara;
    private int indFotos;

    String Actividad;
    ArrayList<String> ArrayMiembros;

    //COMPLETADO sección de botónes
    Button btnRegresar;
    Button btnEnviarRegistro;
    Button btnIngresa;
    Button btnAgregarMiembro;

    Button btnFotoCertficado;
    Button btnFotoActividadesLider;
    Button btnFotoNuevoLugar;
    Button btnFotoActividades;

    //COMPLETADO sección de Layout
    LinearLayout lytFormularioGeneral2;

    LinearLayout vpFotoCertificado;
    LinearLayout vpFotoActividadesLider;
    LinearLayout vpFotoNuevoLugar;
    LinearLayout vpFotoActividades;

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
    CheckBox chkFotoCertificado;
    CheckBox chkFotoActividadesLider;
    CheckBox chkFotoNuevoLugar;
    CheckBox chkFotoActividades;

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
    EditText txtAutomovil;
    EditText txtMotocicleta;
    EditText txtBicicleta;
    EditText txtCamion;
    EditText txtCamioneta;
    EditText txtVan;
    EditText txtOtros;
    EditText txtNombreMiembro;
    EditText txtDireccionNuevoLugar;
    EditText txtDescripcionNuevoLugar;
    EditText txtCapacidadAlbergue; //VERIFICAR ID CON CHK
    EditText txtDescripcionActividadesRealizadas;
    EditText txtOtroEquipo;

    //Seccion ImageView
    ImageView imgFotoCertificado;
    ImageView imgFotoActividadesLider;
    ImageView imgFotoNuevoLugar;
    ImageView imgFotoActividades;

    //Variables para guardar la información
    String ID;

    String Facebook="No";
    String Twitter="No";
    String Instagram="No";
    String Snapchat="No";
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
    byte[] FotoCertificado; //Cambiar por un archivo de imagen
    String Automovil;
    String Motocicleta;
    String Bicicleta;
    String Camion;
    String Camioneta;
    String Van;
    String Otros;
    String Miembros;
    byte[] FotoActividadesLider; //Cambiar por un archivo de imagen
    String DireccionNuevoLugar;
    String DescripcionNuevoLugar;
    String CapacidadAlbergue; //VERIFICAR ID CON CHK
    byte[] FotoNuevoLugar; //Cambiar por un archivo de imagen
    String DescripcionActividadesRealizadas;
    byte[] FotoActividades; //Cambiar por un archivo de imagen
    String OtroEquipo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_general2);
        Instanciar();

        //Recibiendo extras
        Intent siguiente= getIntent();
        ID= siguiente.getStringExtra("ID");
        Actividad=siguiente.getStringExtra("Actividad");
        Toast.makeText(this,""+Actividad,Toast.LENGTH_SHORT).show();

        //Control de lo que se despliega y lo que no
        CargarViews();

        if(obtenerPermisos()){
            btnFotoCertficado.setEnabled(true);
            btnFotoActividadesLider.setEnabled(true);
            btnFotoNuevoLugar.setEnabled(true);
            btnFotoActividades.setEnabled(true);
        }
        else{
            btnFotoCertficado.setEnabled(false);
            btnFotoActividadesLider.setEnabled(false);
            btnFotoNuevoLugar.setEnabled(false);
            btnFotoActividades.setEnabled(false);
        }

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FormularioGeneral2.this,FormularioGeneral.class);
                startActivity(intent);
            }
        });

        btnFotoCertficado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indFotos=0;
                mostrarOpciones();
            }
        });
        btnFotoActividadesLider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indFotos=1;
                mostrarOpciones();
            }
        });
        btnFotoNuevoLugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indFotos=2;
                mostrarOpciones();
            }
        });
        btnFotoActividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indFotos=3;
                mostrarOpciones();
            }
        });

        btnAgregarMiembro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayMiembros.add(txtNombreMiembro.getText().toString());
                txtNombreMiembro.setText("");
                Toast.makeText(FormularioGeneral2.this,"Miembro agregado",Toast.LENGTH_SHORT).show();
            }
        });

        btnEnviarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    AltaSQL();
                    Intent intent=new Intent(FormularioGeneral2.this,Inicio.class);
                    startActivity(intent);
                }                
                catch(Exception excepcion){
                    Toast.makeText(FormularioGeneral2.this,""+excepcion,Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean obtenerPermisos(){
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            return true;
        }

        if((checkSelfPermission(WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)
                &&(checkSelfPermission(CAMERA)== PackageManager.PERMISSION_GRANTED)){
            return true;
        }

        if((shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE))||(shouldShowRequestPermissionRationale(CAMERA))){
            Snackbar.make(lytFormularioGeneral2,"Los permisos son necesarios para recabar la información",
                    Snackbar.LENGTH_INDEFINITE).setAction(android.R.string.ok, new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.M)
                @Override
                public void onClick(View v) {
                    requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,CAMERA},MY_PERMISSIONS);
                }
            }).show();
        }
        else{
            requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,CAMERA},MY_PERMISSIONS);
        }

        return false;
    }

    private void mostrarOpciones(){
        final CharSequence[] opciones={"Tomar foto","Elegir de galería","Cancelar"};
        final AlertDialog.Builder builder=new AlertDialog.Builder(FormularioGeneral2.this);
        builder.setTitle("Elige una opción.");
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(opciones[which]=="Tomar foto"){
                    openCamera();
                }
                else if(opciones[which]=="Elegir de galería"){
                    Intent intent=new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(intent.createChooser(intent,"Selecciona App de imágenes"),SELECT_PICTURE);
                }
                else{
                    dialog.dismiss();
                }

            }
        });

        builder.show();

    }

    private void openCamera() {
        File file=new File(Environment.getExternalStorageDirectory(),MEDIA_DIRECTORY);
        boolean isDirectoryCreated=file.exists();

        if(!isDirectoryCreated){
            isDirectoryCreated=file.mkdirs();
        }
        if(isDirectoryCreated){
            Long timestamp=System.currentTimeMillis()/1000;
            String imageName=timestamp.toString()+".jpg";

            mPath=Environment.getExternalStorageDirectory() + File.separator + MEDIA_DIRECTORY +
                    File.separator + imageName;

            File newFile=new File(mPath);

            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(newFile));
            startActivityForResult(intent,PHOTO_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            switch (requestCode){
                case PHOTO_CODE:
                    MediaScannerConnection.scanFile(this, new String[]{mPath}, null, new MediaScannerConnection.OnScanCompletedListener() {
                        @Override
                        public void onScanCompleted(String path, Uri uri) {
                            Log.i("External Storage","Scanned "+path+": ");
                            Log.i("External Storage","--> Uri= "+uri);
                        }
                    });

                    camara= BitmapFactory.decodeFile(mPath);
                    break;

                case SELECT_PICTURE:
                    try{
                        camara=MediaStore.Images.Media.getBitmap(this.getContentResolver(),data.getData());
                    }
                    catch (IOException e){

                    }
                    finally {
                        break;
                    }
            }

            switch (indFotos){
                case 0:
                    imgFotoCertificado.setImageBitmap(camara);
                    FotoCertificado=getBytes(camara);
                    break;
                case 1:
                    imgFotoActividadesLider.setImageBitmap(camara);
                    FotoActividadesLider=getBytes(camara);
                    break;
                case 2:
                    imgFotoNuevoLugar.setImageBitmap(camara);
                    FotoNuevoLugar=getBytes(camara);
                    break;
                case 3:
                    imgFotoActividades.setImageBitmap(camara);
                    FotoActividades=getBytes(camara);
                    break;
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==MY_PERMISSIONS){
            if(grantResults.length==2 && grantResults[0]==PackageManager.PERMISSION_GRANTED
                    && grantResults[1]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(FormularioGeneral2.this, "Permisos aceptados", Toast.LENGTH_SHORT).show();
                btnFotoCertficado.setEnabled(true);
                btnFotoActividadesLider.setEnabled(true);
                btnFotoNuevoLugar.setEnabled(true);
                btnFotoActividades.setEnabled(true);
            }
        }
        else{
            mostrarExpPermisos();
        }

    }

    private void mostrarExpPermisos() {
        AlertDialog.Builder  builder= new AlertDialog.Builder(this);
        builder.setTitle("Permisos denegados");
        builder.setMessage("Para llenar correctamente el formulario es necesario conceder los permisos.");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri=Uri.fromParts("package",getPackageName(),null);
                intent.setData(uri);
                startActivity(intent);
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });
        builder.show();
    }

    private void Instanciar() {

        btnRegresar = (Button) findViewById(R.id.btn_Regresar);
        btnEnviarRegistro=(Button)findViewById(R.id.btn_Enviar_Registro);
        btnIngresa=(Button)findViewById(R.id.btn_IngresarMiembro);
        btnAgregarMiembro=(Button)findViewById((R.id.btn_IngresarMiembro));

        btnFotoCertficado=(Button)findViewById(R.id.btn_FotoCertificado);
        btnFotoActividadesLider=(Button)findViewById((R.id.btn_FotoActividadesLider));
        btnFotoNuevoLugar=(Button)findViewById(R.id.btn_FotoNuevoLugar);
        btnFotoActividades=(Button)findViewById(R.id.btn_FotoActividades);

        ArrayMiembros=new ArrayList<String>();

        //Seccion Layout
        lytFormularioGeneral2=(LinearLayout)findViewById(R.id.lyt_FormularioGeneral2);

        vpFotoCertificado=(LinearLayout)findViewById(R.id.vp_FotoCertificado);
        vpFotoActividadesLider=(LinearLayout)findViewById(R.id.vp_FotoActividadesLider);
        vpFotoNuevoLugar=(LinearLayout)findViewById(R.id.vp_FotoNuevoLugar);
        vpFotoActividades=(LinearLayout)findViewById(R.id.vp_FotoActividades);

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

        //Seccion ImageView
        imgFotoCertificado=(ImageView)findViewById(R.id.img_FotoCertificado);
        imgFotoActividadesLider=(ImageView)findViewById(R.id.img_FotoActividadesLider);
        imgFotoNuevoLugar=(ImageView)findViewById(R.id.img_FotoNuevoLugar);
        imgFotoActividades=(ImageView)findViewById(R.id.img_FotoActividades);

        // COMPLETADO Sección de checkbox
        chkFotoCertificado=(CheckBox)findViewById(R.id.chk_FotoCertificado);
        chkFotoActividadesLider=(CheckBox)findViewById(R.id.chk_FotoActividadesLider);
        chkFotoNuevoLugar=(CheckBox)findViewById(R.id.chk_FotoNuevoLugar);
        chkFotoActividades=(CheckBox)findViewById(R.id.chk_FotoActividades);


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
        txtAutomovil=(EditText) findViewById(R.id.txt_Auto);
        txtMotocicleta=(EditText) findViewById(R.id.txt_Moto);
        txtBicicleta=(EditText) findViewById(R.id.txt_Bici);
        txtCamion=(EditText) findViewById(R.id.txt_Camion);
        txtCamioneta=(EditText) findViewById(R.id.txt_Camioneta);
        txtVan=(EditText) findViewById(R.id.txt_Van);
        txtOtros=(EditText) findViewById(R.id.txt_Otrobrigadista);
        txtNombreMiembro=(EditText) findViewById(R.id.txt_NombreMiembro);
        txtDireccionNuevoLugar=(EditText) findViewById(R.id.txt_DireccionNuevoLugar);
        txtDescripcionNuevoLugar=(EditText) findViewById(R.id.txt_DescripcionNuevoLugar);
        txtCapacidadAlbergue=(EditText) findViewById(R.id.txt_CapacidadAlbergue);
        txtDescripcionActividadesRealizadas=(EditText) findViewById(R.id.txt_DescripcionActividadesRealizadas);
        txtOtroEquipo=(EditText) findViewById(R.id.txt_OtroEquipo);

    }

    //EXTRAER INFORMACIÓN
    private void ExtraerData(){
        Experiencia=txtExperiencia.getText().toString();
        Certificados=txtCertificados.getText().toString();
        Automovil=txtAutomovil.getText().toString();
        Motocicleta=txtMotocicleta.getText().toString();
        Bicicleta=txtBicicleta.getText().toString();
        Camion=txtCamion.getText().toString();
        Camioneta=txtCamioneta.getText().toString();
        Van=txtVan.getText().toString();
        Otros=txtOtros.getText().toString();
        DireccionNuevoLugar=txtDireccionNuevoLugar.getText().toString();
        DescripcionNuevoLugar=txtDescripcionNuevoLugar.getText().toString();
        CapacidadAlbergue=txtCapacidadAlbergue.getText().toString();
        DescripcionActividadesRealizadas=txtDescripcionActividadesRealizadas.getText().toString();
        OtroEquipo=txtOtroEquipo.getText().toString();
        Miembros=convertArrayToString(ArrayMiembros);
    }

    //CARGAR A LA BASE DE DATOS
    private void AltaSQL(){
        AuxSQLFormGen auxSQL = new AuxSQLFormGen(this,"FormularioGeneral",null,1);
        SQLiteDatabase bd = auxSQL.getWritableDatabase();
        ExtraerData();

        ContentValues registro = new ContentValues();

        registro.put("ID",ID);

        registro.put("Facebook",Facebook);
        registro.put("Twitter",Twitter);
        registro.put("Instagram",Instagram);
        registro.put("Snapchat",Snapchat);
        registro.put("Institucion",Institucion);

        registro.put("Escombros",Escombros);
        registro.put("Acordonar",Acordonar);
        registro.put("RevisionEstructuras",RevisionEstructuras);
        registro.put("RedElectrica",RedElectrica);
        registro.put("Carpinteria",Carpinteria);
        registro.put("SustanciasQuimicas",SustanciasQuimicas);
        registro.put("Construccion",Construccion);
        registro.put("PrimerosAuxilios",PrimerosAuxilios);

        registro.put("ZonaLider",ZonaLider);

        registro.put("Zona",Zona);
        registro.put("Lugar",Lugar);
        registro.put("Mujer",Mujer);
        registro.put("Hombre",Hombre);
        registro.put("Ninos",Ninos);
        registro.put("Mascotas",Mascotas);
        registro.put("Botas",Botas);
        registro.put("Chaleco",Chaleco);
        registro.put("Casco",Casco);
        registro.put("Guantes",Guantes);
        registro.put("Cubrebocas",Cubrebocas);
        registro.put("Lentes",Lentes);

        registro.put("Lunes",Lunes);
        registro.put("Martes",Martes);
        registro.put("Miercoles",Miercoles);
        registro.put("Jueves",Jueves);
        registro.put("Viernes",Viernes);
        registro.put("Sabado",Sabado);
        registro.put("Domingo",Domingo);
        registro.put("DosAmSeisAm",DosAmSeisAm);
        registro.put("SeisAmDiezAm",SeisAmDiezAm);
        registro.put("DiezAmDosPm",DiezAmDosPm);
        registro.put("DosPmSeisPm",DosPmSeisPm);
        registro.put("SeisPmDiezPm",SeisPmDiezPm);
        registro.put("DiezPmDosAm",DiezPmDosAm);

        registro.put("Experiencia",Experiencia);
        registro.put("Certificados",Certificados);
        registro.put("FotoCertificado",FotoCertificado);
        registro.put("Automovil",Automovil);
        registro.put("Motocicleta",Motocicleta);
        registro.put("Bicicleta",Bicicleta);
        registro.put("Camion",Camion);
        registro.put("Camioneta",Camioneta);
        registro.put("Van",Van);
        registro.put("Otros",Otros);
        registro.put("Miembros",Miembros);
        registro.put("FotoActividadesLider",FotoActividadesLider);
        registro.put("DireccionNuevoLugar",DireccionNuevoLugar);
        registro.put("DescripcionNuevoLugar",DescripcionNuevoLugar);
        registro.put("CapacidadAlbergue",CapacidadAlbergue);
        registro.put("FotoNuevoLugar",FotoNuevoLugar);
        registro.put("DescripcionActividadesRealizadas",DescripcionActividadesRealizadas);
        registro.put("FotoActividades",FotoActividades);
        registro.put("OtroEquipo",OtroEquipo);

        bd.insert("FormGen2", null, registro);
        bd.close();

        Toast.makeText(this,"Solicitud de registro enviada",Toast.LENGTH_SHORT).show();
    }

    //CARGAR SECCIONES
    private void CargarViews(){

        vpFotoCertificado.setVisibility(View.GONE);
        vpFotoActividadesLider.setVisibility(View.GONE);
        vpFotoNuevoLugar.setVisibility(View.GONE);
        vpFotoActividades.setVisibility(View.GONE);

        if(Actividad.equals("Usuario Web")){
            txtTitulo.setText("Usuario web");
            txtDescripcion.setText("\nEste tipo de usuario es el encargado de publicar en la aplicación comunicados oficiales. Tiene la obligación de estar al pendiente de las páginas oficiales de una institución pública y recopilar los avisos, los comunicados e información relevante publicada en ellas.\n");
            lytSeccionLider.setVisibility(View.GONE);
            lytSeccionLugarActividades.setVisibility(View.GONE);

        }
        else if(Actividad.equals("Líder brigadista")){
            txtTitulo.setText("Líder de brigada");
            txtDescripcion.setText("\nEste tipo de usuario tiene organizado un grupo de voluntarios con conocimientos adecuados capaces de ejercer como brigadistas. Tiene la información de otros voluntarios y es capaz de organizarlos para ayudar donde se necesite. Es capaz de compartir sus conocimientos a otras personas, por lo que puede organizar grupos de capacitación para sumarse a su equipo de trabajo. En la aplicación puede solicitar voluntarios para su grupo, convocar a cursos de capacitación o ponerse a disposición de otros usuarios para ayudar.\n");
            lytSeccionWeb.setVisibility(View.GONE);
            lytSeccionTransportes.setVisibility(View.GONE);
            lytSeccionLugarActividades.setVisibility(View.GONE);

        }
        else if(Actividad.equals("Líder transporte")){
            txtTitulo.setText("Líder de transportistas");
            txtDescripcion.setText("\nOrganiza a aquellas personas que poseen al menos una forma de movilizar personas, víveres, herramienta o material especializado a las zonas en las que se necesiten. En la aplicación puede solicitar voluntarios para su grupo, convocar a cursos de capacitación o ponerse a disposición de otros usuarios para ayudar.\n");
            lytSeccionWeb.setVisibility(View.GONE);
            lytSeccionActividadesBrigada.setVisibility(View.GONE);
            lytSeccionCertificados.setVisibility(View.GONE);
            lytSeccionLugarActividades.setVisibility(View.GONE);

        }
        else if(Actividad.equals("Líder paramédicos")){
            txtTitulo.setText("Líder de paramédicos");
            txtDescripcion.setText("\nEste tipo de usuario tiene organizado un grupo de voluntarios con conocimientos adecuados capaces de ejercer como paramédicos. Tiene la información de otros voluntarios y es capaz de organizarlos para ayudar donde se necesite. Es capaz de compartir sus conocimientos a otras personas, por lo que puede organizar grupos de capacitación para sumarse a su equipo de trabajo. En la aplicación puede solicitar voluntarios para su grupo, convocar a cursos de capacitación o ponerse a disposición de otros usuarios para ayudar donde se necesite.\n");
            lytSeccionWeb.setVisibility(View.GONE);
            lytSeccionTransportes.setVisibility(View.GONE);
            lytSeccionActividadesBrigada.setVisibility(View.GONE);
            lytSeccionLugarActividades.setVisibility(View.GONE);
        }
        else if(Actividad.equals("Información desastre")){
            txtTitulo.setText("Voluntario en zona de desastre");
            txtDescripcion.setText("\nEste tipo de usuario es el encargado de estar presente en una zona de afectación, por ejemplo: zona de derrumbe o inundación. Tiene la tarea de reportar las necesidades del lugar en tiempo real, tanto de bienes materiales como de recursos humanos. Debe reportar sucesos relevantes, como identificación de las personas afectadas y el estado de las mismas.\n");
            lytSeccionWeb.setVisibility(View.GONE);
            lytSeccionLider.setVisibility(View.GONE);
            lytSeccionAgregarLugar.setVisibility(View.GONE);
            lytSeccionAgregarAlbergue.setVisibility(View.GONE);


        }
        else if(Actividad.equals("Información albergue")){
            txtTitulo.setText("Voluntario en albergue");
            txtDescripcion.setText("\nEste tipo de usuario es el encargado de estar presente en un albergue. Tiene la tarea de reportar las necesidades del lugar en tiempo real, tanto de bienes materiales como de recursos humanos. Debe ser un usuario que esté familiarizado con el trabajo en el albergue.\n");
            lytSeccionWeb.setVisibility(View.GONE);
            lytSeccionLider.setVisibility(View.GONE);
            lytSeccionAgregarLugar.setVisibility(View.GONE);
            lytSeccionEquipoDisponible.setVisibility(View.GONE);

        }
        else if(Actividad.equals("Información acopio")){
            txtTitulo.setText("Voluntario en centro de acopio");
            txtDescripcion.setText("\nEste tipo de usuario es el encargado de estar presente en un centro de acopio. Tiene la tarea de reportar las necesidades del lugar en tiempo real, tanto de bienes materiales como de recursos humanos. Debe ser un usuario que esté familiarizado con el trabajo en el centro de acopio.\n");
            lytSeccionWeb.setVisibility(View.GONE);
            lytSeccionLider.setVisibility(View.GONE);
            lytSeccionAgregarLugar.setVisibility(View.GONE);
            lytSeccionAgregarAlbergue.setVisibility(View.GONE);
            lytSeccionEquipoDisponible.setVisibility(View.GONE);
        }
        else{
            Intent regresar=new Intent(FormularioGeneral2.this,FormularioGeneral.class);
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
            startActivity(regresar);
        }
    }

    //AGREGAR LUGAR
    public void AgregarLugar(View CheckBox){
        chkLugar1.setChecked(false);
        chkLugar2.setChecked(false);
        chkLugar3.setChecked(false);
        if(chkAgregarLugar.isChecked()){
           lytSeccionAgregarLugar.setVisibility(View.VISIBLE);
        }
        else{
            lytSeccionAgregarLugar.setVisibility(View.GONE);
        }
    }

    //Vistas Previas Imagenes
    public void FotoCertificado(View Checkbox){
        if(chkFotoCertificado.isChecked()){
            vpFotoCertificado.setVisibility(View.VISIBLE);
        }
        else{
            vpFotoCertificado.setVisibility(View.GONE);
        }
    }
    public void FotoActividadesLider(View Checkbox){
        if(chkFotoActividadesLider.isChecked()){
            vpFotoActividadesLider.setVisibility(View.VISIBLE);
        }
        else{
            vpFotoActividadesLider.setVisibility(View.GONE);
        }
    }
    public void FotoNuevoLugar(View Checkbox){
        if(chkFotoNuevoLugar.isChecked()){
            vpFotoNuevoLugar.setVisibility(View.VISIBLE);
        }
        else{
            vpFotoNuevoLugar.setVisibility(View.GONE);
        }
    }
    public void FotoActividades(View Checkbox){
        if(chkFotoActividades.isChecked()){
            vpFotoActividades.setVisibility(View.VISIBLE);
        }
        else{
            vpFotoActividades.setVisibility(View.GONE);
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
        chkAgregarLugar.setChecked(false);
        lytSeccionAgregarLugar.setVisibility(View.GONE);
    }


    //EXTRACCION DATOS DE LOS CHECKBOX

    //REDES SOCIALES
    public void Facebook(View CheckBox){
        if(Facebook.equals("No")){
            Facebook="Si";
        }
        else if(Facebook.equals("Si")){
            Facebook="No";
        }
    }
    public void Twitter(View CheckBox){
        if(Twitter.equals("No")){
            Twitter="Si";
        }
        else if(Twitter.equals("Si")){
            Twitter="No";
        }
    }
    public void Instagram(View CheckBox){
        if(Instagram.equals("No")){
            Instagram="Si";
        }
        else if(Instagram.equals("Si")){
            Instagram="No";
        }
    }
    public void Snapchat(View CheckBox){
        if(Snapchat.equals("No")){
            Snapchat="Si";
        }
        else if(Snapchat.equals("Si")){
            Snapchat="No";
        }
    }

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

    //Convertir arrayList a string y viceversa
    public static String Separador = "__,__";
    public static String convertArrayToString(ArrayList<String> array){
        String str = "";
        for (int i = 0;i<array.size(); i++) {
            str = str+array.get(i);
            // Do not append comma at the end of last element
            if(i<array.size()-1){
                str = str+Separador;
            }
        }
        return str;
    }
    public static String[] convertStringToArray(String str){
        String[] arr = str.split(Separador);
        return arr;
    }

    // convert from bitmap to byte array
    public static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }

    // convert from byte array to bitmap
    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

}
