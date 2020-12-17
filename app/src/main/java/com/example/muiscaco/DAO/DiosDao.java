package com.example.muiscaco.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.muiscaco.models.Dios;

import java.util.ArrayList;

public class DiosDao {

    private  DataBaseOpenHelper dataBaseOpenHelper;
    private SQLiteDatabase db;

    public DiosDao(Context context){
        dataBaseOpenHelper = new DataBaseOpenHelper(context);
        db = dataBaseOpenHelper.getWritableDatabase();
    }


    public ArrayList<Dios> consultarDioses(){

        ArrayList<Dios> dioses = new ArrayList<Dios>();
        Cursor cursor= db.rawQuery(UtilitiesDataBase.TablaDios.CONSULTAR_ALL_TABLE,null);
        while (cursor.moveToNext()){
            dioses.add(new Dios(cursor.getInt(0), cursor.getString(1), cursor.getString(2),cursor.getInt(3)));
        }

        db.close();

        return dioses;
    }
}
