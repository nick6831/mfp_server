/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimacofi.ctr;

import com.dimacofi.DAO.HibernateUtil;
import com.dimacofi.DAO.Historial;
import com.dimacofi.DAO.MfpDispAprov;
import com.dimacofi.obj.Codes;
import com.dimacofi.obj.Printer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author nvelasquez
 */
public class CtrlMfpDispAprov {

    public CtrlMfpDispAprov() {
    }
   
    
    
    //trae los ultimos valores de una impresora
    /**
     * <p>
     * Obtiene todos los equipos que se estan monitoreando
     * </p>
     *
     * @return Lista de Json con los valores de un equipo
     * @throws JsonProcessingException
     */
    public String aprovAll() throws JsonProcessingException {

        String Json = null;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(formatter);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<MfpDispAprov> printList = new ArrayList<>();
        printList = session.createCriteria(MfpDispAprov.class).list();

        Json = objectMapper.writeValueAsString(printList);

        session.close();

        return Json;

    }

     /**
     * <p>
     * envia un Json con la configuracion para monitorear equipos segun la
     * direccion Mac del dispositivo de monitoreo
     * </p>
     *
     * @param mac
     * @return Json con la lista de HH a monitorear y sys MIBs
     * @throws JsonProcessingException
     */
    public String sendConfig(String mac) throws JsonProcessingException {

        String Json = null;

        ObjectMapper objectMapper = new ObjectMapper();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<MfpDispAprov> aprov = session.createCriteria(MfpDispAprov.class)
                .add(Restrictions.eq("mac", mac)).list();
        List<Printer> printList = new ArrayList<>();

        for (MfpDispAprov item : aprov) {

            Codes cod = new Codes(item.getCopiaColor(), item.getCopiaBn(), item.getScannerColor(), item.getScannerBn(), item.getA3Color(), item.getB4Color(), item.getA3Bn(), item.getB4Bn(), item.getMetro(), item.getDupl(), item.getNegro(), item.getCian(), item.getMagenta(), item.getAmarillo(), item.getImprColor(), item.getImprBn(), item.getNegroMax(), item.getNegroAct(), item.getCianMax(), item.getCianAct(), item.getMagentaMax(), item.getMagentaAct(), item.getAmarilloMax(), item.getAmarilloAct());
            Printer print = new Printer(item.getCodserie(), item.getIpImp(), cod);

            printList.add(print);
        }

        Json = objectMapper.writeValueAsString(printList);

        session.close();

        return Json;

    }
    
        /**
     * <p>
     * Ingresa un registro en la base de datos solo si se reporta que el
     * dispositivo queda correctamente configurado
     * </p>
     *
     * @param mac
     * @throws ParseException
     */
    public void validator(String mac) throws ParseException {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Historial his = new Historial(mac, "Ingresado OK", timestamp);

        session.merge(his);

        session.getTransaction().commit();

        session.close();

    }
}
