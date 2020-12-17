package com.example.muiscaco.DAO;

public class UtilitiesDataBase {

    static final String DATABASE_NOMBRE="muisca";
    static final int VERSION =1;

    public class TablaMito{
        static  final  String TABLE_NAME="mito";
        static  final  String ID="id";
        static  final  String TITLE="title";
        static  final  String DESCRIPTION="description";
        static  final  String IMAGE="image";

        static final String CREATE_TABLE_MITO="CREATE TABLE "+ TABLE_NAME+ "( "+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                TITLE+" TEXT, "+DESCRIPTION+" TEXT, "+IMAGE+" INTEGER)";


        static  final   String CONSULTAR_ALL_TABLE="SELECT * FROM "+TABLE_NAME;
    }


    public class TablaDios{
        static  final  String TABLE_NAMED="dios";
        static  final  String ID="id";
        static  final  String TITLE="title";
        static  final  String DESCRIPTION="description";
        static  final  String IMAGE="image";

        static final String CREATE_TABLE_DIOS="CREATE TABLE "+ TABLE_NAMED+ "( "+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                TITLE+" TEXT, "+DESCRIPTION+" TEXT, "+IMAGE+" INTEGER)";


        static  final   String CONSULTAR_ALL_TABLE="SELECT * FROM "+TABLE_NAMED;
    }

    public class TablaLaguna{
        static  final  String TABLE_NAMEL="laguna";
        static  final  String ID="id";
        static  final  String TITLE="title";
        static  final  String DESCRIPTION="description";
        static  final  String IMAGE="image";

        static final String CREATE_TABLE_LAGUNA="CREATE TABLE "+ TABLE_NAMEL+ "( "+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                TITLE+" TEXT, "+DESCRIPTION+" TEXT, "+IMAGE+" INTEGER)";


        static  final   String CONSULTAR_ALL_TABLE="SELECT * FROM "+TABLE_NAMEL;
    }

    public class TablaCostumbre{
        static  final  String TABLE_NAMEC="costumbre";
        static  final  String ID="id";
        static  final  String TITLE="title";
        static  final  String DESCRIPTION="description";
        static  final  String IMAGE="image";

        static final String CREATE_TABLE_COSTUMBRE="CREATE TABLE "+ TABLE_NAMEC+ "( "+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                TITLE+" TEXT, "+DESCRIPTION+" TEXT, "+IMAGE+" INTEGER)";


        static  final   String CONSULTAR_ALL_TABLE="SELECT * FROM "+TABLE_NAMEC;
    }



}
