/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimacofi.ctr;

import com.dimacofi.DAO.HibernateUtil;
import com.dimacofi.DAO.Historial;
import com.dimacofi.DAO.ImpValues;
import com.dimacofi.DAO.Impresora;
import com.dimacofi.DAO.MfpDispAprov;
import com.dimacofi.DAO.MonitorDevice;
import com.dimacofi.DAO.Values;
import com.dimacofi.obj.Codes;
import com.dimacofi.obj.Printer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author nvelasquez
 */
public class Controller {

    @JsonProperty("codserie")
    private String codserie;

    @JsonProperty("val")
    private Values val;

    public Controller(String codserie, Values val) {
        this.codserie = codserie;
        this.val = val;
    }

    public Controller() {

    }

    public void insertVal(String Json) throws IOException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        List<Controller> lvalues;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(formatter);

        lvalues = objectMapper.readValue(Json, new TypeReference<List<Controller>>() {
        });

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        lvalues.forEach((Controller item) -> {
            Impresora con = (Impresora) session.get(Impresora.class, item.codserie);
            if (con != null) {

                item.val.setImpresora(con);

            }
        });

        for (Controller item : lvalues) {
            Values hvalues = item.val;

            session.save(hvalues);
        }

        session.getTransaction().commit();

    }

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

        return Json;
    }

    public String toDay(int day) throws ParseException {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -day);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted;
        formatted = format1.format(cal.getTime());

        return formatted;

    }

    public String contDiaCorteNow() throws JsonProcessingException {

        String Json = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        ObjectMapper objectMapper = new ObjectMapper();

        int day = LocalDate.now().getDayOfMonth();

        List<ImpValues> lval = new ArrayList<>();

        Query q2 = session.createQuery("from ContratosMfp where corte = :day ");
        q2.setParameter("day", day);

        if (!q2.list().isEmpty()) {

            int dia = 0;
            do {

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, dia);
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                String formatted;
                formatted = format1.format(cal.getTime());

                Query q = session.createQuery("from ImpValues where  corte = :day  and fechaMuestra between'" + formatted + " 00:00:00' and '" + formatted + " 24:00:00'");
                q.setParameter("day", day);

                lval = q.list();

                dia--;

            } while (lval.isEmpty());

            Json = objectMapper.writeValueAsString(lval);
        }

        return Json;

    }

    public String contDiaCorte(int dia) throws JsonProcessingException {

        String Json = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        ObjectMapper objectMapper = new ObjectMapper();

        List<ImpValues> lval = new ArrayList<>();

        Query q2 = session.createQuery("from ContratosMfp where corte = :day ");
        q2.setParameter("day", dia);

        int dias = 0;
        if (!q2.list().isEmpty()) {
            do {

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, dias);
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                String formatted;
                formatted = format1.format(cal.getTime());

                Query q = session.createQuery("from ImpValues where  corte = :day  and fechaMuestra between'" + formatted + " 00:00:00' and '" + formatted + " 24:00:00'");
                q.setParameter("day", dia);

                lval = q.list();
                dias--;

            } while (lval.isEmpty());

            Json = objectMapper.writeValueAsString(lval);
        }
        return Json;

    }

    public String valContrato(int contrato) throws JsonProcessingException {

        String Json = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        ObjectMapper objectMapper = new ObjectMapper();

        List<ImpValues> lval = new ArrayList<>();

        int dias = 0;

        do {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, dias);
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String formatted;
            formatted = format1.format(cal.getTime());

            Query q = session.createQuery("from ImpValues where contrato = :contrato and fechaMuestra between'" + formatted + " 00:00:00' and '" + formatted + " 24:00:00'");
            q.setParameter("contrato", contrato);

            lval = q.list();

            dias--;

        } while (lval.isEmpty());

        Json = objectMapper.writeValueAsString(lval);

        return Json;

    }

    public List<ImpValues> csvSai(int contrato) throws JsonProcessingException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<ImpValues> lval = new ArrayList<>();

        int dias = 0;

        do {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, dias);
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String formatted;
            formatted = format1.format(cal.getTime());

            Query q = session.createQuery("from ImpValues where contrato = :contrato and fechaMuestra between'" + formatted + " 00:00:00' and '" + formatted + " 24:00:00'");
            q.setParameter("contrato", contrato);

            lval = q.list();

            dias--;

        } while (lval.isEmpty());

        return lval;

    }

    public String printerData(int hh) throws JsonProcessingException {

        String Json = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        ObjectMapper objectMapper = new ObjectMapper();

        Object imp = session.createCriteria(Impresora.class).add(Restrictions.eq("hh", hh)).setMaxResults(1).uniqueResult();

        Json = objectMapper.writeValueAsString(imp);

        return Json;

    }
    
    public String printersAll() throws JsonProcessingException{
        
         String Json = null;
         
         ObjectMapper objectMapper = new ObjectMapper();
        
         Session session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         
         List<Impresora> printList = new ArrayList<>();
         printList = session.createCriteria(Impresora.class).list();
         
         Json = objectMapper.writeValueAsString(printList);
         
         return Json;
        
    }
    
    
     public String impValuesAll() throws JsonProcessingException{
        
         String Json = null;
         
         ObjectMapper objectMapper = new ObjectMapper();
        
         Session session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         
         List<ImpValues> printList = new ArrayList<>();
         printList = session.createCriteria(ImpValues.class).list();
         
         Json = objectMapper.writeValueAsString(printList);
         
         return Json;
        
    }
     
     
     
      public String aprovAll() throws JsonProcessingException{
        
         String Json = null;
         
         ObjectMapper objectMapper = new ObjectMapper();
        
         Session session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         
         List<MfpDispAprov> printList = new ArrayList<>();
         printList = session.createCriteria(MfpDispAprov.class).list();
         
         Json = objectMapper.writeValueAsString(printList);
         
         return Json;
        
    }
    
    
    

    

    public String sendConfig(String mac) throws JsonProcessingException {

        String Json = null;

        ObjectMapper objectMapper = new ObjectMapper();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<MfpDispAprov> aprov = session.createCriteria(MfpDispAprov.class)
                .add(Restrictions.eq("mac", mac)).list();
        List<Printer> printList = new ArrayList<>();

        for (MfpDispAprov item : aprov) {

            Codes cod = new Codes(item.getCopiaColor(), item.getCopiaBn(), item.getScannerColor(), item.getScannerBn(), item.getA3Color(), item.getB4Color(), item.getA3Bn(), item.getB4Bn(), item.getMetro(), item.getDupl(),item.getNegro(),item.getCian(),item.getMagenta(),item.getAmarillo(),item.getImprColor(),item.getImprBn());
            Printer print = new Printer(item.getCodserie(), item.getIpImp(), cod);

            printList.add(print);
        }

        Json = objectMapper.writeValueAsString(printList);

        return Json;

    }

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
