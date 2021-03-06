package myapp.selectos.temas.chico.pet_friend;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.shape.ShapePath;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class formularioMascota extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    ImageView imgFotoMascota;
    EditText edtNombre;
    EditText edtCumple;
    EditText edtPeso;
    Switch swGrande;
    Switch swMediano;
    Switch swChico;
    Switch swPerroGato;
    Spinner spnRazas;
    String razaSeleccionada;
    String size;
    public static final long duracionTrans = 1000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_mascota);

        edtNombre=findViewById(R.id.edtNombreMascota);
        edtPeso = findViewById(R.id.edt_Peso);
        edtCumple=findViewById(R.id.edtCumple);
        swPerroGato= findViewById(R.id.swPerroGato);
        imgFotoMascota=findViewById(R.id.imvFotoMascota);

        spnRazas = findViewById(R.id.spnRazas);

        swGrande=findViewById(R.id.swtGrande);
        swMediano=findViewById(R.id.swMediano);
        swChico=findViewById(R.id.swChico);



        ArrayAdapter<CharSequence> adapterRazas = ArrayAdapter.createFromResource(this, R.array.razasPerro, android.R.layout.simple_spinner_item);
        adapterRazas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnRazas.setAdapter(adapterRazas);
        spnRazas.setOnItemSelectedListener(this);


    }
    public void onClickEditarFoto(View v)
    {
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},1);
        Intent intCamara= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intCamara,0);

    }
    public void onClickSeleccionaRaza(View v) {

        if (swPerroGato.isChecked()) {
            ArrayAdapter<CharSequence> adapterRazas = ArrayAdapter.createFromResource(this, R.array.razasGato, android.R.layout.simple_spinner_item);
            adapterRazas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnRazas.setAdapter(adapterRazas);
        }
        else
        {
            ArrayAdapter<CharSequence>adapterRazas=ArrayAdapter.createFromResource(this,R.array.razasPerro,android.R.layout.simple_spinner_item);
            adapterRazas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnRazas.setAdapter(adapterRazas);
        }


    }
    public void onClickTerminar(View v)
    {


        if(swChico.isChecked())
        {
            size="Chico";
        }
        if(swMediano.isChecked())
        {
            size="Mediano";
        }
        if(swGrande.isChecked())
        {
            size="Grande";
        }
        if(swGrande.isChecked()|swMediano.isChecked()|swChico.isChecked())
        {

            try
            {
                String nombre=edtNombre.getText().toString();
                String fechaNacimiento = edtCumple.getText().toString();
                int peso = Integer.parseInt(edtPeso.getText().toString());


                Bitmap bitmFoto= ((BitmapDrawable) imgFotoMascota.getDrawable()).getBitmap();
                ByteArrayOutputStream byteImagen= new ByteArrayOutputStream(20480);
                bitmFoto.compress(Bitmap.CompressFormat.PNG,0,byteImagen);
                byte[]blobMascota=byteImagen.toByteArray();

                if(!(nombre.equals("") || fechaNacimiento.equals("")|| edtPeso.getText().toString().equals("")))
                {

                    Intent intentActividades = new Intent(formularioMascota.this,actividades.class);
                    intentActividades.putExtra("NombreMascota",nombre);
                    intentActividades.putExtra("Raza",razaSeleccionada);
                    intentActividades.putExtra("Cumple",fechaNacimiento);
                    intentActividades.putExtra("Peso",peso);
                    intentActividades.putExtra("Size",size);
                    intentActividades.putExtra("Foto",blobMascota);


                    startActivity(intentActividades);

                }
            }

            catch(Exception error)
            {
                Log.d("Error 01","Error: "+error.getMessage());
                Toast.makeText(getApplicationContext(), "Por favor llena todos los campos", Toast.LENGTH_SHORT).show();
            }

        }
        else
        {
            Toast.makeText(getApplicationContext(), "Por favor llena todos los campos", Toast.LENGTH_SHORT).show();
        }




    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bitmapImagen = (Bitmap) data.getExtras().get("data");
        imgFotoMascota.setImageBitmap(bitmapImagen);


    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

       razaSeleccionada = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        razaSeleccionada = parent.getItemAtPosition(0).toString();
    }
    public void IniciarTransicion(){
        Transition transition;
        transition = new Slide(Gravity.START);
        transition.setDuration(duracionTrans);
        transition.setInterpolator(new DecelerateInterpolator());
        getWindow().setExitTransition(transition);

    }
}
