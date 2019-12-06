/*
 * Copyright (c) 2019. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package com.hitesh_sahu.retailapp.view.activities;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hitesh_sahu.retailapp.R;
import com.hitesh_sahu.retailapp.model.entities.Medico;
import com.hitesh_sahu.retailapp.util.Constantes;
import com.hitesh_sahu.retailapp.util.JsonPlaceHolderApi;
import com.squareup.picasso.Picasso;

import org.apache.http.annotation.NotThreadSafe;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleActivity extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvDni;
    private TextView tvDireccion;
    private TextView tvCelular;
    private TextView tvMail;
    private TextView tvCarac;
    private TextView tvCarac1;
    private Button btnAdd;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        tvNombre = (TextView) findViewById(R.id.nombre);
        tvDni = (TextView) findViewById(R.id.dni);
        tvMail = (TextView) findViewById(R.id.mail);
        tvDireccion = (TextView) findViewById(R.id.direccion);
        tvCelular = (TextView) findViewById(R.id.celular);
        tvCarac = (TextView) findViewById(R.id.caracteristica);
        tvCarac1 = (TextView) findViewById(R.id.caracteristica1);
        //btnAdd = (Button) findViewById(R.id.btnaddDeseo);
        imageView = (ImageView) findViewById(R.id.imageViewDetail);

       cargarDatos();

        /* EVENTO AGREGAR A LA LISTA */
       /*btnAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getBaseContext(),RegistroActivity.class);
               startActivity(intent);
               Toast.makeText(getApplication(),"Esta es una prueba de conexion de red",Toast.LENGTH_LONG).show();
           }
       });
*/
    }

    public void cargarDatos(){
        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("nombre");
        Log.e("Data", nombre);
        JsonPlaceHolderApi postService = Constantes.getRetrofitNombre().create(JsonPlaceHolderApi.class);
        Call<List<Medico>> call = postService.getPost(nombre);
        call.enqueue(new Callback<List<Medico>>() {
            @Override
            public void onResponse(Call<List<Medico>> call, Response<List<Medico>> response) {
                String paht = "";
                String modify = "";
                for (Medico m :  response.body()){

                    tvNombre.setText(m.getNomDoctor());
                    tvDni.setText(m.getDniDoctor());
                    tvMail.setText(m.getEmailDoctor());
                    tvDireccion.setText(m.getDirDoctor());
                    tvCelular.setText(m.getTelDoctor());
                    tvCarac.setText(m.getCaracteristica1());
                    tvCarac1.setText(m.getCaracteristica2());
                    paht = m.getImageURL();
                }
                modify = paht.substring(9,24);
                //../Assets/img/team/2.png
                Picasso.with(getApplicationContext()).load(new File("/android_asset"+modify)).into(imageView);
                Log.e("RUTA modify", modify);
            }
            @Override
            public void onFailure(Call<List<Medico>> call, Throwable t) {
            }
        });
    }

}
