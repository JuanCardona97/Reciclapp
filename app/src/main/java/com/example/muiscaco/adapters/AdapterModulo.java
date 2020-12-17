package com.example.muiscaco.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muiscaco.AlterActivity;
import com.example.muiscaco.Modulos;
import com.example.muiscaco.R;
import com.example.muiscaco.fragments.AyudarFragment;
import com.example.muiscaco.fragments.LineamientosFragment;
import com.example.muiscaco.fragments.HomeFragment;
import com.example.muiscaco.fragments.CodigosFragment;
import com.example.muiscaco.fragments.ProblematicaFragment;

import java.util.ArrayList;

public class AdapterModulo extends RecyclerView.Adapter<AdapterModulo.ViewHolderCVModulo>  {

    private ArrayList<Modulos> dataSet;
    private Context contexto;




    public AdapterModulo(ArrayList<Modulos> datos, Context c){
        dataSet=datos;
        contexto=c;

    }

    @NonNull
    @Override
    public ViewHolderCVModulo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_modulos,parent,false);
        contexto=v.getContext();



        return new ViewHolderCVModulo(v);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCVModulo holder, final int position) {
        final Modulos modulo = dataSet.get(position);
        holder.ivProduct.setImageResource(modulo.idResource);
        holder.titleProduct.setText(modulo.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity)v.getContext();
                Fragment fragment = null;
                Intent intent;


                switch (position){
                    case 0:
                        fragment = new ProblematicaFragment();
                        break;
                    case 1:
                        fragment = new LineamientosFragment();
                        break;
                    case 2:
                        fragment = new CodigosFragment();
                        break;
                    case 3:
                        fragment = new AyudarFragment();
                        break;
                    case 4:

                        intent = new Intent(contexto, AlterActivity.class);
                        contexto.startActivity(intent);
                        break;

                    default:
                        fragment = new HomeFragment();
                        break;
                }

                if(fragment!=null){
                    FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.flFrameLayout,fragment);
                    ft.addToBackStack(null);
                    //Falta mas investigar que mas se le pone
                    ft.commit();
                }

                /*if(position==1){
                    AppCompatActivity activity = (AppCompatActivity)v.getContext();
                    UbicacionFragment blankFragment3 = new UbicacionFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.flFrameLayout,blankFragment3).addToBackStack(null).commit();

                }*/

            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    public static class ViewHolderCVModulo extends RecyclerView.ViewHolder{
        private ImageView ivProduct;
        private TextView titleProduct;

        public ViewHolderCVModulo(View view){
            super(view);
            ivProduct = (ImageView)view.findViewById((R.id.ivCvProduct));
            titleProduct = (TextView)view.findViewById((R.id.tvTitleProduct));
        }
    }
}
