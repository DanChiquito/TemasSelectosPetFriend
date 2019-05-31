package myapp.selectos.temas.chico.pet_friend;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public class RecyclerMascota extends AppCompatActivity {

    private FloatingActionButton fabAddPet;
    private RecyclerView rcMyPets;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_mascota);

        fabAddPet = findViewById(R.id.fabAddPet);

        byte []fotoByteArray= ByteBuffer.allocate(4).putInt(R.drawable.catdog).array();

        ArrayList<MascotaDatos> datosMascotas = new ArrayList<>();
        datosMascotas.add(new MascotaDatos("Puchy",10,"10/10/19","Pomerania", fotoByteArray,"Chico"));
        datosMascotas.add(new MascotaDatos("Puchy",10,"10/10/19","Pomerania", fotoByteArray,"Chico"));
        datosMascotas.add(new MascotaDatos("Puchy",10,"10/10/19","Pomerania", fotoByteArray,"Chico"));
        datosMascotas.add(new MascotaDatos("Puchy",10,"10/10/19","Pomerania", fotoByteArray,"Chico"));
        datosMascotas.add(new MascotaDatos("Puchy",10,"10/10/19","Pomerania", fotoByteArray,"Chico"));
        datosMascotas.add(new MascotaDatos("Puchy",10,"10/10/19","Pomerania", fotoByteArray,"Chico"));
        datosMascotas.add(new MascotaDatos("Puchy",10,"10/10/19","Pomerania",fotoByteArray,"Chico"));

        rcMyPets = findViewById(R.id.rcMyPets);
        rcMyPets.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MascotaAdatador(datosMascotas);

        rcMyPets.setLayoutManager(mLayoutManager);
        rcMyPets.setAdapter(mAdapter);

    }
}
