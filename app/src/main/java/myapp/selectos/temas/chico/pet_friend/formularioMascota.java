package myapp.selectos.temas.chico.pet_friend;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;

import java.io.ByteArrayInputStream;

public class formularioMascota extends AppCompatActivity {

    ImageView imgFoto;
    EditText txtvNombre;
    EditText txtvCompleaños;
    EditText txtvPeso;
    Switch swGrande;
    Switch swMediano;
    Switch swPequeño;
    Switch swPerroGato;
    Spinner spnRazas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_mascota);
        imgFoto=findViewById(R.id.imvFotoMascota);
        swPerroGato= findViewById(R.id.swPerroGato);
        spnRazas = findViewById(R.id.spnRazas);
        ArrayAdapter<CharSequence> adapterRazas = ArrayAdapter.createFromResource(this, R.array.razasPerro, android.R.layout.simple_spinner_item);
        adapterRazas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnRazas.setAdapter(adapterRazas);


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
    public void OnCLickTerminar(View v)
    {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmapImagen = (Bitmap) data.getExtras().get("data");
        imgFoto.setImageBitmap(bitmapImagen);
    }
}
