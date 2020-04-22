package com.example.sergiorojo_ejercicioeva_rec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * @author Sergio Rojo
 * @version
 */
public class MainActivity1 extends AppCompatActivity {

    ImageButton btnNinio;
    ImageButton btnNinia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnNinia=(ImageButton) findViewById(R.id.ibtnNinia);
        btnNinio=(ImageButton) findViewById(R.id.ibtnNinio);


        //método selección niña, lleva a activity_ninia
        btnNinia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), MainActivityNinio.class);
               startActivity(intent);
               setTheme(R.style.niño);
            }
        });

        //método selección niña, lleva a activity_ninia
        btnNinio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivityNinio.class);
                startActivity(intent);
                setTheme(R.style.niña);
            }
        });
    }
}
