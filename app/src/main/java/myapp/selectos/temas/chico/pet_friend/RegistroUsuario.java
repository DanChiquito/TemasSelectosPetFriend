package myapp.selectos.temas.chico.pet_friend;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;

public class RegistroUsuario extends AppCompatActivity{

    private Spinner spnDia;
    private Spinner spnMes;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private String correo;
    private String password;
    private String nombre;
    private String passwordConf;
    private EditText edtNomUsuario;
    private EditText edtCorreoIng;
    private EditText edtNewPassword;
    private EditText edtPassConf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        edtCorreoIng = findViewById(R.id.edtCorreoIng);
        edtNomUsuario = findViewById(R.id.edtNombreUsuario);
        edtNewPassword = findViewById(R.id.edtNewPassword);
        edtPassConf = findViewById(R.id.edtConPass);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        setContentView(R.layout.activity_registro_usuario);


    }

    private void RegistrarUsuario()
    {
        correo = edtCorreoIng.getText().toString().trim();
        password = edtNewPassword.getText().toString().trim();

        if (TextUtils.isEmpty(correo))
        {
            Toast.makeText(this, "se debe escribir un correo",Toast.LENGTH_LONG).show();
        }
    }

