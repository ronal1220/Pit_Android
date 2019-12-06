/*
 * Copyright (c) 2019. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package com.hitesh_sahu.retailapp.util;

import com.hitesh_sahu.retailapp.model.entities.Client;

import org.json.JSONObject;

public class ReadJsonClient {

    public Client ReadClient(String data){
        Client bean=null;
        try {
            JSONObject obj = new JSONObject(data);
            bean = new Client();
            bean.setEmail( obj.getString( "email" ) );
            bean.setPassword( obj.getString( "password" ) );
            bean.setNomCliente( obj.getString( "nomCliente" ) );
            bean.setApeCliente( obj.getString( "apeCliente" ) );
            bean.setDniCliente( obj.getString( "dniCliente" ) );
        }catch (Exception ex){

        }
        return bean;
    }
}
