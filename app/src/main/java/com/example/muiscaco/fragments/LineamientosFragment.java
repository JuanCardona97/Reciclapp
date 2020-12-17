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

import com.example.muiscaco.DAO.DiosDao;
import com.example.muiscaco.R;
import com.example.muiscaco.models.Dios;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LineamientosFragment extends Fragment{

    private TextView title,description;
    private ImageView image;
    private Button next, before;

    private DiosDao diosDao;

    private ArrayList<Dios> dioses;

    int fila=0;

    public LineamientosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        diosDao = new DiosDao(inflater.getContext());
        dioses = new ArrayList<Dios>();
        dioses =diosDao.consultarDioses();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lineamientos, container, false);
    }

    private void cambiarDios(){
        title.setText(dioses.get(fila).getTitle());
        description.setText(dioses.get(fila).getDescritpion());
        image.setImageResource(dioses.get(fila).getImage());
    }

    @Override
    public void onStart() {
        super.onStart();
        View v = getView();

        title = (TextView)v.findViewById(R.id.tvTitleD);
        description = (TextView)v.findViewById(R.id.tvDescriptionD);
        image = (ImageView)v.findViewById(R.id.ivImageD);
        before = (Button)v.findViewById(R.id.btnAnteriorD);
        next = (Button)v.findViewById(R.id.btnSiguienteD);
        before.setVisibility(View.INVISIBLE);
        description.setMovementMethod(new ScrollingMovementMethod());

        //Mostrar la primera fila
        cambiarDios();



        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fila--;

                if(fila==0){
                    before.setVisibility(View.INVISIBLE);
                    cambiarDios();


                }else{
                    next.setVisibility(View.VISIBLE);

                    cambiarDios();
                }

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fila++;
                if(fila==dioses.size()-1){
                    next.setVisibility(View.INVISIBLE);
                    cambiarDios();

                }
                else{
                    before.setVisibility(View.VISIBLE);

                    cambiarDios();
                }

            }
        });



    }


}
