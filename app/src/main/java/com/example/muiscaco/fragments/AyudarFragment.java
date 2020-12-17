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

import com.example.muiscaco.DAO.CostumbreDao;
import com.example.muiscaco.R;
import com.example.muiscaco.models.Costumbre;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AyudarFragment extends Fragment {

    private TextView title,description;
    private ImageView image;
    private Button next, before;

    private CostumbreDao costumbreDao;

    private ArrayList<Costumbre> costumbres;

    int fila=0;

    public AyudarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        costumbreDao = new CostumbreDao(inflater.getContext());
        costumbres = new ArrayList<Costumbre>();
        costumbres =costumbreDao.consultarCostumbres();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ayudar, container, false);
    }

    private void cambiarCostumbres(){
        title.setText(costumbres.get(fila).getTitle());
        description.setText(costumbres.get(fila).getDescritpion());
        image.setImageResource(costumbres.get(fila).getImage());
    }

    @Override
    public void onStart() {
        super.onStart();
        View v = getView();

        title = (TextView)v.findViewById(R.id.tvTitleC);
        description = (TextView)v.findViewById(R.id.tvDescriptionC);
        image = (ImageView)v.findViewById(R.id.ivImageC);
        before = (Button)v.findViewById(R.id.btnAnteriorC);
        next = (Button)v.findViewById(R.id.btnSiguienteC);
        description.setMovementMethod(new ScrollingMovementMethod());
        before.setVisibility(View.INVISIBLE);

        //Mostrar la primera fila
        cambiarCostumbres();



        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fila--;

                if(fila==0){
                    before.setVisibility(View.INVISIBLE);
                    cambiarCostumbres();


                }else{
                    next.setVisibility(View.VISIBLE);

                    cambiarCostumbres();
                }

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fila++;
                if(fila==costumbres.size()-1){
                    next.setVisibility(View.INVISIBLE);
                    cambiarCostumbres();

                }
                else{
                    before.setVisibility(View.VISIBLE);

                    cambiarCostumbres();
                }

            }
        });



    }

}
