package myapp.selectos.temas.chico.pet_friend;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;

public class DatosMascota extends AppCompatActivity {

    ImageButton imbEditar;
    ImageView imvFoto;
    TextView txtvNombreMascota;
    TextView txtvCumple;
    TextView txtvRaza;

    public static final long duracionTrans = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_mascota);

        txtvNombreMascota=findViewById(R.id.txtvNombreMascota);
        txtvCumple = findViewById(R.id.txtvCumpleaños);
        txtvRaza = findViewById(R.id.txtvRaza);
        imvFoto = findViewById(R.id.imvFotoMascota);

        try
        {
            Bundle extras = getIntent().getExtras();
            Bitmap bitmapFoto= null;

            txtvNombreMascota.setText(extras.getString("NombreMascota")) ;
            txtvRaza.setText(extras.getString("Raza"));
            txtvCumple.setText(extras.getString("Cumple"));

            byte[] blob = extras.getByteArray("Foto");
            ByteArrayInputStream byteFoto = new ByteArrayInputStream(blob);
            bitmapFoto = BitmapFactory.decodeStream(byteFoto);
            imvFoto.setImageBitmap(bitmapFoto);
        }
        catch (Exception error)
        {
            Log.d("Error 04","Error: "+error.getMessage());
        }


    }
    public void onClick(View v)
    {
        IniciarTransicion();
        Intent intent = new Intent(this, formularioMascota.class);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
        finish();
    }
    public void IniciarTransicion(){
        Transition transition;
        transition = new Slide(Gravity.START);
        transition.setDuration(duracionTrans);
        transition.setInterpolator(new DecelerateInterpolator());
        getWindow().setExitTransition(transition);

    }

}
