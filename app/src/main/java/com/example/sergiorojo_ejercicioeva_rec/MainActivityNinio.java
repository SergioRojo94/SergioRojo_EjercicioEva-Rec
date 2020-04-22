package com.example.sergiorojo_ejercicioeva_rec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.text.Layout;

import android.animation.ObjectAnimator;
import android.app.FragmentManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Actividad donde se juega
 * @author Sergio Rojo
 * @version 1.0
 */
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
    ConstraintLayout lay;
    String sexoo;

    private Fragment  resultado;
    public static FragmentManager frgManager;

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

        lay =(ConstraintLayout)findViewById(R.id.layoutid);

        sexoo = getIntent().getStringExtra("genero");

        genero(sexoo);

        /**
         * método void onClick para la piedra
         *
         */

        btnPiedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImgJugador.setImageResource(R.drawable.piedra);
              turno("Piedra");
                txtMarcador.setText("Jugador: "+Integer.toString(JugadorPuntuacion)+"CPU: "+Integer.toString(CPUPuntuacion) + " ||  Partidas Jugadas: " +Integer.toString(partidasJugadas));
                txtMarcador2.setText("Racha de victorias actual: " +Integer.toString(rachaVictoria)+ " || Mejor racha: "+Integer.toString(mejorRacha));
                habilitarBtn(true);

            }
        });

        /**
         * método void onClick para la papel
         *
         */
        btnPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImgJugador.setImageResource(R.drawable.papel);
                turno("Papel");
                txtMarcador.setText("Jugador: "+Integer.toString(JugadorPuntuacion)+"CPU: "+Integer.toString(CPUPuntuacion) + " ||  Partidas Jugadas: " +Integer.toString(partidasJugadas));
                txtMarcador2.setText("Racha de victorias actual: " +Integer.toString(rachaVictoria)+ " || Mejor racha: "+Integer.toString(mejorRacha));
                habilitarBtn(true);

            }
        });

        /**
         * método void onClick para la tijera
         *
         */



        btnTijera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImgJugador.setImageResource(R.drawable.tijeras);
                turno("Tijeras");
                txtMarcador.setText("Jugador: "+Integer.toString(JugadorPuntuacion)+"CPU: "+Integer.toString(CPUPuntuacion) + " ||  Partidas Jugadas: " +Integer.toString(partidasJugadas));
                txtMarcador2.setText("Racha de victorias actual: " +Integer.toString(rachaVictoria)+ " || Mejor racha: "+Integer.toString(mejorRacha));
                habilitarBtn(true);

            }
        });

    }

    /**
     * Método de control dle juego, instanciamos los componentes y asociamos los botones que pulsa a un String (piedra, papel, tijera)
     *Contiene else-if calculando todas las posibilidades de resultado (9 en este caso).  Vamos incrementando el número de derrotas y victorias, así como el número de victorias de la CPU
     * El fragmento declarado como resultado llama a los métodos 'Mostrartexto' y 'ColocarResultados', donde se les pasa como parámetro un String "texto" con el resultado
     *
     * @param elegido
     * @return String texto
     */



    public void turno (String elegido){
        String dispositivo_seleccion="";
        String resulFinal = null;
        Random r = new Random();
        //FragmentResultado resultado = (FragmentResultado) getSupportFragmentManager().findFragmentById(R.id.fragmentResult);

        String texto;
        Animation animacion = AnimationUtils.loadAnimation(this,R.anim.animacion);
        ImgJugador.startAnimation(animacion);

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
                resulFinal= "Empate";

            }
            else if (elegido=="Piedra"&&dispositivo_seleccion=="Tijeras"){
                partidasJugadas++;
                JugadorPuntuacion++;
                rachaVictoria++;
                victoria(rachaVictoria);
                resulFinal= "Has ganado";

            }
            else if (elegido=="Piedra"&&dispositivo_seleccion=="Papel"){
                partidasJugadas++;
                CPUPuntuacion++;
                rachaVictoria=0;
                resulFinal= "Has perdido";
            }
            else if (elegido=="Tijeras"&&dispositivo_seleccion=="Piedra"){
                partidasJugadas++;
                CPUPuntuacion++;
                rachaVictoria=0;
                resulFinal= "Has perdido";

            }
            else if (elegido=="Tijeras"&&dispositivo_seleccion=="Papel"){
                partidasJugadas++;
                JugadorPuntuacion++;
                rachaVictoria++;
                victoria(rachaVictoria);
                resulFinal= "Has ganado";
            }
            else if (elegido=="Papel"&&dispositivo_seleccion=="Piedra"){
                partidasJugadas++;
                JugadorPuntuacion++;
                rachaVictoria++;
                victoria(rachaVictoria);
                resulFinal= "Has ganado";
            }
            else if (elegido=="Papel"&&dispositivo_seleccion=="Tijeras"){
                partidasJugadas++;
                CPUPuntuacion++;
                rachaVictoria=0;
                resulFinal= "Has perdido";

            }
    else resulFinal="El dispositivo está eligiendo";

        resultado = new FragmentResultado().newInstance(elegido,resulFinal);
        frgManager = getFragmentManager();
        FragmentTransaction t = frgManager.beginTransaction();
        t.add(R.id.layoutid, resultado);
        t.commit();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                getFragmentManager().beginTransaction().remove(resultado).commit();
                habilitarBtn(false);
                //resultado=null; //para evitar salir
            }
        }, 2500);
    }

    public void genero(String gen){
        if (gen.equals("chico")){
            lay.setBackgroundColor(Color.parseColor("#54A8FB"));
        }
        else{
            lay.setBackgroundColor(Color.parseColor("#ff0080"));
        }
    }

    public void habilitarBtn(boolean bloqueo){
        if (bloqueo == true){
            btnPapel.setEnabled(false);
            btnPiedra.setEnabled(false);
            btnTijera.setEnabled(false);
        }
        else{
            btnPapel.setEnabled(true);
            btnPiedra.setEnabled(true);
            btnTijera.setEnabled(true);
        }
    }

   @Override //evita que cuando pretes flecha atras se cierre la app
    public void onBackPressed(){
        if(!(resultado instanceof FragmentResultado) ){
            finish(); //si pretas a la flecha finalzia la actividad vovliendo a la actividad principal
        }
    }

    /**
     * metodo que checkea la mejor racha, le pasamos como parámetro la racha de victoria actual y en caso de que sea mayor ésta pasar a aser la mejor racha
     * @param v
     */
    public void victoria(int v){
        if (v > mejorRacha){
            mejorRacha=v;
        }
    }


}
