package myapp.selectos.temas.chico.pet_friend;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {

    private Transition transition;
    public static final long duracionTrans = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickRegistrarse(View v){
        IniciarTransición();
        Intent intent = new Intent(this, AcercaDe.class);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    }

    public void onClickAcercaCe(View v)
    {
        IniciarTransición();
    }

    public void IniciarTransición(){
        transition = new Slide(Gravity.START);
        transition.setDuration(duracionTrans);
        transition.setInterpolator(new DecelerateInterpolator());
        getWindow().setExitTransition(transition);

    }


}
