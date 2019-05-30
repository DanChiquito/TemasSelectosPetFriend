package myapp.selectos.temas.chico.pet_friend;

import android.app.ProgressDialog;
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
import com.google.firebase.auth.FirebaseUser;

public class RegistroUsuario extends AppCompatActivity {

    private static final String TAG = "" ;
    private ProgressDialog progressDialog;
    private String correo;
    private String password;
    private String nombre;
    private String passwordConf;
    private EditText edtNomUsuario;
    private EditText edtCorreoIng;
    private EditText edtNewPassword;
    private EditText edtPassConf;
    private Button btnSiguiente;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        edtCorreoIng = findViewById(R.id.edtCorreoIng);
        edtNomUsuario = findViewById(R.id.edtNombreUsuario);
        edtNewPassword = findViewById(R.id.edtNewPassword);
        edtPassConf = findViewById(R.id.edtConPass);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        progressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
    }





    private void RegistrarUsuario() {
        correo = edtCorreoIng.getText().toString().trim();
        password = edtNewPassword.getText().toString().trim();

        if (TextUtils.isEmpty(correo)) {
            Toast.makeText(this, "Se debe escribir un correo", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Se debe escribir una contraseña", Toast.LENGTH_SHORT).show();
        }
        progressDialog.setMessage("Realizando Registro en línea");
        progressDialog.show();

        mAuth.createUserWithEmailAndPassword(correo, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

            }
        });

    }





}

