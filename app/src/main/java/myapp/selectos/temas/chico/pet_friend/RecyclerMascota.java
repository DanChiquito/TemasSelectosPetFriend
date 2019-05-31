package myapp.selectos.temas.chico.pet_friend;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerMascota extends AppCompatActivity {

    private FloatingActionButton fabAddPet;
    private RecyclerView rcMyPets;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private TextView txtvtiempocomer;
    private TextView txtvtiempobañar;
    private TextView txtvfechavet;
    private TextView txtvtiempovet;
    private TextView txtvDirecvet;
    private TextView txtvfechavac;
    private TextView txtvtiempovac;
    private TextView txtvDirecvac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_mascota);

        fabAddPet = findViewById(R.id.fabAddPet);
        txtvtiempocomer=findViewById(R.id.txtvtiempocomer);
        txtvtiempobañar=findViewById(R.id.txtvtiempobañar);
        txtvfechavet=findViewById(R.id.txtvfechavet);
        txtvtiempovet=findViewById(R.id.txtvtiempovet);
        txtvDirecvet=findViewById(R.id.txtvDirecvet);
        txtvfechavac=findViewById(R.id.txtvfechavac);
        txtvtiempovac=findViewById(R.id.txtvtiempovac);
        txtvDirecvac=findViewById(R.id.txtvDirecvac);
        ArrayList<MascotaDatos> datosMascotas = new ArrayList<>();

        datosMascotas.add(new MascotaDatos("Puchy", R.drawable.catdog));
        datosMascotas.add(new MascotaDatos("Puchy", R.drawable.catdog));
        datosMascotas.add(new MascotaDatos("Puchy", R.drawable.catdog));
        datosMascotas.add(new MascotaDatos("Puchy", R.drawable.catdog));
        datosMascotas.add(new MascotaDatos("Puchy", R.drawable.catdog));
        datosMascotas.add(new MascotaDatos("Puchy", R.drawable.catdog));
        datosMascotas.add(new MascotaDatos("Puchy", R.drawable.catdog));
        datosMascotas.add(new MascotaDatos("Puchy", R.drawable.catdog));
        datosMascotas.add(new MascotaDatos("Puchy", R.drawable.catdog));

        rcMyPets = findViewById(R.id.rcMyPets);
        rcMyPets.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MascotaAdatador(datosMascotas);

        rcMyPets.setLayoutManager(mLayoutManager);
        rcMyPets.setAdapter(mAdapter);

    }

    public void onClickAdd(View v)
    {

    }
}
