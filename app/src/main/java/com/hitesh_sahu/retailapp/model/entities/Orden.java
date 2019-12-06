/*
 * Copyright (c) 2019. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package com.hitesh_sahu.retailapp.model.entities;

public class Orden {
    private int idOrden;
    private String idCliente;
    private int idPago;
    private int idDetalleEnvio;
    private  double descuento;
    private String impuestos;
    private int cantidadTotal;
    private String fechaOrden;
    private String fechaEnvio;
    private String enviado;
    private String entregar;
    private String fechaEntrega;
    private String notas;
    private String cancelarOrden;
    private boolean Completo;

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdDetalleEnvio() {
        return idDetalleEnvio;
    }

    public void setIdDetalleEnvio(int idDetalleEnvio) {
        this.idDetalleEnvio = idDetalleEnvio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(String impuestos) {
        this.impuestos = impuestos;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public String getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(String fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getEnviado() {
        return enviado;
    }

    public void setEnviado(String enviado) {
        this.enviado = enviado;
    }

    public String getEntregar() {
        return entregar;
    }

    public void setEntregar(String entregar) {
        this.entregar = entregar;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getCancelarOrden() {
        return cancelarOrden;
    }

    public void setCancelarOrden(String cancelarOrden) {
        this.cancelarOrden = cancelarOrden;
    }

    public boolean isCompleto() {
        return Completo;
    }

    public void setCompleto(boolean completo) {
        Completo = completo;
    }
}
