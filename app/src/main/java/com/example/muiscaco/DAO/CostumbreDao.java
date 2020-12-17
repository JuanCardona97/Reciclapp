package com.example.muiscaco.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.muiscaco.models.Costumbre;

import java.util.ArrayList;

public class CostumbreDao {
    private  DataBaseOpenHelper dataBaseOpenHelper;
    private SQLiteDatabase db;

    public CostumbreDao(Context context){
        dataBaseOpenHelper = new DataBaseOpenHelper(context);
        db = dataBaseOpenHelper.getWritableDatabase();
    }


    public ArrayList<Costumbre> consultarCostumbres(){

        ArrayList<Costumbre> costumbres = new ArrayList<Costumbre>();
        Cursor cursor= db.rawQuery(UtilitiesDataBase.TablaCostumbre.CONSULTAR_ALL_TABLE,null);
        while (cursor.moveToNext()){
            costumbres.add(new Costumbre(cursor.getInt(0), cursor.getString(1), cursor.getString(2),cursor.getInt(3)));
        }

        db.close();

        return costumbres;
    }
}
