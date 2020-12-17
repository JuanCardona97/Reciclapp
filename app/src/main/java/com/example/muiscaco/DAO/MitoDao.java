package com.example.muiscaco.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.muiscaco.models.Mito;

import java.util.ArrayList;

public class MitoDao {

    private  DataBaseOpenHelper dataBaseOpenHelper;
    private SQLiteDatabase db;

    public MitoDao(Context context){
        dataBaseOpenHelper = new DataBaseOpenHelper(context);
        db = dataBaseOpenHelper.getWritableDatabase();
    }


    public long insertarMito(Mito mito){

        ContentValues registro = new ContentValues();
        registro.put(UtilitiesDataBase.TablaMito.TABLE_NAME, mito.getTitle());
        registro.put(UtilitiesDataBase.TablaMito.TABLE_NAME, mito.getDescritpion());
        registro.put(UtilitiesDataBase.TablaMito.TABLE_NAME, mito.getImage());

        long id = db.insert(UtilitiesDataBase.TablaMito.TABLE_NAME, UtilitiesDataBase.TablaMito.ID, registro);

         db.close();
        return id;

    }

    public ArrayList<Mito> consultarMitos(){
        ArrayList<Mito> mitos = new ArrayList<Mito>();
        Cursor cursor= db.rawQuery(UtilitiesDataBase.TablaMito.CONSULTAR_ALL_TABLE,null);
        while (cursor.moveToNext()){
            mitos.add(new Mito(cursor.getInt(0), cursor.getString(1), cursor.getString(2),cursor.getInt(3)));
        }

        db.close();

        return mitos;
    }
}
