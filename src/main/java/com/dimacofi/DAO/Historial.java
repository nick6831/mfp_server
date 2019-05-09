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

    /**
     *
     */
    public Historial() {
    }

    /**
     *
     * @param mac
     * @param descripcion
     * @param fecha
     */
    public Historial( String mac, String descripcion, Timestamp fecha) {
        
        this.mac = mac;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    /**
     *
     * @return
     */
    public int getIdHistorial() {
        return idHistorial;
    }

    /**
     *
     * @param idHistorial
     */
    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    /**
     *
     * @return
     */
    public String getMac() {
        return mac;
    }

    /**
     *
     * @param mac
     */
    public void setMac(String mac) {
        this.mac = mac;
    }

    /**
     *
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return
     */
    public Timestamp getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

   
    
    
    
    
}
