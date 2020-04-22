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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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


    /**
     * Soporte para las animaciones
     */
    public ObjectAnimator animatorVictoria;
    public ObjectAnimator animatorDerrota;
    public ObjectAnimator animatorEmpate;



    private static final String DIBUJO = "dibujo";
    private static final String RESUL = "resul";
    ImageView imageFragment, imageEmoji;
    TextView texto;
    String dibujo, resul;
    Fragment frag;

    MediaPlayer mp;



@Override
public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    dibujo = getArguments().getString(DIBUJO);
    resul= getArguments().getString(RESUL);
}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View vista = inflater.inflate(R.layout.fragment_resultado, container, false);
        imageFragment=vista.findViewById(R.id.imageFragment);
        imageEmoji=vista.findViewById(R.id.imageEmoji);
        texto = vista.findViewById(R.id.textView);
        frag = this;

        MostrarDatos(dibujo,vista);
        ColocarResultado(resul);
        ColocarEmoji(resul);

        return vista;
    }

    /**
     * Método para instanciar el fragment pasándole los parámetros correspondientes
     * @param param1
     * @param param2
     * @return fragment
     */
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
            case "El dispositivo está eligiendo":
                MediaPlayer.create(vista.getContext(),R.raw.unmomento).start();
                break;
        }
    }


    /**
     *Método que coloca la animación correspondiente a victoria, derrota, empate (o si la máquina necesita un poco más de tiempo) y la anima.
     * @param resul
     */
    public void ColocarResultado(String resul){
        Animation animacion = AnimationUtils.loadAnimation(getContext(),R.anim.animacion);
        imageFragment.startAnimation(animacion);
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
            case "El dispositivo está eligiendo":
                imageFragment.setImageResource(R.drawable.loading);
                break;
        }

    }

    /**
     * Como quizá haya niños y niñas que no sepan leer, se adjuntan unos emoticonos que representan alegría (felicidad), tristeza (derrota) o impasibilidad(empate)
     * @param resul
     */
    public void ColocarEmoji(String resul){
        switch (resul){
            case "Has ganado":
                imageEmoji.setImageResource(R.drawable.feliz);
                break;
            case "Has perdido":
                imageEmoji.setImageResource(R.drawable.triste);
                break;
            case "Empate":
                imageEmoji.setImageResource(R.drawable.indiferente);
                break;
            case "El dispositivo está eligiendo":
                imageEmoji.setImageResource(R.drawable.indiferente);
                break;
        }

    }


}
