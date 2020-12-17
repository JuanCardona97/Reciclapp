package com.example.muiscaco.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.muiscaco.models.Laguna;
import com.example.muiscaco.models.Mito;

import java.util.ArrayList;

public class LagunaDao {
    private  DataBaseOpenHelper dataBaseOpenHelper;
    private SQLiteDatabase db;

    public LagunaDao(Context context){
        dataBaseOpenHelper = new DataBaseOpenHelper(context);
        db = dataBaseOpenHelper.getWritableDatabase();
    }


    public long insertarLaguna(Mito laguna){

        ContentValues registro = new ContentValues();
        registro.put(UtilitiesDataBase.TablaLaguna.TABLE_NAMEL, laguna.getTitle());
        registro.put(UtilitiesDataBase.TablaLaguna.TABLE_NAMEL, laguna.getDescritpion());
        registro.put(UtilitiesDataBase.TablaLaguna.TABLE_NAMEL, laguna.getImage());

        long id = db.insert(UtilitiesDataBase.TablaLaguna.TABLE_NAMEL, UtilitiesDataBase.TablaLaguna.ID, registro);

        db.close();
        return id;

    }

    public ArrayList<Laguna> consultarLagunas(){
        ArrayList<Laguna> lagunas = new ArrayList<Laguna>();
        Cursor cursor= db.rawQuery(UtilitiesDataBase.TablaLaguna.CONSULTAR_ALL_TABLE,null);
        while (cursor.moveToNext()){
            lagunas.add(new Laguna(cursor.getInt(0), cursor.getString(1), cursor.getString(2),cursor.getInt(3)));
        }

        db.close();

        return lagunas;
    }
}
