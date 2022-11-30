/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinal;

import java.sql.Date;


public class DTOHistorial implements DTOGeneral {
protected int id;
protected String usuario, mensaje, receptor;

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public DTOHistorial(int id, String usuario, String mensaje, String receptor, Date fecha) {
        this.id = id;
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.receptor = receptor;
        this.fecha = fecha;
    }
protected Date fecha;

    public DTOHistorial(int id, String usuario,String mensaje, Date fecha) {
        this.id = id;
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

  
}
