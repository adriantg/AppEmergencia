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
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;


public class FormularioGeneral extends AppCompatActivity {

    private String APP_DIRECTORY= "AppE/";
    private String MEDIA_DIRECTORY = APP_DIRECTORY + "ImagenesAppE";
    private final int MY_PERMISSIONS = 10;
    private final int PHOTO_CODE = 20;
    private final int SELECT_PICTURE = 30;
    private String mPath;
    private Bitmap camara;
    private int indFotos;

    LinearLayout lytFormularioGeneral;

    Button btnIngresa;
    Button btnVerificado;
    Button btnSiguiente;

    Button btnFotoID;
    Button btnFotoDomicilio;

    Spinner spinUsuarios;

    CheckBox chkFemenino;
    CheckBox chkMasculino;

    EditText txtMaterno;
    EditText txtPaterno;
    EditText txtNombre;
    EditText txtEdad;
    EditText txtOcupacion;
    EditText txtNacionalidad;
    EditText txtID;
    LinearLayout vpFotoID;
    CheckBox chkFotoID;
    ImageView imgFotoID;
    EditText txtCalle;
    EditText txtNumExterior;
    EditText txtNumInterior;
    EditText txtColonia;
    EditText txtCP;
    EditText txtDelegacion;
    EditText txtEstado;
    LinearLayout vpFotoDomicilio;
    CheckBox chkFotoDomicilio;
    ImageView imgFotoDomicilio;
    EditText txtTelefono;
    EditText txtCelular;
    EditText txtCorreo;
    EditText txtRefNombre;
    EditText txtRefTelefono;
    EditText txtRefCorreo;

    String Paterno;
    String Materno;
    String Nombre;
    String Edad;
    String Ocupacion;
    String Sexo;
    String Nacionalidad;
    String ID;
    byte[] FotoID; //Reemplazar posteriormente con insertar imagen
    String Actividad;
    String Calle;
    String NumExterior;
    String NumInterior;
    String Colonia;
    String CP;
    String Delegacion;
    String Estado;
    byte[] FotoDomicilio;  //Reemplazar con insertar imagen
    String Telefono;
    String Celular;
    String Correo;
    String RefNombre;
    String RefTelefono;
    String RefCorreo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_general);

        Instanciar();

        vpFotoID.setVisibility(View.GONE);
        vpFotoDomicilio.setVisibility(View.GONE);

        if(obtenerPermisos()){
            btnFotoID.setEnabled(true);
            btnFotoDomicilio.setEnabled(true);
        }
        else{
            btnFotoID.setEnabled(false);
            btnFotoDomicilio.setEnabled(false);
        }

        btnIngresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormularioGeneral.this, Ingresa.class);
                startActivity(intent);

            }
        });

        btnVerificado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormularioGeneral.this, Inicio.class);
                startActivity(intent);

            }
        });


        btnFotoID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indFotos=0;
               mostrarOpciones();
                  }
        });

        btnFotoDomicilio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indFotos=1;
                mostrarOpciones();

            }
        });


        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    AltaSQL();
                    Intent siguiente = new Intent(FormularioGeneral.this, FormularioGeneral2.class);
                    siguiente.putExtra("ID",ID);        //Pasa a la siguiente actividad el valor de ID para nueva tabla
                    siguiente.putExtra("Actividad",Actividad);  //Para saber que desplegar y que no.
                    startActivity(siguiente);
                }
                catch(Exception excepcion){
                    Toast.makeText(FormularioGeneral.this,""+excepcion,Toast.LENGTH_SHORT).show();
                }


            }
        });

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
                        Actividad="Usuario Web";
                        break;
                    case 2:
                        Actividad="Líder brigadista";
                        break;
                    case 3:
                        Actividad="Líder transporte";
                        break;
                    case 4:
                        Actividad="Líder paramédicos";
                       break;
                    case 5:
                        Actividad="Información desastre";
                        break;
                    case 6:
                        Actividad="Información albergue";
                        break;
                    case 7:
                        Actividad="Información acopio";
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
            Snackbar.make(lytFormularioGeneral,"Los permisos son necesarios para recabar la información",
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
        final AlertDialog.Builder builder=new AlertDialog.Builder(FormularioGeneral.this);
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

            if(indFotos==0){
                imgFotoID.setImageBitmap(camara);//Vista previa
                FotoID=getBytes(camara);//Carga en variable para base de datos
            }
            else if(indFotos==1){
                imgFotoDomicilio.setImageBitmap(camara);
                FotoDomicilio=getBytes(camara);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==MY_PERMISSIONS){
            if(grantResults.length==2 && grantResults[0]==PackageManager.PERMISSION_GRANTED
                    && grantResults[1]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(FormularioGeneral.this, "Permisos aceptados", Toast.LENGTH_SHORT).show();
                btnFotoID.setEnabled(true);
                btnFotoDomicilio.setEnabled(true);
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


    public void FotoID(View Checkbox){
        if(chkFotoID.isChecked()){
            vpFotoID.setVisibility(View.VISIBLE);
        }
        else{
            vpFotoID.setVisibility(View.GONE);
        }
    }

    public void FotoDomicilio(View Checkbox){
        if(chkFotoDomicilio.isChecked()){
            vpFotoDomicilio.setVisibility(View.VISIBLE);
        }
        else{
            vpFotoDomicilio.setVisibility(View.GONE);
        }
    }

    public void Femenino(View Checkbox){
        chkMasculino.setChecked(false);
        chkFemenino.setChecked(true);
        Sexo="Femenino";
    }

    public void Masculino(View Checkbox){
        chkMasculino.setChecked(true);
        chkFemenino.setChecked(false);
        Sexo="Masculino";
    }

    private void Instanciar(){

        lytFormularioGeneral=(LinearLayout)findViewById(R.id.lyt_FormularioGeneral);

        btnIngresa = (Button) findViewById(R.id.btn_Ingresa);
        btnVerificado = (Button) findViewById(R.id.btn_Verificado);
        btnSiguiente=(Button) findViewById(R.id.btn_Siguiente);

        btnFotoID=(Button)findViewById(R.id.btn_FotoID);
        btnFotoDomicilio=(Button)findViewById(R.id.btn_FotoDomicilio);

        spinUsuarios =(Spinner)findViewById(R.id.spin_Usuarios);

        chkFemenino = (CheckBox) findViewById(R.id.chk_Femenino);
        chkMasculino = (CheckBox) findViewById(R.id.chk_Masculino);

        txtMaterno=(EditText) findViewById(R.id.txt_Amaterno);
        txtPaterno=(EditText) findViewById(R.id.txt_Apaterno);
        txtNombre=(EditText) findViewById(R.id.txt_Nombre);
        txtEdad=(EditText)findViewById(R.id.txt_Edad);
        txtOcupacion=(EditText) findViewById(R.id.txt_Ocupacion);
        txtNacionalidad=(EditText) findViewById(R.id.txt_Nacionalidad);
        txtID=(EditText) findViewById(R.id.txt_Id);
        chkFotoID=(CheckBox) findViewById(R.id.chk_FotoID);
        vpFotoID=(LinearLayout)findViewById(R.id.vp_FotoID);
        imgFotoID=(ImageView)findViewById(R.id.img_FotoID);
        txtCalle=(EditText) findViewById(R.id.txt_Calle);
        txtNumExterior=(EditText) findViewById(R.id.txt_Numero_exterior);
        txtNumInterior=(EditText) findViewById(R.id.txt_Numero_interior);
        txtColonia=(EditText)findViewById(R.id.txt_Colonia);
        txtCP=(EditText) findViewById(R.id.txt_Codigo_postal);
        txtDelegacion=(EditText) findViewById(R.id.txt_Delegacion);
        txtEstado=(EditText) findViewById(R.id.txt_Estado);
        chkFotoDomicilio=(CheckBox)findViewById(R.id.chk_FotoDomicilio);
        vpFotoDomicilio=(LinearLayout)findViewById(R.id.vp_FotoDomicilio);
        imgFotoDomicilio=(ImageView)findViewById(R.id.img_FotoDomicilio);
        txtTelefono=(EditText)findViewById(R.id.txt_Telefono_local);
        txtCelular=(EditText) findViewById(R.id.txt_Celular);
        txtCorreo=(EditText) findViewById(R.id.txt_Correo_electronico);
        txtRefNombre=(EditText) findViewById(R.id.txt_Nombre_p_referencia);
        txtRefTelefono=(EditText)findViewById(R.id.txt_Telefono_p_referencia);
        txtRefCorreo=(EditText) findViewById(R.id.txt_Correo_p_electronico);

    }

    private void ExtraerData(){
         Materno=txtMaterno.getText().toString();
         Paterno=txtPaterno.getText().toString();
         Nombre=txtNombre.getText().toString();
         Edad=txtEdad.getText().toString();
         Ocupacion=txtOcupacion.getText().toString();
         Nacionalidad=txtNacionalidad.getText().toString();
         ID=txtID.toString();
         Calle=txtCalle.getText().toString();
         NumExterior=txtNumExterior.toString();
         NumInterior=txtNumInterior.toString();
         Colonia=txtColonia.getText().toString();
         CP=txtCP.toString();
         Delegacion=txtDelegacion.getText().toString();
         Estado=txtEstado.getText().toString();
         Telefono=txtTelefono.toString();
         Celular=txtCelular.toString();
         Correo=txtCorreo.getText().toString();
         RefNombre=txtRefNombre.getText().toString();
         RefTelefono=txtRefTelefono.toString();
         RefCorreo=txtRefCorreo.getText().toString();
    }

    private void AltaSQL(){
        AuxSQLFormGen auxSQL = new AuxSQLFormGen(this,"FormularioGeneral",null,1);
        SQLiteDatabase bd = auxSQL.getWritableDatabase();
        ExtraerData();

        ContentValues registro = new ContentValues();

        registro.put("ID",ID);
        registro.put("APaterno",Paterno);
        registro.put("AMaterno",Materno);
        registro.put("Nombre",Nombre);
        registro.put("Edad",Edad);
        registro.put("Ocupacion",Ocupacion);
        registro.put("Sexo",Sexo);
        registro.put("Nacionalidad",Nacionalidad);
        registro.put("Identificacion",FotoID);
        registro.put("NumExterior",NumExterior);
        registro.put("NumInterior",NumInterior);
        registro.put("Colonia",Colonia);
        registro.put("CP",CP);
        registro.put("Delegacion",Delegacion);
        registro.put("Estado",Estado);
        registro.put("Domicilio",FotoDomicilio);
        registro.put("Telefono",Telefono);
        registro.put("Celular",Celular);
        registro.put("Correo",Correo);
        registro.put("RefNombre",RefNombre);
        registro.put("RefTelefono",RefTelefono);
        registro.put("RefCorreo",RefCorreo);
        registro.put("Actividad",Actividad);

        bd.insert("FormGen1", null, registro);
        bd.close();

        Toast.makeText(this,"Se han ingresado los datos",Toast.LENGTH_SHORT).show();
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

