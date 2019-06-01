package myapp.selectos.temas.chico.pet_friend;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public class RecyclerMascota extends AppCompatActivity {

    private FloatingActionButton fabAddPet;
    private RecyclerView rcMyPets;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<MascotaDatos> datosMascotas;
    private String nombreMascota;
    private String horaComerMascota;
    private String horaBaMascota;
    private String fechaVet;
    private String horaVet;
    private String horaDirecVet;
    private String fechaVac;
    private String horaVac;
    private String direcVac;
    private byte [] fotoByteArray;
    private String raza;
    private String birthday;
    private String size;
    private String peso;
    private int diavac;
    private int mesvac;
    private int yearvac;
    private int diavet;
    private int mesvet;
    private int yearvet;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_mascota);

        fabAddPet = findViewById(R.id.fabAddPet);

        //OBTENIENDO DATOS DE OTROS ACTIVITIES PARA ASOCIARLOS AL OBJETO MascotaDatos

        Bundle bundle = getIntent().getExtras();

        try
        {
            nombreMascota= bundle.getString("NombreMascota");
            raza = bundle.getString("Raza");
            horaComerMascota=bundle.getString("HoraComerMascota");
            horaBaMascota =bundle.getString("HoraBañarMascota");
            fechaVet =bundle.getString("FechaVet");
            direcVac = bundle.getString("HoraDirecVac");


            horaVet=bundle.getString("HoraVet");
            horaDirecVet = bundle.getString("HoraDirecVet");
            fechaVac= bundle.getString("FechaVac");
            horaVac=bundle.getString("HoraVac");

            birthday = bundle.getString("Birthday");
            size = bundle.getString("Size");
            peso = bundle.getString("Peso");

            diavac = bundle.getInt("DiaVac");
            diavet =  bundle.getInt("DiaVet");
            mesvac =  bundle.getInt("MesVac");
            mesvet = bundle.getInt("MesVet");
            yearvac = bundle.getInt("YearVac");
            yearvet = bundle.getInt("YearVet");
        }
        catch (Exception error)
        {
            Toast.makeText(this, "¿Nuevo?, inicia registrando una mascota", Toast.LENGTH_SHORT).show();
        }


        fotoByteArray= ByteBuffer.allocate(4).putInt(R.drawable.catdog).array();



        datosMascotas = new ArrayList<>();
        datosMascotas.add(new MascotaDatos(nombreMascota,peso,birthday,raza, size,horaDirecVet,fechaVet,horaVet,fechaVac,horaVac,direcVac,horaComerMascota,horaBaMascota));

        rcMyPets = findViewById(R.id.rcMyPets);
        rcMyPets.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MascotaAdatador(datosMascotas);
        rcMyPets.setLayoutManager(mLayoutManager);
        rcMyPets.setAdapter(mAdapter);






    }

    //METODO BOTON AGREGAR
    public void onClickAdd(View v)
    {

        Intent intentFormMascota = new Intent(this, formularioMascota.class);
        startActivity(intentFormMascota);
    }


}
