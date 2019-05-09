/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimacofi.ctr;

import com.dimacofi.DAO.HibernateUtil;
import com.dimacofi.DAO.ImpValues;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author nvelasquez
 */
public class CtrlImpValues {
    
    
     /**
     *<p>
     * consulta en base datos por todos los valores
     * de un equipo por HH
     * </p>
     * @param hh de la maquina
     * @return Lista de Json con los valores de un equipo
     * @throws JsonProcessingException
     */
    public String valHhAll(int hh) throws JsonProcessingException {

        String Json = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        ObjectMapper objectMapper = new ObjectMapper();

        List<ImpValues> lval = new ArrayList<>();

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query q = session.createQuery("from ImpValues where hh = :hh");
        q.setParameter("hh", hh);

        lval = q.list();

        Json = objectMapper.writeValueAsString(lval);

        session.close();

        return Json;
    }
    
        /**
     * <p>
     * Obtiene los equipos cuyos contratos tiene un dia de corte 
     * el dia que se consulta
     * </p>
     * @return Lista de Json con los valores de un equipo
     * @throws JsonProcessingException
     */
    public String contDiaCorteNow() throws JsonProcessingException {

        String json = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(formatter);

        int day = LocalDate.now().getDayOfMonth();

        List<ImpValues> val;

        val = session.createSQLQuery("SELECT DISTINCT ON (hh) * FROM imp_values where corte =" + day + " ORDER BY hh, fecha_muestra desc").addEntity(ImpValues.class).list();

        json = objectMapper.writeValueAsString(val);

        session.close();

        return json;

    }
    
        /**
     *<p>
     *  Entrga los valores de los equipos 
     * que esten en un contrato consultado.
     * </p>
     * @param contrato
     * @return Lista de Json con los valores de un equipo
     * @throws JsonProcessingException
     */
    public String valContrato(int contrato) throws JsonProcessingException {

        String Json = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(formatter);

        List<ImpValues> val;

        val = session.createSQLQuery("SELECT DISTINCT ON (hh) * FROM imp_values where contrato =" + contrato + " ORDER BY hh, fecha_muestra desc").addEntity(ImpValues.class).list();

        Json = objectMapper.writeValueAsString(val);

        session.close();

        return Json;

    }
    
        /**
     *<p>
     * Consulta para la realizacion de la 
     * carga masiva de contadores a SAI
     * via CSV
     * </p>
     * @param contrato
     * @return 
     * @throws JsonProcessingException
     */
    public List<ImpValues> csvSai(int contrato) throws JsonProcessingException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<ImpValues> val;

        val = session.createSQLQuery("SELECT DISTINCT ON (hh) * FROM imp_values where contrato =" + contrato + " ORDER BY hh, fecha_muestra desc").addEntity(ImpValues.class).list();

        session.close();

        return val;

    }
    
    /**
     * <p>
     * obtiene los ultimos valores de un 
     * equipo por su HH
     * </p>
     * @param hh
     * @return Lista de Json con los valores de un equipo
     * @throws ParseException
     * @throws JsonProcessingException
     */
    public String printerValues(int hh) throws ParseException, JsonProcessingException {

        String json = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(formatter);
        List<ImpValues> val;

        val = session.createSQLQuery("SELECT DISTINCT ON (hh) * FROM imp_values where hh =" + hh + " ORDER BY hh, fecha_muestra desc").addEntity(ImpValues.class).list();

        json = objectMapper.writeValueAsString(val);

        session.close();

        return json;

    }
    
    
    /**
     * <p>
     * obtiene el ultimo valor de un equipo
     * por su HH
     * </p>
     * @param hh
     * @return Lista de Json con los valores de un equipo
     * @throws ParseException
     * @throws JsonProcessingException
     */
    public String printerLastValue(int hh) throws ParseException, JsonProcessingException {

        String json = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(formatter);

        ImpValues val;

        val = (ImpValues) session.createSQLQuery("SELECT DISTINCT ON (hh) * FROM imp_values where hh =" + hh + " ORDER BY hh, fecha_muestra desc").addEntity(ImpValues.class).uniqueResult();

        json = objectMapper.writeValueAsString(val);

        session.close();

        return json;

    }
    
    
    /**
     * <p>
     * Obtiene todos los valores de todos los equipos
     * </p>
     * @return Lista de Json con los valores de un equipo
     * @throws JsonProcessingException
     */
    public String impValuesAll() throws JsonProcessingException {

        String Json = null;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(formatter);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<ImpValues> printList = new ArrayList<>();
        printList = session.createCriteria(ImpValues.class).list();

        Json = objectMapper.writeValueAsString(printList);

        session.close();

        return Json;

    }
    
    /**
     *<p>
     * Obtiene los valores de los equipos cuyo contrato
     * tenga un dia de corte consultado.
     * </p>
     * @param dia
     * @return Lista de Json con los valores de un equipo
     * @throws JsonProcessingException
     */
    public String contDiaCorte(int dia) throws JsonProcessingException {

        String json = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(formatter);

        List<ImpValues> val;

        val = session.createSQLQuery("SELECT DISTINCT ON (hh) * FROM imp_values where corte =" + dia + " ORDER BY hh, fecha_muestra desc").addEntity(ImpValues.class).list();

        json = objectMapper.writeValueAsString(val);

        session.close();

        return json;

    }
    
   
    
    
}
