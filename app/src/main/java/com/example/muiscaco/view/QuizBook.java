package com.example.muiscaco.view;

import com.example.muiscaco.R;

public class QuizBook {
    public static String[] questions = new String [] {
            "¿La recuperación, el transporte y el tratamiento diferenciado de los residuos sólidos hace parte del sistema de reciclaje:?",
            "¿Quién está a cargo la la recolección selectiva de residuos son las empresas prestadoras de servicio público de aseo?",
            "¿El orden del sistema por el cual pasan los residuos reciclables es  centro de almacenaje-clasificación-envio a industrias del reciclaje?",
            "¿La implementación del sistema de gestión integral de residuos sólidos implica  La instalación de equipamientos,La inclusión social de recicladores, alianzas estratégicas,El desarrollo de actitudes y prácticas ciudadanas?",
            "¿Las ciudad que presentan el servicio de aseo con mayor cantidad de residuos sólidos para el año 2013 es Barranquilla.:?",
            "¿Según EMSIRVA en liquidación S.A. E.S.P., muestra que para el año 2013, Santiago de Cali generó mensualmente un promedio de 51.137 ton/mes de basura :?",
            "¿Santiago de Cali como otros 15 municipios, realiza la disposición de residuos sólidos en el Relleno Sanitario Regional Colomba – El Guabal ubicado en el Municipio de Yotoco.?",
            "¿En las instituciones públicas y privadas se debe emplear el color azul para la presentación de los residuos húmedos no reciclables ,cartón, Plástico, vidrio y metales?",
            "¿En las instituciones públicas y privadas se debe emplear el color verde para la presentación de los residuos húmedos no reciclables y los residuos orgánicos como sobras de comida cruda y preparada, residuos de jardín, residuos higiénicos, pañales, papel aluminio, entre otros?",
            "¿Las principales fuentes de generación de residuos son labores de oficina, prácticas deportivas.?",
            "¿Se practica el uso de dos colores para diferenciar la presentación de los residuos reciclables secos de los residuos no reciclables y los orgánicos húmedos, estos colores son azul y verde.?",
            "¿Un slogan de PGIRS es “Separar para reciclar”?",

    };

    public static int[] images;

    public static boolean[] answers;

    static {
        images = new int[]{
                R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4,
                R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8,
                R.drawable.img9, R.drawable.img10, R.drawable.img11, R.drawable.img12
        };
        answers = new boolean[]{
                false, true, true, true, false, true, true, false, true, false, true, true,
        };
    }
}
