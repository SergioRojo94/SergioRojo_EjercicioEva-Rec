package com.example.sergiorojo_ejercicioeva_rec;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentResultado extends Fragment {
TextView texto;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View vista = inflater.inflate(R.layout.fragment_resultado, container, false);
        texto = vista.findViewById(R.id.textView);
        return vista;
    }

    public void MostrarDatos(String datos){
        texto.setText(datos);
    }
}
