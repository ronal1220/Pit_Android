/*
 * Copyright (c) 2019. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package com.hitesh_sahu.retailapp.view.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hitesh_sahu.retailapp.R;
import com.hitesh_sahu.retailapp.model.entities.Client;
import com.hitesh_sahu.retailapp.model.entities.Doctor;
import com.hitesh_sahu.retailapp.util.ReadJsonClient;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout txtEmail, txtPassword;
    private TextInputEditText edtEmail, edtPassword;
    private Button btnLogin ;
    private ProgressDialog pd;
    private String sEmail, sPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        txtEmail= (TextInputLayout) findViewById( R.id.txtEmail );
        txtPassword= (TextInputLayout) findViewById( R.id.txtPassword );
        edtEmail= (TextInputEditText) findViewById( R.id.edtEmail );
        edtPassword= (TextInputEditText) findViewById( R.id.edtPassword );
        btnLogin= (Button) findViewById( R.id.btnLogin );
        pd = new ProgressDialog(this);

        btnLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        } );

    }

    private void Login(){
        sEmail = edtEmail.getText().toString().trim();
        sPassword = edtPassword.getText().toString().trim();
        boolean cancel = false;
        View focus = null;
        if(TextUtils.isEmpty(sEmail)){
            txtEmail.setError( "Email necesario" );
            focus=edtEmail;
            cancel=true;
        }

        if(TextUtils.isEmpty( sPassword )){
            txtPassword.setError( "Contraseña necesaria" );
            focus=edtPassword;
            cancel=true;
        }

        if(cancel){
            focus.requestFocus();
        }
        else{
            new LoginUser().execute();
        }
    }

    private class LoginUser extends AsyncTask<String,Void,Object>
    {
        Client user= null;
        @Override
        protected void onPreExecute() {
            pd.setMessage("Iniciando sesión un momento...");
            pd.setIndeterminate(false);
            pd.setCancelable( false );
            pd.setCanceledOnTouchOutside( false );
            pd.show();
        }

        @Override
        protected Object doInBackground(String... strings) {
            try {
                URL url = new URL("http://www.webapi.somee.com/Api/Cliente/Login");
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                con.setDoOutput(true);
                con.setDoInput(true);
                con.setRequestProperty("Content-Type","application/json; charset-UTF-8");
                con.setRequestProperty("Accept","application/json");
                con.setRequestMethod("POST");

                JSONObject json = new JSONObject();
                json.put("email",sEmail);
                json.put("password",sPassword);


                OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
                wr.write(json.toString());
                wr.flush();

                StringBuilder sb = new StringBuilder();
                int HttpResult = con.getResponseCode();
                if(HttpResult == HttpURLConnection.HTTP_OK){
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(con.getInputStream(), "utf-8"));
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                        user = new ReadJsonClient().ReadClient(line);
                    }
                    br.close();
                }
            } catch (Exception ex) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            if(user!=null) {
                startActivity( new Intent( LoginActivity.this, ECartHomeActivity.class ) );
                getIntent().putExtra("mail",txtEmail.getEditText().getText().toString());
                Toast.makeText( getApplicationContext(), "Bienvenido", Toast.LENGTH_LONG ).show();
            }
            else{
                Toast.makeText(getApplicationContext(),"Cliente no registrado", Toast.LENGTH_SHORT).show();
            }
            pd.dismiss();
        }
    }

    public void fake(View view){
        Intent intent = new Intent(this,ECartHomeActivity.class);
        startActivity(intent);
    }
}
