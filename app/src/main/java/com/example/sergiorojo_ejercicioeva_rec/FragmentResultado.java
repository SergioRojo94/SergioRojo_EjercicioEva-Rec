package com.example.sergiorojo_ejercicioeva_rec;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;

import androidx.annotation.Nullable;
import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Clase Java del fragmento
 * @author Sergio Rojo
 * @version 1.0
 */
public class FragmentResultado extends Fragment {


    //Soporte para las animaciones
    public ObjectAnimator animatorVictoria;
    public ObjectAnimator animatorDerrota;
    public ObjectAnimator animatorEmpate;

   //Button btnPiedra, btnPapel, btnTijera;

    private static final String DIBUJO = "dibujo";
    private static final String RESUL = "resul";
    ImageView imageFragment;
    TextView texto;
    String dibujo, resul;
    Fragment frag;



  /*  int sonidoPapel, sonidoPiedra, sonidoTijeras;
    SoundPool tonos;*/

    MediaPlayer mp;



@Override
public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    dibujo = getArguments().getString(DIBUJO);
    resul= getArguments().getString(RESUL);
}
   // @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View vista = inflater.inflate(R.layout.fragment_resultado, container, false);
        imageFragment=vista.findViewById(R.id.imageFragment);
        texto = vista.findViewById(R.id.textView);
        frag = this;

        MostrarDatos(dibujo,vista);
        ColocarResultado(resul);

       // btnPiedra=(Button)vista.findViewById(R.id.btnPiedra);
       // btnPapel=(Button)vista.findViewById(R.id.btnPapel);
       // btnTijera=(Button)vista.findViewById(R.id.btnTijera);

        //sonidos
      /* SoundPool.Builder constructor = new SoundPool.Builder();
        constructor.setMaxStreams(3);
        tonos = constructor.build();

        sonidoPapel = tonos.load(vista.getContext(), sonidoPapel, 1);
        sonidoPiedra = tonos.load(vista.getContext(), sonidoPiedra, 1);
        sonidoTijeras = tonos.load(vista.getContext(), sonidoTijeras, 1);*/







      // btnPapel.setEnabled(false);
        //btnPiedra.setEnabled(false);
       // btnTijera.setEnabled(false);





        return vista;
    }

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_resultado, container, false);

        imgBtnOk = view.findViewById(R.id.imgBtnOk);
        f = this;

         imgBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JuegoActivity.frgManager.beginTransaction().remove(f).commit();
            }
        });

         return view;
    }*/

    public static FragmentResultado newInstance(String param1, String param2) {
        FragmentResultado fragment = new FragmentResultado();
        Bundle args = new Bundle();
        args.putString(DIBUJO, param1);
        args.putString(RESUL, param2);
        fragment.setArguments(args);
        return fragment;
    }
    /**
     * Muestra el resultado del juego en forma de String
     * @param datos
     */
    public void MostrarDatos(String datos, View vista){
        texto.setText(datos);
        switch (datos){
            case "Piedra":
                MediaPlayer.create(vista.getContext(),R.raw.sonidopiedra).start();
                break;
            case "Papel":
                MediaPlayer.create(vista.getContext(),R.raw.sonidopapel).start();
                break;
            case "Tijeras":
                MediaPlayer.create(vista.getContext(),R.raw.sonidotijeras).start();
                break;
        }
    }

   /* mppapel =
    mppiedra =
    mptijeras = */
    /**
     *
     * @param resul
     */
    public void ColocarResultado(String resul){
        switch (resul){
            case "Has ganado":
                imageFragment.setImageResource(R.drawable.victoria);
                break;
            case "Has perdido":
                imageFragment.setImageResource(R.drawable.derrota);
                break;
            case "Empate":
                imageFragment.setImageResource(R.drawable.empate);
                break;
        }

    }


}
