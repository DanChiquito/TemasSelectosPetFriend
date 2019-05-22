package myapp.selectos.temas.chico.pet_friend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RegistroUsuario extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spnDia;
    private Spinner spnMes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

         spnDia = findViewById(R.id.spnDia);
         spnMes = findViewById(R.id.spnMes);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dia31,R.layout.support_simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.meses,R.layout.support_simple_spinner_dropdown_item);

        spnDia.setAdapter(adapter);
        spnMes.setAdapter(adapter2);

        spnDia.setOnItemSelectedListener(this);
        spnMes.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
