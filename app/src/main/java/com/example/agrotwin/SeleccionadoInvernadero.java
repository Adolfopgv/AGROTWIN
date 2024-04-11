package com.example.agrotwin;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SeleccionadoInvernadero#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SeleccionadoInvernadero extends Fragment {

    // Iniciando los parametros
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    public SeleccionadoInvernadero() {
        // Required empty public constructor
        ///// TIENE QUE ESTAR VACIO /////
    }

    /**
     * Nueva instancia con los parametros ingresados
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InteriorInvernadero.
     */
    public static SeleccionadoInvernadero newInstance(String param1, String param2) {
        SeleccionadoInvernadero fragment = new SeleccionadoInvernadero();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_interior_invernadero, container, false);

        // la humedad y la temperatura
        humedadYTemperatura(20,20,20, view);

        return view;
    }

    /**
     * Esta funcion pinta por pantalla la humedad del aire, tierra y la temperatura
     * @param humedadAire: La humedad del aire en tiempo real
     * @param humedadTierra: La humedad de la tierra en tiempo real
     * @param temperatura: La temperatura en tiempo real
     * @param view: El xml dela vista del home
     */
    @SuppressLint("SetTextI18n")
    private void humedadYTemperatura(int humedadAire , int humedadTierra, int temperatura, View view) {
        // humedad aire
        TextView textoHumedadAire = view.findViewById(R.id.humedadAire);
        textoHumedadAire.setText(humedadAire+"%");

        // humedad tierra
        TextView textoHumedadTierra = view.findViewById(R.id.humedadTierra);
        textoHumedadTierra.setText(humedadTierra+"%");

        // temperatura
        TextView temperaturaActual = view.findViewById(R.id.temperatura);
        temperaturaActual.setText(temperatura+"Cº");
    }

    /**
     * funcion que imprime las graficas con sus datos
     * @param view: la vista xml donde se van a ver las graficas
     */
}