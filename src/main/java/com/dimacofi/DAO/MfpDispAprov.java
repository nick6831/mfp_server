/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimacofi.DAO;

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
public class MfpDispAprov implements java.io.Serializable {

    private String mac;
    private String ipImp, ipDevice,marca;
    private short type;
    private String descEstado;
    private String codserie;
    private Integer hh;
    private int contrato;
    private String nomModel;
    private String copiaColor;
    private String copiaBn;
    private String scannerColor;
    private String scannerBn;
    private String a3Color;
    private String b4Color;
    private String a3Bn;
    private String b4Bn;
    private String metro;
    private String dupl;
    private String negro;
    private String cian;
    private String magenta;
    private String amarillo;
    private String imprColor;
    private String imprBn;
    private String negroMax;
    private String negroAct;
    private String cianMax;
    private String cianAct;
    private String magentaMax;
    private String magentaAct;
    private String amarilloMax;
    private String amarilloAct;

    /**
     *
     */
    public MfpDispAprov() {
    }

    /**
     *
     * @param mac
     * @param ipImp
     * @param ipDevice
     * @param marca
     * @param type
     * @param descEstado
     * @param codserie
     * @param hh
     * @param contrato
     * @param nomModel
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
     * @param negro
     * @param cian
     * @param magenta
     * @param amarillo
     * @param imprColor
     * @param imprBn
     * @param negroMax
     * @param negroAct
     * @param cianMax
     * @param cianAct
     * @param magentaMax
     * @param magentaAct
     * @param amarilloMax
     * @param amarilloAct
     */
    public MfpDispAprov(String mac, String ipImp, String ipDevice, String marca, short type, String descEstado, String codserie, Integer hh, int contrato, String nomModel, String copiaColor, String copiaBn, String scannerColor, String scannerBn, String a3Color, String b4Color, String a3Bn, String b4Bn, String metro, String dupl, String negro, String cian, String magenta, String amarillo, String imprColor, String imprBn, String negroMax, String negroAct, String cianMax, String cianAct, String magentaMax, String magentaAct, String amarilloMax, String amarilloAct) {
        this.mac = mac;
        this.ipImp = ipImp;
        this.ipDevice = ipDevice;
        this.marca = marca;
        this.type = type;
        this.descEstado = descEstado;
        this.codserie = codserie;
        this.hh = hh;
        this.contrato = contrato;
        this.nomModel = nomModel;
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
        this.negro = negro;
        this.cian = cian;
        this.magenta = magenta;
        this.amarillo = amarillo;
        this.imprColor = imprColor;
        this.imprBn = imprBn;
        this.negroMax = negroMax;
        this.negroAct = negroAct;
        this.cianMax = cianMax;
        this.cianAct = cianAct;
        this.magentaMax = magentaMax;
        this.magentaAct = magentaAct;
        this.amarilloMax = amarilloMax;
        this.amarilloAct = amarilloAct;
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
    public String getIpImp() {
        return ipImp;
    }

    /**
     *
     * @param ipImp
     */
    public void setIpImp(String ipImp) {
        this.ipImp = ipImp;
    }

    /**
     *
     * @return
     */
    public String getIpDevice() {
        return ipDevice;
    }

    /**
     *
     * @param ipDevice
     */
    public void setIpDevice(String ipDevice) {
        this.ipDevice = ipDevice;
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
    public short getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(short type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public String getDescEstado() {
        return descEstado;
    }

    /**
     *
     * @param descEstado
     */
    public void setDescEstado(String descEstado) {
        this.descEstado = descEstado;
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
    public String getNomModel() {
        return nomModel;
    }

    /**
     *
     * @param nomModel
     */
    public void setNomModel(String nomModel) {
        this.nomModel = nomModel;
    }

    /**
     *
     * @return
     */
    public String getCopiaColor() {
        return copiaColor;
    }

    /**
     *
     * @param copiaColor
     */
    public void setCopiaColor(String copiaColor) {
        this.copiaColor = copiaColor;
    }

    /**
     *
     * @return
     */
    public String getCopiaBn() {
        return copiaBn;
    }

    /**
     *
     * @param copiaBn
     */
    public void setCopiaBn(String copiaBn) {
        this.copiaBn = copiaBn;
    }

    /**
     *
     * @return
     */
    public String getScannerColor() {
        return scannerColor;
    }

    /**
     *
     * @param scannerColor
     */
    public void setScannerColor(String scannerColor) {
        this.scannerColor = scannerColor;
    }

    /**
     *
     * @return
     */
    public String getScannerBn() {
        return scannerBn;
    }

    /**
     *
     * @param scannerBn
     */
    public void setScannerBn(String scannerBn) {
        this.scannerBn = scannerBn;
    }

    /**
     *
     * @return
     */
    public String getA3Color() {
        return a3Color;
    }

    /**
     *
     * @param a3Color
     */
    public void setA3Color(String a3Color) {
        this.a3Color = a3Color;
    }

    /**
     *
     * @return
     */
    public String getB4Color() {
        return b4Color;
    }

    /**
     *
     * @param b4Color
     */
    public void setB4Color(String b4Color) {
        this.b4Color = b4Color;
    }

    /**
     *
     * @return
     */
    public String getA3Bn() {
        return a3Bn;
    }

    /**
     *
     * @param a3Bn
     */
    public void setA3Bn(String a3Bn) {
        this.a3Bn = a3Bn;
    }

    /**
     *
     * @return
     */
    public String getB4Bn() {
        return b4Bn;
    }

    /**
     *
     * @param b4Bn
     */
    public void setB4Bn(String b4Bn) {
        this.b4Bn = b4Bn;
    }

    /**
     *
     * @return
     */
    public String getMetro() {
        return metro;
    }

    /**
     *
     * @param metro
     */
    public void setMetro(String metro) {
        this.metro = metro;
    }

    /**
     *
     * @return
     */
    public String getDupl() {
        return dupl;
    }

    /**
     *
     * @param dupl
     */
    public void setDupl(String dupl) {
        this.dupl = dupl;
    }

    /**
     *
     * @return
     */
    public String getNegro() {
        return negro;
    }

    /**
     *
     * @param negro
     */
    public void setNegro(String negro) {
        this.negro = negro;
    }

    /**
     *
     * @return
     */
    public String getCian() {
        return cian;
    }

    /**
     *
     * @param cian
     */
    public void setCian(String cian) {
        this.cian = cian;
    }

    /**
     *
     * @return
     */
    public String getMagenta() {
        return magenta;
    }

    /**
     *
     * @param magenta
     */
    public void setMagenta(String magenta) {
        this.magenta = magenta;
    }

    /**
     *
     * @return
     */
    public String getAmarillo() {
        return amarillo;
    }

    /**
     *
     * @param amarillo
     */
    public void setAmarillo(String amarillo) {
        this.amarillo = amarillo;
    }

    /**
     *
     * @return
     */
    public String getImprColor() {
        return imprColor;
    }

    /**
     *
     * @param imprColor
     */
    public void setImprColor(String imprColor) {
        this.imprColor = imprColor;
    }

    /**
     *
     * @return
     */
    public String getImprBn() {
        return imprBn;
    }

    /**
     *
     * @param imprBn
     */
    public void setImprBn(String imprBn) {
        this.imprBn = imprBn;
    }

    /**
     *
     * @return
     */
    public String getNegroMax() {
        return negroMax;
    }

    /**
     *
     * @param negroMax
     */
    public void setNegroMax(String negroMax) {
        this.negroMax = negroMax;
    }

    /**
     *
     * @return
     */
    public String getNegroAct() {
        return negroAct;
    }

    /**
     *
     * @param negroAct
     */
    public void setNegroAct(String negroAct) {
        this.negroAct = negroAct;
    }

    /**
     *
     * @return
     */
    public String getCianMax() {
        return cianMax;
    }

    /**
     *
     * @param cianMax
     */
    public void setCianMax(String cianMax) {
        this.cianMax = cianMax;
    }

    /**
     *
     * @return
     */
    public String getCianAct() {
        return cianAct;
    }

    /**
     *
     * @param cianAct
     */
    public void setCianAct(String cianAct) {
        this.cianAct = cianAct;
    }

    /**
     *
     * @return
     */
    public String getMagentaMax() {
        return magentaMax;
    }

    /**
     *
     * @param magentaMax
     */
    public void setMagentaMax(String magentaMax) {
        this.magentaMax = magentaMax;
    }

    /**
     *
     * @return
     */
    public String getMagentaAct() {
        return magentaAct;
    }

    /**
     *
     * @param magentaAct
     */
    public void setMagentaAct(String magentaAct) {
        this.magentaAct = magentaAct;
    }

    /**
     *
     * @return
     */
    public String getAmarilloMax() {
        return amarilloMax;
    }

    /**
     *
     * @param amarilloMax
     */
    public void setAmarilloMax(String amarilloMax) {
        this.amarilloMax = amarilloMax;
    }

    /**
     *
     * @return
     */
    public String getAmarilloAct() {
        return amarilloAct;
    }

    /**
     *
     * @param amarilloAct
     */
    public void setAmarilloAct(String amarilloAct) {
        this.amarilloAct = amarilloAct;
    }
    
    //Metodos
    
    
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
