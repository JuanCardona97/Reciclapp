package com.example.muiscaco.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.muiscaco.R;

public class DataBaseOpenHelper extends SQLiteOpenHelper {
    public DataBaseOpenHelper(@Nullable Context context) {
        super(context, UtilitiesDataBase.DATABASE_NOMBRE, null, UtilitiesDataBase.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    db.execSQL(UtilitiesDataBase.TablaMito.CREATE_TABLE_MITO);
    db.execSQL(UtilitiesDataBase.TablaDios.CREATE_TABLE_DIOS);
    db.execSQL(UtilitiesDataBase.TablaLaguna.CREATE_TABLE_LAGUNA);
    db.execSQL(UtilitiesDataBase.TablaCostumbre.CREATE_TABLE_COSTUMBRE);

    //Problematica
    insertMito(db,"Problemática", "El crecimiento poblacional e industrial en Colombia ha sido propiciado por patrones políticos, económicos y sociales, lo cual ha contribuido al aumento en las cantidades de residuos sólidos que deben ser recolectados y transportados a una planta de aprovechamiento o al sitio de disposición final o aprovechamiento.",
                R.drawable.mascota);
    insertMito(db, "Problemática", "Según cifras de la Superintendencia de Servicios Públicos Domiciliarios, para el año 2011 se registraron 26.537 ton/día de residuos presentados por los usuarios de las empresas del servicio de aseo, que para el año 2013 aumenta aproximadamente en un 0.7%, cuantificando finalmente 26.723 ton/día.",
                R.drawable.mascota);

    insertMito(db, "Problemática", "Las ciudades que presentan al servicio de aseo mayor cantidad de residuos sólidos para el año 2013 son Bogotá con 5.994,6 ton/día; Medellín, 1.615,7 ton/día; Cali, 1.513,4 ton/día; Barranquilla, 1.248,6 ton/día; Cartagena 909,8 ton/día; y Cúcuta que presenta 602,8 ton/día.",
            R.drawable.mascota);

    insertMito(db, "Problemática", "Datos suministrados por EMSIRVA en liquidación S.A. E.S.P., muestran que para el año 2013, Santiago de Cali generó mensualmente un promedio de 51.137,00 ton/mes; para un total anual de 613.643,96 ton; con una PPC de 0,27 ton/hab.",
            R.drawable.mascota);

    insertMito(db,"Problemática","Santiago de Cali como otros 15 municipios, realiza la disposición de residuos sólidos en el Relleno Sanitario Regional Colomba – El Guabal ubicado en el Municipio de Yotoco.",R.drawable.mascota);



    //Lineaminetos

    insertDios(db,"Lineamientos","Los ciudadanos deben separar los residuos que generan, en su casa y en su lugar de trabajo, presentando los residuos reciclables separados de los residuos no reciclables y los residuos orgánicos que presentan para disposición final al operador del servicio público de aseo.",
            R.drawable.lineamiento1);
    insertDios(db,"Lineamientos"," la separación en la fuente es una de las actividades que hacen parte de la gestión integral de residuos sólidos y es de obligatorio cumplimiento por parte de los generadores de residuos (Decreto 1077 de 2015).",
            R.drawable.lineamiento2);

    insertDios(db,"Lineamientos","La separación en la fuente permite seleccionar y almacenar los residuos en recipientes o contenedores para facilitar su posterior transporte, aprovechamiento, tratamiento o disposición. Esto garantiza la calidad de los residuos aprovechables y facilita su clasificación.",
            R.drawable.mascota);



    //Codigo

        insertLaguna(db,"Código de colores","El PGIRS del municipio de Cali ha definido el uso de dos colores para diferenciar la presentación de los residuos reciclables secos de los residuos no reciclables y los orgánicos húmedos. En las instituciones públicas y privadas se debe emplear dos colores distinguiendo en azul, la presentación de los residuos sólidos reciclables secos: Papel, cartón, Plástico, vidrio y metales."
                ,R.drawable.codigo1);
        insertLaguna(db,"Código de colores","En color verde, la presentación de los residuos húmedos no reciclables y los residuos orgánicos como sobras de comida cruda y preparada, residuos de jardín, residuos higiénicos, pañales, papel aluminio, entre otros."
                ,R.drawable.codigo2);


    //Como pued ayudar

        insertCostumbre(db,"¿Cómo puedo ayudar desde el hogar?","Evitar dejar correr el agua al momento de cepillarse",
                R.drawable.cepillar);
        insertCostumbre(db,"¿Cómo puedo ayudar desde el hogar?","Reducir la capacidad del tanque introduciendo una botella con agua",
                R.drawable.tanque);
        insertCostumbre(db,"¿Cómo puedo ayudar desde el hogar?","No utilizar los desagües para la eliminación de aceites",
                R.drawable.aceite);
        insertCostumbre(db,"¿Cómo puedo ayudar desde el hogar?","Evita mantener abierta la puerta de la nevera.",
                R.drawable.nevera);
        insertCostumbre(db,"¿Cómo puedo ayudar desde el hogar?","Mantén el congelador libre de escarcha.",
                R.drawable.congelador);
        insertCostumbre(db,"¿Cómo puedo ayudar desde el hogar?","Si no va a estar en casa por un tiempo prolongado deja apagada la nevera. No olvides dejar la puerta abierta y colocar una caja de bicarbonato dentro para evitar malos olores.\n",
                R.drawable.desconectar);
        insertCostumbre(db,"¿Cómo puedo ayudar desde el hogar?","Sustituye las lámparas incandescentes y las viejas barras fluorescentes por lámparas de bajo consumo",
                R.drawable.lampara);
        insertCostumbre(db,"¿Cómo puedo ayudar desde el hogar?","No utilices la plancha para una sola prenda.",
                R.drawable.plancha);
        insertCostumbre(db,"¿Cómo puedo ayudar desde el hogar?","Apaga el pc cuando no esté en uso.",
                R.drawable.pc);




    }


    private void insertMito(SQLiteDatabase db, String title, String description, int image){
        ContentValues registro = new ContentValues();
        registro.put(UtilitiesDataBase.TablaMito.TITLE,title);
        registro.put(UtilitiesDataBase.TablaMito.DESCRIPTION,description);
        registro.put(UtilitiesDataBase.TablaMito.IMAGE,image);

        db.insert(UtilitiesDataBase.TablaMito.TABLE_NAME, null, registro);

    }

    private void insertDios(SQLiteDatabase db, String title, String description, int image){
        ContentValues registro = new ContentValues();
        registro.put(UtilitiesDataBase.TablaDios.TITLE,title);
        registro.put(UtilitiesDataBase.TablaDios.DESCRIPTION,description);
        registro.put(UtilitiesDataBase.TablaMito.IMAGE,image);
        db.insert(UtilitiesDataBase.TablaDios.TABLE_NAMED, null, registro);

    }
    private void insertLaguna(SQLiteDatabase db, String title, String description, int image){
        ContentValues registro = new ContentValues();
        registro.put(UtilitiesDataBase.TablaLaguna.TITLE,title);
        registro.put(UtilitiesDataBase.TablaLaguna.DESCRIPTION,description);
        registro.put(UtilitiesDataBase.TablaMito.IMAGE,image);
        db.insert(UtilitiesDataBase.TablaLaguna.TABLE_NAMEL, null, registro);

    }
    private void insertCostumbre(SQLiteDatabase db, String title, String description, int image){
        ContentValues registro = new ContentValues();
        registro.put(UtilitiesDataBase.TablaCostumbre.TITLE,title);
        registro.put(UtilitiesDataBase.TablaCostumbre.DESCRIPTION,description);
        registro.put(UtilitiesDataBase.TablaCostumbre.IMAGE,image);
        db.insert(UtilitiesDataBase.TablaCostumbre.TABLE_NAMEC, null, registro);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
