package com.example.muiscaco;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muiscaco.fragments.AyudarFragment;
import com.example.muiscaco.fragments.LineamientosFragment;
import com.example.muiscaco.fragments.HomeFragment;
import com.example.muiscaco.fragments.CodigosFragment;
import com.example.muiscaco.fragments.ProblematicaFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final String EXTRA_TIPO_PRODUCT="tipoProducto";

    private int idTypeProduct;
    private TextView text;
    private ArrayList<Modulos> dataSetProducts;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se obtiene el toolbar, para decir que es la nueva toolbar y tambien
        //para poner el icono del navegationBar
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        //El boton
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_abierto,R.string.nav_cerrada);


        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconSize(80);
        navigationView.setItemIconTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
        navigationView.setItemTextColor(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));

        //navigationView.setItemIconTintList(null);
        //navigationView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));




        /*recyclerView = (RecyclerView)findViewById(R.id.rvModulos);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        dataSetProducts = new ArrayList<Modulos>();
        llenarDataSet();

        recyclerView.setAdapter(new AdapterModulo(dataSetProducts));*/


        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.flFrameLayout, homeFragment).commit();

    }

    /*private void llenarDataSet(){
        dataSetProducts.add(new Modulos("Mitos","Las diferentes mitologias de la cultura Muisca", R.drawable.lineamientos));
        dataSetProducts.add(new Modulos("Ubicación","Las diferentes partes donde se ubicaban", R.drawable.ubicacion));
        dataSetProducts.add(new Modulos("Lagunas","Las diferentes lagunas sagradas", R.drawable.lagunas));
        dataSetProducts.add(new Modulos("Costumbres","Las diferentes costumbres que tenian como comunidad", R.drawable.costumbres));
    }*/

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        Fragment fragment = null;
        Intent intent = null;


        switch (id){
            case R.id.item1:
                fragment = new HomeFragment();
                break;
            case R.id.item2:
                fragment = new ProblematicaFragment();
                break;
            case R.id.item3:
                fragment = new LineamientosFragment();
                break;
            case R.id.item4:
                fragment = new CodigosFragment();

                break;
            case R.id.item5:
                fragment = new AyudarFragment();
                //lagunas
                break;

            case R.id.item6:
                intent = new Intent(this,AlterActivity.class);
                break;


                default:
                    fragment = new HomeFragment();
                    break;
        }

        if(fragment!=null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flFrameLayout,fragment);
            ft.addToBackStack(null);
            //Falta mas investigar que mas se le pone

            ft.commit();
        }else{
            startActivity(intent);
        }

        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        drawerLayout.closeDrawer(GravityCompat.START);


        return true;
    }
}
