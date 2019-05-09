/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimacofi.ctr;

import com.dimacofi.DAO.HibernateUtil;
import com.dimacofi.DAO.Impresora;
import com.dimacofi.DAO.Values;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author nvelasquez
 */
public class CtrlImpresora {
 
    
    @JsonProperty("codserie")
    private String codserie;

    @JsonProperty("val")
    private Values val;

    public CtrlImpresora(String codserie, Values val) {
        this.codserie = codserie;
        this.val = val;
    }

    public CtrlImpresora() {
    }

 
    
    
    /**
     * <p>
     * Inserta los valores consultados en la impresora
     * a la base de datos
     * </p>
     * @param Json
     * @throws IOException
     */
    public void insertVal(String Json) throws IOException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        List<CtrlImpresora> lvalues;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(formatter);

        lvalues = objectMapper.readValue(Json, new TypeReference<List<CtrlContratosMfp>>() {
        });

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        lvalues.forEach((CtrlImpresora item) -> {
            Impresora con = (Impresora) session.get(Impresora.class, item.codserie);
            if (con != null) {

                item.val.setImpresora(con);
            }
        });

        for (CtrlImpresora item : lvalues) {
            Values hvalues = item.val;

            Values ins = (Values) session.merge(hvalues);
            session.save(ins);
        }

        session.getTransaction().commit();
        session.close();
    }
    
    
     /**
     * <p>
     * Obtiene la informacion de todo
     * el parque de equipos en SAI
     * </p>
     * @return Lista de Json con los valores de un equipo
     * @throws JsonProcessingException
     */
    public String printersAll() throws JsonProcessingException {

        String Json = null;

        ObjectMapper objectMapper = new ObjectMapper();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Impresora> printList = new ArrayList<>();
        printList = session.createCriteria(Impresora.class).list();

        Json = objectMapper.writeValueAsString(printList);

        session.close();

        return Json;

    }
    
     /**
     *<p>
     * Obtiene las propiedades de un equipo
     * por su HH
     * </p>
     * @param hh
     * @return Lista de Json con los valores de un equipo
     * @throws JsonProcessingException
     */
    public String printerData(int hh) throws JsonProcessingException {

        String Json = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(formatter);

        Object imp = session.createCriteria(Impresora.class).add(Restrictions.eq("hh", hh)).setMaxResults(1).uniqueResult();

        Json = objectMapper.writeValueAsString(imp);

        session.close();

        return Json;

    }
    
     /**
     *
     * <p>
     * Obtiene los equipos asociados a un contrato
     * </p>
     * @param con
     * @return
     * @throws JsonProcessingException
     */
    public String obtHhsContrato(int con) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        List<Impresora> impresora = new ArrayList<>();

        impresora =  session.createCriteria(Impresora.class).add(Restrictions.eq("contrato", con)).list();

        String json = objectMapper.writeValueAsString(impresora);

        session.close();

        return json;

    }


}
