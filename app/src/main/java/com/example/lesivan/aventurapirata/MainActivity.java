package com.example.lesivan.aventurapirata;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }


    }
    public void goMenu(View view){
        Intent intent = new Intent(this, Menu_Activity.class);
        startActivity(intent);
    }

    public void goTeoria(View view){
        Intent intent = new Intent(this, Teoria_Activity.class);
        startActivity(intent);
    }
}
