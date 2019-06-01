package myapp.selectos.temas.chico.pet_friend;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private Button btnIniciarSesion;
    private EditText edtCorreoExist;
    private EditText edtPassExist;
    private String correo;
    private String password;

    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;

    public static final long duracionTrans = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        edtCorreoExist = findViewById(R.id.edtCorreo);
        edtPassExist = findViewById(R.id.edtPassword);
        progressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();


    }

    private void LoguearUsuario()
    {
        final FirebaseUser user = mAuth.getCurrentUser();

        correo = edtCorreoExist.getText().toString().trim();
        password = edtPassExist.getText().toString().trim();

        //Verificando que no haya EditText vacios
        if (TextUtils.isEmpty(correo)) {

            Toast.makeText(this, "Se debe escribir un correo", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Se debe escribir una contraseña", Toast.LENGTH_SHORT).show();
            return;

        }
        //mandando al usuario un mensaje de carga de que se esta registrando  o esta iniciando sesión
        progressDialog.setMessage("Conectando, espera unn momento");
        progressDialog.show();


        //Verificacion del usuario si ya ha aceptado el correo electrónico
        mAuth.signInWithEmailAndPassword(correo, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!user.isEmailVerified())
                {
                    Toast.makeText(MainActivity.this, "Acepte el correo de verificación para poder continuar", Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (task.isSuccessful()){

                        Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                        IntentSegundoActivity();
                    }
                    else {
                        if (task.getException() instanceof FirebaseAuthUserCollisionException)
                        {
                            Toast.makeText(MainActivity.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "El usuario no existe", Toast.LENGTH_SHORT).show();
                        }

                    }
                }

                progressDialog.dismiss();
            }
        });
    }

    public void onClickRegistrarse(View v){
        IniciarTransicion();
        Intent intent = new Intent(this, RegistroUsuario.class);
        startActivity(intent,  ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());

    }

    public void IntentSegundoActivity()
    {
        Intent intent = new Intent(this, RecyclerMascota.class);
        startActivity(intent,  ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    }

    public void onClickIniciarSesión(View v){
        IniciarTransicion();
        LoguearUsuario();


    }

    public void onClickAcercaCe(View v)
    {
        IniciarTransicion();
        Intent intent = new Intent(this, AcercaDe.class);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    }


    // Método para poder iniciar las transiciones entre activities
    public void IniciarTransicion(){
        Transition transition;
        transition = new Slide(Gravity.START);
        transition.setDuration(duracionTrans);
        transition.setInterpolator(new DecelerateInterpolator());
        getWindow().setExitTransition(transition);

    }




}
