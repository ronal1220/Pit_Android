/*
 * Copyright (c) 2019. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package com.hitesh_sahu.retailapp.model.entities;

public class ListaDeseo {
         private int idListaDeseos;
	     private  int idCliente;
	     private int idDoctor;
	     private String nomDoctor;

    public String getNomDoctor() {
        return nomDoctor;
    }

    public void setNomDoctor(String nomDoctor) {
        this.nomDoctor = nomDoctor;
    }

    public String getDniDoctor() {
        return dniDoctor;
    }

    public void setDniDoctor(String dniDoctor) {
        this.dniDoctor = dniDoctor;
    }

    private String dniDoctor;

    public int getIdListaDeseos() {
        return idListaDeseos;
    }

    public void setIdListaDeseos(int idListaDeseos) {
        this.idListaDeseos = idListaDeseos;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }
}
