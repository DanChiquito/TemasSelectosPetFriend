package myapp.selectos.temas.chico.pet_friend;

import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class actividades extends AppCompatActivity implements View.OnClickListener {

    ImageView imvFotoMascota;
    TextView txtvNombre;
    EditText edtComer;
    EditText edtBañar;
    TextView edtfechavet;
    TextView edthoravet;
    EditText edtdirecvet;
    TextView edtfechavac;
    TextView edthoravac;
    EditText edtdirecvac;
    Button btnGuardar;
    int diavet,mesvet,añovet,horavet,minutosvet,diavac,mesvac,añovac,horavac,minutosvac;
    private PendingIntent pendingIntent;
    private final static String CHANNEL_ID="NOTIFICACIÓN";
    private final static int NOTIFICACION_ID=0;

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

        //OBTENER FECHA Y HORA ACTUAL

        Date date = new Date();
        SimpleDateFormat diaAct=new SimpleDateFormat("dd");
        String diaActual= diaAct.format(date);
        SimpleDateFormat mesAct=new SimpleDateFormat("MM");
        String mesActual= mesAct.format(date);
        SimpleDateFormat añoAct=new SimpleDateFormat("yyyy");
        String añoActual= añoAct.format(date);
        SimpleDateFormat horaAct=new SimpleDateFormat("HH");
        String horaActual= horaAct.format(date);
        SimpleDateFormat minutosAct=new SimpleDateFormat("mm");
        String minutosActual= minutosAct.format(date);
        txtvNombre.setText(horaActual);
      //



       // int horas_comer= Integer.parseInt(edtComer.getText().toString());
        //int horas_bañar=Integer.parseInt(edtBañar.getText().toString());
        String direccionVet= edtdirecvet.getText().toString();
        String direccionVac=edtdirecvac.getText().toString();
        int FechaVet[]={diavet,mesvet,añovet};

    }

    public void onClickListener(View v)
    {

        if(v==edtfechavet)
        {
            final Calendar calendar= Calendar.getInstance();
            diavet= calendar.get(Calendar.DAY_OF_MONTH);
            mesvet=calendar.get(Calendar.MONTH);
            añovet=calendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    edtfechavet.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
            ,diavet,mesvet,añovet);
            datePickerDialog.show();
        }
        if(v==edthoravet)
        {
            final Calendar calendar= Calendar.getInstance();
            horavet= calendar.get(Calendar.HOUR_OF_DAY);
            minutosvet=calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    edthoravet.setText(hourOfDay+":"+minute);
                }
            },horavet,minutosvet,false);
            timePickerDialog.show();
        }

        if(v==edtfechavac)
        {
            final Calendar calendar= Calendar.getInstance();
            diavac= calendar.get(Calendar.DAY_OF_MONTH);
            mesvac=calendar.get(Calendar.MONTH);
            añovac=calendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    edtfechavac.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
                    ,diavac,mesvac,añovac);
            datePickerDialog.show();
        }
        if(v==edthoravac)
        {
            final Calendar calendar= Calendar.getInstance();
            horavac= calendar.get(Calendar.HOUR_OF_DAY);
            minutosvac =calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    edthoravac.setText(hourOfDay+":"+minute);
                }
            },horavac,minutosvac,false);
            timePickerDialog.show();
        }
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

    @Override
    public void onClick(View v) {

    }
}
