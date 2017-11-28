package ni.edu.unan.aventura_pirata;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        ImageButton btnRepresentamos = (ImageButton)findViewById(R.id.btn_representamos);
        btnRepresentamos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goRepresentamos();
            }
        });
    }
    public void goRepresentamos(){
        Intent intent =new Intent(this, SplashRepresentaActivity.class);
        startActivity(intent);
    }
    public void goEjemplo(View view){
        Intent intent = new Intent(this, EjemploActivity.class);
        startActivity(intent);
    }

}
