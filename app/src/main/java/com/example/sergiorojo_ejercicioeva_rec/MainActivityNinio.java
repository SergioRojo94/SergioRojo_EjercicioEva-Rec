package com.example.sergiorojo_ejercicioeva_rec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivityNinio extends AppCompatActivity {

    Button btnPiedra, btnPapel, btnTijera;
    TextView txtMarcador,txtMarcador2;
    ImageView ImgJugador, ImgCPU;
    int JugadorPuntuacion=0;
    int CPUPuntuacion=0;
    int partidasJugadas=0;
    int rachaVictoria=0;
    int mejorRacha=0;
    boolean victoria = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPiedra=(Button) findViewById(R.id.btnPiedra);
        btnPapel=(Button) findViewById(R.id.btnPapel);
        btnTijera=(Button) findViewById(R.id.btnTijera);

        txtMarcador=(TextView)findViewById(R.id.txtMarcador);
        txtMarcador2=(TextView)findViewById(R.id.txtMarcador2);

        ImgJugador=(ImageView)findViewById(R.id.ImgJugador);
        ImgCPU=(ImageView)findViewById(R.id.ImgCPU);

        //método selección piedra
        btnPiedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImgJugador.setImageResource(R.drawable.piedra);
                String mensaje = turno("Piedra");
                //Toast.makeText(MainActivityNinio.this,mensaje,Toast.LENGTH_SHORT).show();
                txtMarcador.setText("Jugador: "+Integer.toString(JugadorPuntuacion)+"CPU: "+Integer.toString(CPUPuntuacion) + " ||  Partidas Jugadas: " +Integer.toString(partidasJugadas));
                txtMarcador2.setText("Racha de victorias actual: " +Integer.toString(rachaVictoria)+ " || Mejor racha: "+Integer.toString(mejorRacha));
            }
        });

        //método selección papel
        btnPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImgJugador.setImageResource(R.drawable.papel);
                String mensaje = turno("Papel");
               // Toast.makeText(MainActivityNinio.this,mensaje,Toast.LENGTH_SHORT).show();
                txtMarcador.setText("Jugador: "+Integer.toString(JugadorPuntuacion)+"CPU: "+Integer.toString(CPUPuntuacion) + " ||  Partidas Jugadas: " +Integer.toString(partidasJugadas));
                txtMarcador2.setText("Racha de victorias actual: " +Integer.toString(rachaVictoria)+ " || Mejor racha: "+Integer.toString(mejorRacha));
            }
        });

        //método selección tijera
        btnTijera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImgJugador.setImageResource(R.drawable.tijeras);
                String mensaje = turno("Tijeras");
                //Toast.makeText(MainActivityNinio.this,mensaje,Toast.LENGTH_SHORT).show();
                txtMarcador.setText("Jugador: "+Integer.toString(JugadorPuntuacion)+"CPU: "+Integer.toString(CPUPuntuacion) + " ||  Partidas Jugadas: " +Integer.toString(partidasJugadas));
                txtMarcador2.setText("Racha de victorias actual: " +Integer.toString(rachaVictoria)+ " || Mejor racha: "+Integer.toString(mejorRacha));
            }
        });

    }
    public String turno (String elegido){
        String dispositivo_seleccion="";
        Random r = new Random();
        FragmentResultado resultado = (FragmentResultado) getSupportFragmentManager().findFragmentById(R.id.fragmentResult);
        String texto;

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


                if (dispositivo_seleccion=="Piedra"){
                    ImgCPU.setImageResource(R.drawable.piedra);
                }
                else
            if (dispositivo_seleccion=="Papel"){
                ImgCPU.setImageResource(R.drawable.papel);
            }else
            if (dispositivo_seleccion=="Tijeras"){
                ImgCPU.setImageResource(R.drawable.tijeras);
            }
            if (dispositivo_seleccion==elegido){
                partidasJugadas++;
                rachaVictoria=0;
                texto= "Empatados";
                resultado.MostrarDatos(texto);
                return texto;

            }
            else if (elegido=="Piedra"&&dispositivo_seleccion=="Tijeras"){
                partidasJugadas++;
                JugadorPuntuacion++;
                rachaVictoria++;
                victoria(rachaVictoria);
                texto = "Piedra gana a tijera. HAS GANADO.";
                resultado.MostrarDatos(texto);
                return texto;
            }
            else if (elegido=="Piedra"&&dispositivo_seleccion=="Papel"){
                partidasJugadas++;
                CPUPuntuacion++;
                rachaVictoria=0;
                texto= "Papel gana a piedra. HAS PERDIDO.";
                resultado.MostrarDatos(texto);
                return texto;
            }
            else if (elegido=="Tijeras"&&dispositivo_seleccion=="Piedra"){
                partidasJugadas++;
                CPUPuntuacion++;
                rachaVictoria=0;
                texto= "Piedra gana a tijera. HAS PERDIDO.";
                resultado.MostrarDatos(texto);
                return texto;
            }
            else if (elegido=="Tijeras"&&dispositivo_seleccion=="Papel"){
                partidasJugadas++;
                JugadorPuntuacion++;
                rachaVictoria++;
                victoria(rachaVictoria);
                texto= "Tijeras gana a papel. HAS Ganado.";
                resultado.MostrarDatos(texto);
                return texto;
            }
            else if (elegido=="Papel"&&dispositivo_seleccion=="Piedra"){
                partidasJugadas++;
                JugadorPuntuacion++;
                rachaVictoria++;
                victoria(rachaVictoria);
                texto= "Papel gana a piedra. HAS GANADO.";
                resultado.MostrarDatos(texto);
                return texto;
            }
            else if (elegido=="Papel"&&dispositivo_seleccion=="Tijeras"){
                partidasJugadas++;
                CPUPuntuacion++;
                rachaVictoria=0;
                texto= "Tijeras gana a papel. HAS PERDIDO.";
                resultado.MostrarDatos(texto);
                return texto;
            }
    else texto="El dispositivo está eligiendo";
        resultado.MostrarDatos(texto);
        return texto;
    }
    public void victoria(int v){
        if (v > mejorRacha){
            mejorRacha=v;
        }
    }
}
