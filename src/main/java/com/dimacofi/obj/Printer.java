/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimacofi.obj;

import com.dimacofi.DAO.HibernateUtil;
import com.dimacofi.DAO.Impresora;
import com.dimacofi.DAO.Values;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;

/**
 *
 * @author nvelasquez
 */
public class Printer {

    @JsonProperty("codserie")
    private String codserie;
    @JsonProperty("ip")
    private String ip;
    @JsonProperty("code")
    private Codes code;

    @JsonProperty("val")
    private Values val;

    public Printer(String codserie, Values val) {
        this.codserie = codserie;
        this.val = val;
    }

    /**
     *
     * @param codserie
     * @param ip
     * @param val
     */
    public Printer(String codserie, String ip, Codes val) {
        this.codserie = codserie;
        this.ip = ip;
        this.code = val;
    }

    /**
     *
     */
    public Printer() {
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
    public String getIp() {
        return ip;
    }

    /**
     *
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     *
     * @return
     */
    public Codes getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(Codes code) {
        this.code = code;
    }

    
    //metodos
    
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

        List<Printer> lvalues;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(formatter);

        lvalues = objectMapper.readValue(Json, new TypeReferenceImpl());

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        lvalues.forEach((Printer item) -> {
            Impresora con = (Impresora) session.get(Impresora.class, item.codserie);
            if (con != null) {

                item.val.setImpresora(con);
            }
        });

        for (Printer item : lvalues) {
            Values hvalues = item.val;

            Values ins = (Values) session.merge(hvalues);
            session.save(ins);
        }

        session.getTransaction().commit();
        session.close();
    }

    private static class TypeReferenceImpl extends TypeReference {

        public TypeReferenceImpl() {
        }
    }
}
