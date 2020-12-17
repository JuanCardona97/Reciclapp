package com.example.muiscaco.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muiscaco.Modulos;
import com.example.muiscaco.R;
import com.example.muiscaco.adapters.AdapterModulo;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ArrayList<Modulos> dataSetProducts;
    private RecyclerView recyclerView;



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View vista = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView)vista.findViewById(R.id.rvModulos);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


        dataSetProducts = new ArrayList<Modulos>();
        llenarDataSet();



        AdapterModulo adapterModulo = new AdapterModulo(dataSetProducts, inflater.getContext());



        recyclerView.setAdapter(adapterModulo);


        return vista ;



    }

    private void llenarDataSet(){



        dataSetProducts.add(new Modulos("Problemática de Residuos Sólidos", R.drawable.problematica));
        dataSetProducts.add(new Modulos("Lineamientos para la separación en la fuente en Santiago de Cali", R.drawable.lineamiento));
        dataSetProducts.add(new Modulos("Código de colores", R.drawable.codigo));
        dataSetProducts.add(new Modulos("¿Cómo puedo ayudar desde el hogar?", R.drawable.ayudar));
        dataSetProducts.add(new Modulos("Quiz", R.drawable.juegos));
    }

}
