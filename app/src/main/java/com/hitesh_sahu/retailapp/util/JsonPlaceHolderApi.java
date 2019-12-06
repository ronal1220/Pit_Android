/*
 * Copyright (c) 2019. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package com.hitesh_sahu.retailapp.util;

import com.hitesh_sahu.retailapp.model.entities.Client;
import com.hitesh_sahu.retailapp.model.entities.Cliente;
import com.hitesh_sahu.retailapp.model.entities.ListaDeseo;
import com.hitesh_sahu.retailapp.model.entities.Medico;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    @GET(Constantes.GETLISTA+"/Listado")
    @Headers({"Content-type: application/json"})
    Call<List<Medico>> getLista();

    @GET(Constantes.GETNOMBRE+"{nombre}")
    @Headers({"Content-type: application/json"})
    Call<List<Medico>> getPost(@Path("nombre") String nombre);

    @GET(Constantes.GETDESEO+"{userId}")
    @Headers({"Content-type: application/json"})
    Call<List<ListaDeseo>> getDeseo(@Path("userId") int userId);


    @POST(Constantes.GETREGIS)
    Call<Cliente> postNuevo(@Body Cliente cliente );
    /*
    @Field("nomCliente") String nombre,
            @Field("apeCliente") String apeliido,
            @Field("dniCliente") String dni,
            @Field("usuario") String usuario,
            @Field("contraseña") String contrasenia,
            @Field("edad") int edad,
            @Field("genereo") String genero
     */

}
