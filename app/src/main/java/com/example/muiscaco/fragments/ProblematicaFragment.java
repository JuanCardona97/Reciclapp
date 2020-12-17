package com.example.muiscaco.fragments;


import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.muiscaco.DAO.MitoDao;
import com.example.muiscaco.R;
import com.example.muiscaco.models.Mito;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProblematicaFragment extends Fragment{

    private TextView title,description;
    private ImageView image;
    private Button next, before;

    private MitoDao mitoDao;

    private ArrayList<Mito> mitos;

    int fila=0;

    public ProblematicaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mitoDao = new MitoDao(inflater.getContext());
        mitos = new ArrayList<Mito>();
        mitos=mitoDao.consultarMitos();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_problematica, container, false);
    }

    private void cambiarMito(){
        title.setText(mitos.get(fila).getTitle());
        description.setText(mitos.get(fila).getDescritpion());
        image.setImageResource(mitos.get(fila).getImage());
    }

    @Override
    public void onStart() {
        super.onStart();
        View v = getView();

        title = (TextView)v.findViewById(R.id.tvTitle);
        description = (TextView)v.findViewById(R.id.tvDescription);
        image = (ImageView)v.findViewById(R.id.ivImage);
        before = (Button)v.findViewById(R.id.btnAnterior);
        next = (Button)v.findViewById(R.id.btnSiguiente);
        before.setVisibility(View.INVISIBLE);
        description.setMovementMethod(new ScrollingMovementMethod());

        //Mostrar la primera fila
        cambiarMito();



        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fila--;

                if(fila==0){
                    before.setVisibility(View.INVISIBLE);
                    cambiarMito();


                }else{
                    next.setVisibility(View.VISIBLE);

                    cambiarMito();
                }

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fila++;
                if(fila==mitos.size()-1){
                    next.setVisibility(View.INVISIBLE);
                    cambiarMito();

                }
                else{
                    before.setVisibility(View.VISIBLE);

                    cambiarMito();
                }

            }
        });



    }


}
