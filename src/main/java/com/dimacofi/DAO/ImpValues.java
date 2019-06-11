/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimacofi.DAO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author nvelasquez
 */
public class ImpValues implements java.io.Serializable {

    private int contrato;
    private Integer corte;
    private String rut;
    private String cliente;
    private String codserie;
    private String marca;
    private String modelo;
    private Integer hh;
    private Integer copiaColor;
    private Integer copiaBn;
    private Integer scannerColor;
    private Integer scannerBn;
    private Integer a3Color;
    private Integer b4Color;
    private Integer a3Bn;
    private Integer b4Bn;
    private Integer metro;
    private Integer dupl;
    private Integer imprColor;
    private Integer imprBn;
    private Integer negro;
    private Integer cian;
    private Integer magenta;
    private Integer amarillo;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMuestra;
    private int idValues;

    /**
     *
     */
    public ImpValues() {
    }

    /**
     *
     * @param contrato
     * @param corte
     * @param rut
     * @param cliente
     * @param codserie
     * @param marca
     * @param modelo
     * @param hh
     * @param copiaColor
     * @param copiaBn
     * @param scannerColor
     * @param scannerBn
     * @param a3Color
     * @param b4Color
     * @param a3Bn
     * @param b4Bn
     * @param metro
     * @param dupl
     * @param imprColor
     * @param imprBn
     * @param negro
     * @param cian
     * @param magenta
     * @param amarillo
     * @param fechaMuestra
     * @param idValues
     */
    public ImpValues(int contrato, Integer corte, String rut, String cliente, String codserie, String marca, String modelo, Integer hh, Integer copiaColor, Integer copiaBn, Integer scannerColor, Integer scannerBn, Integer a3Color, Integer b4Color, Integer a3Bn, Integer b4Bn, Integer metro, Integer dupl, Integer imprColor, Integer imprBn, Integer negro, Integer cian, Integer magenta, Integer amarillo, Date fechaMuestra, int idValues) {
        this.contrato = contrato;
        this.corte = corte;
        this.rut = rut;
        this.cliente = cliente;
        this.codserie = codserie;
        this.marca = marca;
        this.modelo = modelo;
        this.hh = hh;
        this.copiaColor = copiaColor;
        this.copiaBn = copiaBn;
        this.scannerColor = scannerColor;
        this.scannerBn = scannerBn;
        this.a3Color = a3Color;
        this.b4Color = b4Color;
        this.a3Bn = a3Bn;
        this.b4Bn = b4Bn;
        this.metro = metro;
        this.dupl = dupl;
        this.imprColor = imprColor;
        this.imprBn = imprBn;
        this.negro = negro;
        this.cian = cian;
        this.magenta = magenta;
        this.amarillo = amarillo;
        this.fechaMuestra = fechaMuestra;
        this.idValues = idValues;
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
    public Integer getCorte() {
        return corte;
    }

    /**
     *
     * @param corte
     */
    public void setCorte(Integer corte) {
        this.corte = corte;
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
    public Integer getCopiaColor() {
        return copiaColor;
    }

    /**
     *
     * @param copiaColor
     */
    public void setCopiaColor(Integer copiaColor) {
        this.copiaColor = copiaColor;
    }

    /**
     *
     * @return
     */
    public Integer getCopiaBn() {
        return copiaBn;
    }

    /**
     *
     * @param copiaBn
     */
    public void setCopiaBn(Integer copiaBn) {
        this.copiaBn = copiaBn;
    }

    /**
     *
     * @return
     */
    public Integer getScannerColor() {
        return scannerColor;
    }

    /**
     *
     * @param scannerColor
     */
    public void setScannerColor(Integer scannerColor) {
        this.scannerColor = scannerColor;
    }

    /**
     *
     * @return
     */
    public Integer getScannerBn() {
        return scannerBn;
    }

    /**
     *
     * @param scannerBn
     */
    public void setScannerBn(Integer scannerBn) {
        this.scannerBn = scannerBn;
    }

    /**
     *
     * @return
     */
    public Integer getA3Color() {
        return a3Color;
    }

    /**
     *
     * @param a3Color
     */
    public void setA3Color(Integer a3Color) {
        this.a3Color = a3Color;
    }

    /**
     *
     * @return
     */
    public Integer getB4Color() {
        return b4Color;
    }

    /**
     *
     * @param b4Color
     */
    public void setB4Color(Integer b4Color) {
        this.b4Color = b4Color;
    }

    /**
     *
     * @return
     */
    public Integer getA3Bn() {
        return a3Bn;
    }

    /**
     *
     * @param a3Bn
     */
    public void setA3Bn(Integer a3Bn) {
        this.a3Bn = a3Bn;
    }

    /**
     *
     * @return
     */
    public Integer getB4Bn() {
        return b4Bn;
    }

    /**
     *
     * @param b4Bn
     */
    public void setB4Bn(Integer b4Bn) {
        this.b4Bn = b4Bn;
    }

    /**
     *
     * @return
     */
    public Integer getMetro() {
        return metro;
    }

    /**
     *
     * @param metro
     */
    public void setMetro(Integer metro) {
        this.metro = metro;
    }

    /**
     *
     * @return
     */
    public Integer getDupl() {
        return dupl;
    }

    /**
     *
     * @param dupl
     */
    public void setDupl(Integer dupl) {
        this.dupl = dupl;
    }

    /**
     *
     * @return
     */
    public Integer getImprColor() {
        return imprColor;
    }

    /**
     *
     * @param imprColor
     */
    public void setImprColor(Integer imprColor) {
        this.imprColor = imprColor;
    }

    /**
     *
     * @return
     */
    public Integer getImprBn() {
        return imprBn;
    }

    /**
     *
     * @param imprBn
     */
    public void setImprBn(Integer imprBn) {
        this.imprBn = imprBn;
    }

    /**
     *
     * @return
     */
    public Integer getNegro() {
        return negro;
    }

    /**
     *
     * @param negro
     */
    public void setNegro(Integer negro) {
        this.negro = negro;
    }

    /**
     *
     * @return
     */
    public Integer getCian() {
        return cian;
    }

    /**
     *
     * @param cian
     */
    public void setCian(Integer cian) {
        this.cian = cian;
    }

    /**
     *
     * @return
     */
    public Integer getMagenta() {
        return magenta;
    }

    /**
     *
     * @param magenta
     */
    public void setMagenta(Integer magenta) {
        this.magenta = magenta;
    }

    /**
     *
     * @return
     */
    public Integer getAmarillo() {
        return amarillo;
    }

    /**
     *
     * @param amarillo
     */
    public void setAmarillo(Integer amarillo) {
        this.amarillo = amarillo;
    }

    /**
     *
     * @return
     */
    public Date getFechaMuestra() {
        return fechaMuestra;
    }

    /**
     *
     * @param fechaMuestra
     */
    public void setFechaMuestra(Date fechaMuestra) {
        this.fechaMuestra = fechaMuestra;
    }

    /**
     *
     * @return
     */
    public int getIdValues() {
        return idValues;
    }

    /**
     *
     * @param idValues
     */
    public void setIdValues(int idValues) {
        this.idValues = idValues;
    }
    

    
    
    //metodos
    
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
    
   /**
     *<p>
     * Obtiene los valores de los equipos por rut de cliente.
     * </p>
     * @param rut
     * @return Lista de Json con los valores de un equipo
     * @throws JsonProcessingException
     */
    public String conRut(String rut) throws JsonProcessingException {

        String json = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(formatter);

        List<ImpValues> val;

        val = session.createSQLQuery("SELECT DISTINCT ON (hh) * FROM imp_values where rut ='" + rut + "' ORDER BY hh, fecha_muestra desc").addEntity(ImpValues.class).list();

        json = objectMapper.writeValueAsString(val);

        session.close();

        return json;

    }
    
    
     /**
     *<p>
     * Obtiene los valores de los equipos por nombre cliente.
     * </p>
     * @param cliente
     * @return Lista de Json con los valores de un equipo
     * @throws JsonProcessingException
     */
    public String conCli(String cliente) throws JsonProcessingException {

        String json = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(formatter);

        List<ImpValues> val;

        val = session.createSQLQuery("SELECT DISTINCT ON (hh) * FROM imp_values where cliente ='" + cliente + "' ORDER BY hh, fecha_muestra desc").addEntity(ImpValues.class).list();

        json = objectMapper.writeValueAsString(val);

        session.close();

        return json;

    }
    
}
