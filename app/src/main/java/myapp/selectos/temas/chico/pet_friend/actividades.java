package myapp.selectos.temas.chico.pet_friend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class actividades extends AppCompatActivity {

    ImageView imvFotoMascota;
    TextView txtvNombre;
    TextView txtvComer;
    EditText edtComer;
    TextView txtvBañar;
    TextView txtvVerinario;
    EditText edtBañar;
    EditText edtfechavet;
    EditText edthoravet;
    EditText edtdirecvet;
    TextView txtvVacuna;
    EditText edtfechavac;
    EditText edthoravac;
    EditText edtdirecvac;
    Button btnGuardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);

        imvFotoMascota=findViewById(R.id.imvFotoMascota);
        txtvNombre=findViewById(R.id.txtvNombre);
        edtComer=findViewById(R.id.edtComer);
        edtBañar=findViewById(R.id.edtBañar);
        edtfechavet=findViewById(R.id.edtfechavet);
        edthoravet=findViewById(R.id.edthoravet);
        edtdirecvet=findViewById(R.id.edtdirecvet);
        edtfechavac=findViewById(R.id.edtfechavac);
        edthoravac=findViewById(R.id.edthoravac);
        edtdirecvac=findViewById(R.id.edtdirecvac);
        btnGuardar=findViewById(R.id.btnGuardar);

        int horas_comer= Integer.parseInt(edtComer.getText().toString());
        int horas_bañar=Integer.parseInt(edtBañar.getText().toString());
        String direccionVet= edtdirecvet.getText().toString();
        String direccionVac=edtdirecvac.getText().toString();
    }

    public void onClickGuardar(View v)
    {
        Intent intent=new Intent(this,RecyclerMascota.class);
        intent.putExtra("NombreMascota",txtvNombre.getText().toString());
        intent.putExtra("HoraComerMascota",edtComer.getText().toString());
        intent.putExtra("HoraBañarMascota",edtBañar.getText().toString());
        intent.putExtra("FechaVet",edtfechavet.getText().toString());
        intent.putExtra("HoraVet",edthoravet.getText().toString());
        intent.putExtra("HoraDirecVet",edtdirecvet.getText().toString());
        intent.putExtra("FechaVac",edtfechavac.getText().toString());
        intent.putExtra("HoraVac",edthoravac.getText().toString());
        intent.putExtra("HoraDirecVac",edtdirecvac.getText().toString());
        startActivity(intent);
    }
}
