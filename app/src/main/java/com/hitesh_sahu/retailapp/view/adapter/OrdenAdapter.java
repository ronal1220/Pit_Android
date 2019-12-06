/*
 * Copyright (c) 2019. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package com.hitesh_sahu.retailapp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hitesh_sahu.retailapp.R;
import com.hitesh_sahu.retailapp.model.entities.Orden;

import java.util.ArrayList;

public class OrdenAdapter extends BaseAdapter {

    ArrayList<Orden> listado;
    Context contexto;

    public OrdenAdapter(ArrayList<Orden> pListaServicio, Context ctx){
        listado = pListaServicio;
        contexto = ctx;
    }

    @Override
    public int getCount() {
        return listado.size();
    }

    @Override
    public Object getItem(int i) {
        return listado.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista= null;
        LayoutInflater inflater=(LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        vista = inflater.inflate(R.layout.frag_product_category,viewGroup,false);
        TextView tvRazonSocial,tvRucCliente,tvCodigoCliente;
        /*/tvRazonSocial = (TextView) vista.findViewById(R.id.tv_detalle1);
        tvRucCliente = (TextView) vista.findViewById(R.id.tv_detalle2);
        tvCodigoCliente= (TextView) vista.findViewById(R.id.tv_detalle3);

        tvRazonSocial.setText(listado.get(i).getIdCliente());
        tvRucCliente.setText(listado.get(i).getFechaOrden());
        tvCodigoCliente.setText(String.valueOf(listado.get(i).getIdOrden()));*/

        return vista;
    }
}

