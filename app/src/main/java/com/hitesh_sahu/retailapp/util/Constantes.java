/*
 * Copyright (c) 2019. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package com.hitesh_sahu.retailapp.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Constantes {

    private static Retrofit retrofit = null;
    public static final String GETLISTA = "http://www.webapi.somee.com/Api/Medico/";
    public static final String GETNOMBRE = "http://webapi.somee.com/api/medico/listadoPorNombre/";
    public static final String GETDESEO = "http://www.webapi.somee.com/Api/Medico/listadolistadeseo/";
    public static final String GETREGIS = "http://www.webapi.somee.com/Api/Cliente/RegistroCliente/";

    public static Retrofit getConnection() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder().baseUrl(GETLISTA).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

    public static Retrofit getRetrofit() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder().baseUrl(GETDESEO).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

    public static Retrofit getRetrofitNombre() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder().baseUrl(GETNOMBRE).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
    public static Retrofit registro() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder().baseUrl(GETREGIS).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
