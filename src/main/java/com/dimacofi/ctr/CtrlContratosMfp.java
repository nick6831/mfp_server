/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimacofi.ctr;

import com.dimacofi.DAO.ContratosMfp;
import com.dimacofi.DAO.HibernateUtil;
import com.dimacofi.DAO.Historial;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author nvelasquez
 */
public class CtrlContratosMfp {

    /**
     *
     */
    public CtrlContratosMfp() {

    }


    /**
     * <p>
     * obtiene la informacion de un contrato
     * </p>
     *
     * @param con
     * @return
     * @throws JsonProcessingException
     */
    public String obtContrato(int con) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        ContratosMfp contrato = (ContratosMfp) session.createCriteria(ContratosMfp.class).add(Restrictions.eq("contrato", con)).uniqueResult();

        String json = objectMapper.writeValueAsString(contrato);

        session.close();

        return json;

    }
    
    /**
     *<p>
     * Obtiene una lista de clientes.
     * </p>
     * @return Lista de Json con los valores de un equipo
     * @throws JsonProcessingException
     */
    public String CliList() throws JsonProcessingException {

        String json = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(formatter);

        List<String> val;

        val = session.createSQLQuery("SELECT distinct(cliente) FROM contratos_mfp").list();

        json = objectMapper.writeValueAsString(val);

        session.close();

        return json;

    }

}
