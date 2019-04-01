/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimacofi.DAO;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nvelasquez
 */
public class Historial {
    
    private int idHistorial;
    private String mac;
    private String descripcion;
   
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp  fecha;

    public Historial() {
    }

    public Historial( String mac, String descripcion, Timestamp fecha) {
        
        this.mac = mac;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

   
    
    
    
    
}
