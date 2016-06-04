package com.example.manager.mascotas.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manager.mascotas.beans.Mascota;
import com.example.manager.mascotas.adapter.MascotaAdaptador;
import com.example.manager.mascotas.R;

import java.util.ArrayList;

/**
 * Created by manager on 04/06/16.
 */
public class RecyclerViewFragment extends Fragment
{
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvContactos);

        //LayoutManager para el Recycler
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador()
    {
        adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas()
    {
        mascotas = new ArrayList<Mascota>();

        //mascotas.add(new Mascota(R.drawable.perro1,"Pancho", "0"));
        mascotas.add(new Mascota(R.drawable.perro2,"Rita", "3"));
        mascotas.add(new Mascota(R.drawable.perro3,"Fibo", "2"));
        mascotas.add(new Mascota(R.drawable.perro4,"Bruno", "4"));
        mascotas.add(new Mascota(R.drawable.perro5,"Neska", "7"));
        mascotas.add(new Mascota(R.drawable.perro6,"Neska", "2"));
        mascotas.add(new Mascota(R.drawable.perro7,"Neska", "0"));

        //Toast.makeText(this,mascotas.size(),Toast.LENGTH_SHORT).show();
        //Log.i("INDICDOR:::: ", (String)mascotas.size());
    }
}
