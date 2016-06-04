package com.example.manager.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.manager.mascotas.adapter.MascotaAdaptador;
import com.example.manager.mascotas.beans.Mascota;

import java.util.ArrayList;

public class MascotasOrdenadas extends AppCompatActivity
{
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_ordenadas);

        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar2);
        setSupportActionBar(miActionBar);
        miActionBar.setNavigationIcon(R.drawable.ic_action_back);
        miActionBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        //LayoutManager para el Recycler
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador()
    {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas()
    {
        mascotas = new ArrayList<Mascota>();

        //mascotas.add(new Mascota(R.drawable.perro1,"Pancho", "0"));
        mascotas.add(new Mascota(R.drawable.perro4,"Bruno", "5"));
        mascotas.add(new Mascota(R.drawable.perro5,"Neska", "4"));
        mascotas.add(new Mascota(R.drawable.perro7,"Neska", "3"));
        mascotas.add(new Mascota(R.drawable.perro2,"Rita", "2"));
        mascotas.add(new Mascota(R.drawable.perro3,"Fibo", "1"));
        mascotas.add(new Mascota(R.drawable.perro6,"Neska", "0"));


        //Toast.makeText(this,mascotas.size(),Toast.LENGTH_SHORT).show();
        //Log.i("INDICDOR:::: ", (String)mascotas.size());
    }
}
