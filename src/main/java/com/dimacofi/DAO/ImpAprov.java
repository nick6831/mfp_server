/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimacofi.DAO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author nvelasquez
 */
public class ImpAprov {

    private String codserie;
    private Integer hh;
    private String modelo;
    private String marca;
    private int contrato;
    private String rut;
    private String cliente;


    /**
     *
     */
    public ImpAprov() {
    }

    /**
     *
     * @param codserie
     * @param hh
     * @param modelo
     * @param marca
     * @param contrato
     * @param rut
     * @param cliente
     * @param corte
     */
    public ImpAprov(String codserie, Integer hh, String modelo, String marca, int contrato, String rut, String cliente) {
        this.codserie = codserie;
        this.hh = hh;
        this.modelo = modelo;
        this.marca = marca;
        this.contrato = contrato;
        this.rut = rut;
        this.cliente = cliente;
           }

  
    /**
     *
     * @return
     */
    public String getCodserie() {
        return codserie;
    }

    /**
     *
     * @param codserie
     */
    public void setCodserie(String codserie) {
        this.codserie = codserie;
    }

    /**
     *
     * @return
     */
    public Integer getHh() {
        return hh;
    }

    /**
     *
     * @param hh
     */
    public void setHh(Integer hh) {
        this.hh = hh;
    }

    /**
     *
     * @return
     */
    public String getModelo() {
        return modelo;
    }

    /**
     *
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     *
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     *
     * @return
     */
    public int getContrato() {
        return contrato;
    }

    /**
     *
     * @param contrato
     */
    public void setContrato(int contrato) {
        this.contrato = contrato;
    }

    /**
     *
     * @return
     */
    public String getRut() {
        return rut;
    }

    /**
     *
     * @param rut
     */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     *
     * @return
     */
    public String getCliente() {
        return cliente;
    }

    /**
     *
     * @param cliente
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    //metodos 
    
    //trae la informacion de una impresora
    /**
     * <p>
     * Obtiene una lista de equipos por su marca
     * </p>
     *
     * @param marca debe estar en mayuscula
     * @return Lista de Json con los valores de un equipo
     * @throws JsonProcessingException
     */
    public String printMarca(String marca) throws JsonProcessingException {

        String Json = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(formatter);

        List<ImpAprov> aprov = session.createCriteria(ImpAprov.class)
                .add(Restrictions.eq("marca", marca.toUpperCase())).list();

        Json = objectMapper.writeValueAsString(aprov);

        session.close();

        return Json;

    }

}
