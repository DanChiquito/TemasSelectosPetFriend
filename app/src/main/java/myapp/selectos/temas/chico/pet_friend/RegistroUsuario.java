package myapp.selectos.temas.chico.pet_friend;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class RegistroUsuario extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private String correo;
    private String password;
    private String nombre;
    private String passwordConf;
    private EditText edtNomUsuario;
    private EditText edtCorreoIng;
    private EditText edtNewPassword;
    private EditText edtPassConf;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        edtCorreoIng = findViewById(R.id.edtCorreoIng);
        edtNomUsuario = findViewById(R.id.edtNombreUsuario);
        edtNewPassword = findViewById(R.id.edtNewPassword);
        edtPassConf = findViewById(R.id.edtConPass);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
    }

    public void onClickSiguiente(View v)
    {
        correo = edtCorreoIng.getText().toString().trim();
        password = edtNewPassword.getText().toString().trim();
        nombre = edtNomUsuario.getText().toString().trim();
        passwordConf = edtPassConf.getText().toString().trim();

        if (TextUtils.isEmpty(nombre))
        {
            Toast.makeText(this, "Debes tener al menos un nombre, ¿no?", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(passwordConf))
        {
            Toast.makeText(this, "Parece que se te olvidó confirmar la contraseña", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(correo)) {

            Toast.makeText(this, "Se debe escribir un correo", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Se debe escribir una contraseña", Toast.LENGTH_SHORT).show();
            return;

        }
        if (passwordConf.equals(password))
        {
            RegistrarUsuario();

        }else{
            AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
            myAlert.setMessage("La contraseña proporcionada y la contraseña de confirmación son diferentes");
            myAlert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog titulo = myAlert.create();
            titulo.setTitle("Error en la contraseña");
            titulo.show();
        }
    }


    private void RegistrarUsuario() {
            progressDialog.setMessage("Realizando Registro en línea");
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(correo, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {

                        Toast.makeText(RegistroUsuario.this, "Se ha registrado, por favor verifique el correo de verificación", Toast.LENGTH_SHORT).show();
                        FirebaseUser user = mAuth.getCurrentUser();
                        user.sendEmailVerification();

                    } else {
                        if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                            Toast.makeText(RegistroUsuario.this, "Ese usuario ya existe inicie sesión", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegistroUsuario.this, "No se pudo registrar el usuario o el correo no existe", Toast.LENGTH_SHORT).show();
                        }

                    }
                    progressDialog.dismiss();

                }
            });

    }


}

