/*
 * Copyright (c) 2017. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

/**
 *
 */
package com.hitesh_sahu.retailapp.model.entities;

/**
 * The Class Product used as model for Products.
 *
 * @author Hitesh
 */
public class Product {

    private String idDoctor = "";
    private String nomDoctor = "";
    private String dniDoctor = "";
    private String cmpDoctor = "";
    private String idCategoria = "";
    private String id_Horario = "";
    private String dirDoctor = "";
    private String idDistrito = "";
    private String telDoctor = "";
    private String emailDoctor = "";
    private String Precio="";
    private String PrecioAnterior="";
    private String ImageURL = "";

    private String TextoAlternativo = "";
    private String caracteristica1 = "";
    private String caracteristica2 = "";
    private String caracteristica3 = "";
    private String caracteristica4 = "";
    private String caracteristica5 = "";
    private String caracteristica6 = "";
    private String caracteristica7 = "";
    private String caracteristica8 = "";
    private String Placa = "";
    private String TituloOferta = "";
    private String ClaseDistintaOferta = "";
    private String DescripcionCorta = "";
    private String DescripcionLarga = "";
    private String nota = "";
    private String agregarCarro = "";
    private String porc1 = "";
    private String porc2 = "";
    private String porc3 = "";
    private String porc4 = "";

    public Product(String idDoctor, String nomDoctor, String dniDoctor, String cmpDoctor, String idCategoria, String id_Horario, String dirDoctor, String idDistrito, String telDoctor, String emailDoctor, String precio, String precioAnterior, String imageURL, String textoAlternativo, String caracteristica1, String caracteristica2, String caracteristica3, String caracteristica4, String caracteristica5, String caracteristica6, String caracteristica7, String caracteristica8, String placa, String tituloOferta, String claseDistintaOferta, String descripcionCorta, String descripcionLarga, String nota, String agregarCarro) {
        this.idDoctor = idDoctor;
        this.nomDoctor = nomDoctor;
        this.dniDoctor = dniDoctor;
        this.cmpDoctor = cmpDoctor;
        this.idCategoria = idCategoria;
        this.id_Horario = id_Horario;
        this.dirDoctor = dirDoctor;
        this.idDistrito = idDistrito;
        this.telDoctor = telDoctor;
        this.emailDoctor = emailDoctor;
        this.Precio = precio;
        this.PrecioAnterior = precioAnterior;
        ImageURL = imageURL;
        TextoAlternativo = textoAlternativo;
        this.caracteristica1 = caracteristica1;
        this.caracteristica2 = caracteristica2;
        this.caracteristica3 = caracteristica3;
        this.caracteristica4 = caracteristica4;
        this.caracteristica5 = caracteristica5;
        this.caracteristica6 = caracteristica6;
        this.caracteristica7 = caracteristica7;
        this.caracteristica8 = caracteristica8;
        Placa = placa;
        TituloOferta = tituloOferta;
        ClaseDistintaOferta = claseDistintaOferta;
        DescripcionCorta = descripcionCorta;
        DescripcionLarga = descripcionLarga;
        this.nota = nota;
        this.agregarCarro = agregarCarro;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getPrecioAnterior() {
        return PrecioAnterior;
    }

    public void setPrecioAnterior(String precioAnterior) {
        PrecioAnterior = precioAnterior;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

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

    public String getCmpDoctor() {
        return cmpDoctor;
    }

    public void setCmpDoctor(String cmpDoctor) {
        this.cmpDoctor = cmpDoctor;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getId_Horario() {
        return id_Horario;
    }

    public void setId_Horario(String id_Horario) {
        this.id_Horario = id_Horario;
    }

    public String getDirDoctor() {
        return dirDoctor;
    }

    public void setDirDoctor(String dirDoctor) {
        this.dirDoctor = dirDoctor;
    }

    public String getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(String idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getTelDoctor() {
        return telDoctor;
    }

    public void setTelDoctor(String telDoctor) {
        this.telDoctor = telDoctor;
    }

    public String getEmailDoctor() {
        return emailDoctor;
    }

    public void setEmailDoctor(String emailDoctor) {
        this.emailDoctor = emailDoctor;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public String getTextoAlternativo() {
        return TextoAlternativo;
    }

    public void setTextoAlternativo(String textoAlternativo) {
        TextoAlternativo = textoAlternativo;
    }

    public String getCaracteristica1() {
        return caracteristica1;
    }

    public void setCaracteristica1(String caracteristica1) {
        this.caracteristica1 = caracteristica1;
    }

    public String getCaracteristica2() {
        return caracteristica2;
    }

    public void setCaracteristica2(String caracteristica2) {
        this.caracteristica2 = caracteristica2;
    }

    public String getCaracteristica3() {
        return caracteristica3;
    }

    public void setCaracteristica3(String caracteristica3) {
        this.caracteristica3 = caracteristica3;
    }

    public String getCaracteristica4() {
        return caracteristica4;
    }

    public void setCaracteristica4(String caracteristica4) {
        this.caracteristica4 = caracteristica4;
    }

    public String getCaracteristica5() {
        return caracteristica5;
    }

    public void setCaracteristica5(String caracteristica5) {
        this.caracteristica5 = caracteristica5;
    }

    public String getCaracteristica6() {
        return caracteristica6;
    }

    public void setCaracteristica6(String caracteristica6) {
        this.caracteristica6 = caracteristica6;
    }

    public String getCaracteristica7() {
        return caracteristica7;
    }

    public void setCaracteristica7(String caracteristica7) {
        this.caracteristica7 = caracteristica7;
    }

    public String getCaracteristica8() {
        return caracteristica8;
    }

    public void setCaracteristica8(String caracteristica8) {
        this.caracteristica8 = caracteristica8;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public String getTituloOferta() {
        return TituloOferta;
    }

    public void setTituloOferta(String tituloOferta) {
        TituloOferta = tituloOferta;
    }

    public String getClaseDistintaOferta() {
        return ClaseDistintaOferta;
    }

    public void setClaseDistintaOferta(String claseDistintaOferta) {
        ClaseDistintaOferta = claseDistintaOferta;
    }

    public String getDescripcionCorta() {
        return DescripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        DescripcionCorta = descripcionCorta;
    }

    public String getDescripcionLarga() {
        return DescripcionLarga;
    }

    public void setDescripcionLarga(String descripcionLarga) {
        DescripcionLarga = descripcionLarga;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getAgregarCarro() {
        return agregarCarro;
    }

    public void setAgregarCarro(String agregarCarro) {
        this.agregarCarro = agregarCarro;
    }

    public String getPorc1() {
        return porc1;
    }

    public void setPorc1(String porc1) {
        this.porc1 = porc1;
    }

    public String getPorc2() {
        return porc2;
    }

    public void setPorc2(String porc2) {
        this.porc2 = porc2;
    }

    public String getPorc3() {
        return porc3;
    }

    public void setPorc3(String porc3) {
        this.porc3 = porc3;
    }

    public String getPorc4() {
        return porc4;
    }

    public void setPorc4(String porc4) {
        this.porc4 = porc4;
    }

}
