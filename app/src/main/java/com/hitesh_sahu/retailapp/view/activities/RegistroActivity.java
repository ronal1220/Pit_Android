/*
 * Copyright (c) 2019. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package com.hitesh_sahu.retailapp.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hitesh_sahu.retailapp.R;
import com.hitesh_sahu.retailapp.model.entities.Cliente;
import com.hitesh_sahu.retailapp.util.Constantes;
import com.hitesh_sahu.retailapp.util.JsonPlaceHolderApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private EditText dni;
    private EditText usuario;
    private EditText contrasenia;
    private EditText edad;
    private EditText genero;
    private Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = (EditText) findViewById(R.id.edt_nombre);
        apellido = (EditText) findViewById(R.id.edt_apellido);
        dni = (EditText) findViewById(R.id.edt_dni);
        usuario = (EditText) findViewById(R.id.edt_usuario);
        contrasenia = (EditText) findViewById(R.id.edt_contrasenia);
        edad = (EditText) findViewById(R.id.edt_edad);
        genero = (EditText) findViewById(R.id.edt_genero);
        registrar = (Button) findViewById(R.id.btn_registrar);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                post();
            }
        });
    }

    public void post(){
        String nom = nombre.getText().toString();
        String ape = apellido.getText().toString();
        String doc = dni.getText().toString();
        String usu = usuario.getText().toString();
        String con = contrasenia.getText().toString();
        String eda = edad.getText().toString();
        String gen = genero.getText().toString();

        JsonPlaceHolderApi postService = Constantes.registro().create(JsonPlaceHolderApi.class);
        Cliente cliente = new Cliente(0,nom,ape,Integer.parseInt(doc),usu,con,eda,gen);
       Call<Cliente> call =  postService.postNuevo(cliente);
       call.enqueue(new Callback<Cliente>() {
           @Override
           public void onResponse(Call<Cliente> call, Response<Cliente> response) {
               Log.e("POST",response.message());
           }

           @Override
           public void onFailure(Call<Cliente> call, Throwable t) {

           }
       });

    }
}
