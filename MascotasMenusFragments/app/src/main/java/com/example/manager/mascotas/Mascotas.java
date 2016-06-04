package com.example.manager.mascotas;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.manager.mascotas.adapter.PageAdapter;
import com.example.manager.mascotas.beans.Mascota;
import com.example.manager.mascotas.fragments.PerfilFragment;
import com.example.manager.mascotas.fragments.RecyclerViewFragment;

import java.util.ArrayList;

public class Mascotas extends AppCompatActivity
{
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ImageView estrella, imgStar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        //estrella = (ImageView) findViewById(R.id.estrella);
        imgStar = (ImageView) findViewById(R.id.imgStar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        /*imgStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mascotas.this, MascotasOrdenadas.class);
                startActivity(i);
                //Log.i("INFOOOOOO::::","Presionado estrella");
            }
        });*/

        setupViewPager();

        if(toolbar != null)
        {
            setSupportActionBar(toolbar);
        }
    }



    public void mascotasOrdenadas()
    {
        //Intent i = new Intent(Mascotas.this, MascotasOrdenadas.class);
        //startActivity(i);

        Log.i("INFOOOOOO::::","Presionado estrella");
    }

    //MENU DE OPCIONES
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.mContacto:
                Intent i = new Intent(this, Contacto.class);
                startActivity(i);
                break;
            case R.id.mAcercaDe:
                Intent in = new Intent(this, AcercaDe.class);
                startActivity(in);
                break;
            default:

        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragment()
    {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setupViewPager()
    {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home_48);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog_48);
    }
}
