package ni.edu.unan.aventura_pirata;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import ni.edu.unan.aventura_pirata.datos.FraccionDatos;
import ni.edu.unan.aventura_pirata.modelo.RepresentamosPregunta;

public class RepresentamosActivity extends AppCompatActivity {

    List<RepresentamosPregunta> preguntas;
    TextView tvDenominador;
    EditText etNumerador;
    ImageView ivFraccion;
    ImageButton btnSiguiente;
    int actualIndex = 0;
    RepresentamosPregunta actual;
    protected int life =0;
    protected ImageView[] lifes = new ImageView[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_representamos);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        preguntas = FraccionDatos.getDatos(getAssets());

        Collections.shuffle(preguntas);

        actual = preguntas.get(actualIndex);

        etNumerador = (EditText)findViewById(R.id.et_numerador);
        ivFraccion = (ImageView)findViewById(R.id.iv_fraccion);
        tvDenominador = (TextView)findViewById(R.id.tv_denominador);
        btnSiguiente = (ImageButton)findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguiente(view);
            }
        });
        mostrar();
        loadLifes();
    }
    protected void loadLifes(){
        lifes[0] = (ImageView)findViewById(R.id.life1);
        lifes[1] = (ImageView)findViewById(R.id.life2);
        lifes[2] = (ImageView)findViewById(R.id.life3);
    }
    protected boolean reduceLifes(){
        if(life<=2)
            lifes[life].setVisibility(View.INVISIBLE);
        life++;
        return life < 3;
    }
    public void mostrar(){
        int resID = getResources().getIdentifier("img"+actual.getId() , "drawable", getPackageName());
        etNumerador.setText("");
        ivFraccion.setImageResource(resID);
        tvDenominador.setText(actual.getDenominador()+"");
    }
    public boolean validar(){
        return !etNumerador.getText().toString().equals("") && actual.getRespuesta() == Integer.parseInt(etNumerador.getText().toString());
    }
    public void anterior(View view){
        if(actualIndex > 0){
            actualIndex--;
            actual = preguntas.get(actualIndex);
            mostrar();
        }
    }
    public void siguiente(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Representamos");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        if(etNumerador.getText().toString().equals(""))
        {
            builder.setMessage("Por favor ingrese una respuesta");
            AlertDialog alert = builder.create();
            alert.show();
            return;
        }
        if(!etNumerador.getText().toString().matches("\\d+")){
            builder.setMessage("Por favor ingrese solo numeros");
            AlertDialog alert = builder.create();
            alert.show();
            return;
        }
        if(validar()){
            builder.setMessage("Correcto");
            AlertDialog alert = builder.create();

            alert.show();
            if(actualIndex < preguntas.size() - 1){
                actualIndex++;
                actual = preguntas.get(actualIndex);
                mostrar();
            }else{
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
            }
        }else{
            builder.setMessage("Incorrecto");
            AlertDialog alert = builder.create();
            alert.show();
            if(reduceLifes()){
                if(actualIndex < preguntas.size() - 1){
                    actualIndex++;
                    actual = preguntas.get(actualIndex);
                    mostrar();
                }else{
                    Intent intent = new Intent(this, MenuActivity.class);
                    startActivity(intent);
                }
            }else{
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
            }

        }
    }
    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }
}
