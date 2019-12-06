/*
 * Copyright (c) 2019. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package com.hitesh_sahu.retailapp.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hitesh_sahu.retailapp.R;
import com.hitesh_sahu.retailapp.model.entities.Doctor;
import com.hitesh_sahu.retailapp.util.Constantes;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.beanDoctor> {

    private List<Doctor> lista;
    private Context context;

    public DoctorAdapter(List<Doctor> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public beanDoctor onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category_list, null, false);
        return new beanDoctor(view);
    }

    @Override
    public void onBindViewHolder(beanDoctor holder, int position) {
        holder.codigo.setText(String.valueOf(lista.get(position).getIdDoctor()));
        holder.nombre.setText(String.valueOf(lista.get(position).getNomDoctor()));
        holder.dni.setText(String.valueOf(lista.get(position).getDniDoctor()));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class beanDoctor extends RecyclerView.ViewHolder{
        TextView codigo;
        TextView nombre;
        TextView dni;

        public beanDoctor(View itemView) {
            super(itemView);
            codigo = (TextView) itemView.findViewById(R.id.item_named);
            nombre = (TextView) itemView.findViewById(R.id.item_short_descd);
            dni = (TextView) itemView.findViewById(R.id.category_discountd);
        }
    }
}
