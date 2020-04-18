package com.example.sergiorojo_ejercicioeva_rec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnPiedra, btnPapel, btnTijera;
    TextView txtMarcador;
    ImageView ImgJugador, ImgCPU;
    int JugadorPuntuacion=0;
    int CPUPuntuacion=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPiedra=(Button) findViewById(R.id.btnPiedra);
        btnPapel=(Button) findViewById(R.id.btnPapel);
        btnTijera=(Button) findViewById(R.id.btnTijera);

        txtMarcador=(TextView)findViewById(R.id.txtMarcador);

        ImgJugador=(ImageView)findViewById(R.id.ImgJugador);
        ImgCPU=(ImageView)findViewById(R.id.ImgCPU);

        //método selección piedra
        btnPiedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImgJugador.setImageResource(R.drawable.piedra);
                String mensaje = turno("Piedra"):
                Toast.makeText(MainActivity.this,mensaje,Toast.LENGTH_SHORT).show();
                txtMarcador.setText("Jugador: "+Integer.toString(JugadorPuntuacion)+"CPU: "+Integer.toString(CPUPuntuacion));
            }
        });

        //método selección papel
        btnPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImgJugador.setImageResource(R.drawable.papel);
                String mensaje = turno("Papel");
                Toast.makeText(MainActivity.this,mensaje,Toast.LENGTH_SHORT).show();
                txtMarcador.setText("Jugador: "+Integer.toString(JugadorPuntuacion)+"CPU: "+Integer.toString(CPUPuntuacion));
            }
        });

        //método selección tijera
        btnTijera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImgJugador.setImageResource(R.drawable.tijeras);
                String mensaje = turno("Tijeras"):
                Toast.makeText(MainActivity.this,mensaje,Toast.LENGTH_SHORT).show();
                txtMarcador.setText("Jugador: "+Integer.toString(JugadorPuntuacion)+"CPU: "+Integer.toString(CPUPuntuacion));
            }
        });

    }
    public String turno (String elegido){
        String dispositivo_seleccion="";
        Random r = new Random();

        int dispos_numero=r.nextInt(3) + 1; //3 es es el número de imágenes, el 1 es para aleatorio.

        if (dispos_numero==1){
            dispositivo_seleccion="Piedra";
        }
        else
            if(dispos_numero==2){
                dispositivo_seleccion="Papel";
            }
            else
                if(dispos_numero==3){
                    dispositivo_seleccion="Tijera";
                }


                if (dispositivo_seleccion=="Piedra"{
                    ImgCPU.setImageResource(R.drawable.piedra);
                }
                else
            if (dispositivo_seleccion=="Papel"{
                ImgCPU.setImageResource(R.drawable.papel);
            }else
            if (dispositivo_seleccion=="Tijeras"{
                ImgCPU.setImageResource(R.drawable.tijeras);
            }
            if (dispositivo_seleccion==elegido){
                return "Empatados";
            }
            else if (elegido=="Piedra"&&dispositivo_seleccion=="Tijeras"){
                JugadorPuntuacion++;
                return "Piedra gana a tijera. HAS GANADO.";
            }
            else if (elegido=="Piedra"&&dispositivo_seleccion=="Papel"){
                CPUPuntuacion++;
                return "Papel gana a piedra. HAS PERDIDO.";
            }
            else if (elegido=="Tijeras"&&dispositivo_seleccion=="Piedra"){
                CPUPuntuacion++;
                return "Piedra gana a tijera. HAS PERDIDO.";
            }
            else if (elegido=="Tijeras"&&dispositivo_seleccion=="Papel"){
                JugadorPuntuacion++;
                return "Tijeras gana a papel. HAS Ganado.";
            }
            else if (elegido=="Papel"&&dispositivo_seleccion=="Piedra"){
                JugadorPuntuacion++;
                return "Papel gana a piedra. HAS GANADO.";
            }
            else if (elegido=="Papel"&&dispositivo_seleccion=="Tijeras"){
                CPUPuntuacion++;
                return "Tijeras gana a papel. HAS PERDIDO.";
            }
            else return"No seguro";

    }
}
