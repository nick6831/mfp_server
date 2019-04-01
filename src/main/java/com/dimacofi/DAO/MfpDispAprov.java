/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimacofi.DAO;

/**
 *
 * @author nvelasquez
 */
public class MfpDispAprov implements java.io.Serializable {

    private String mac;
    private String ipImp, ipDevice;
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

    public MfpDispAprov() {
    }

    public MfpDispAprov(String mac, String ipImp, String ipDevice, short type, String descEstado, String codserie, Integer hh, int contrato, String nomModel, String copiaColor, String copiaBn, String scannerColor, String scannerBn, String a3Color, String b4Color, String a3Bn, String b4Bn, String metro, String dupl, String negro, String cian, String magenta, String amarillo, String imprColor, String imprBn) {
        this.mac = mac;
        this.ipImp = ipImp;
        this.ipDevice = ipDevice;
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
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getIpImp() {
        return ipImp;
    }

    public void setIpImp(String ipImp) {
        this.ipImp = ipImp;
    }

    public String getIpDevice() {
        return ipDevice;
    }

    public void setIpDevice(String ipDevice) {
        this.ipDevice = ipDevice;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public String getDescEstado() {
        return descEstado;
    }

    public void setDescEstado(String descEstado) {
        this.descEstado = descEstado;
    }

    public String getCodserie() {
        return codserie;
    }

    public void setCodserie(String codserie) {
        this.codserie = codserie;
    }

    public Integer getHh() {
        return hh;
    }

    public void setHh(Integer hh) {
        this.hh = hh;
    }

    public int getContrato() {
        return contrato;
    }

    public void setContrato(int contrato) {
        this.contrato = contrato;
    }

    public String getNomModel() {
        return nomModel;
    }

    public void setNomModel(String nomModel) {
        this.nomModel = nomModel;
    }

    public String getCopiaColor() {
        return copiaColor;
    }

    public void setCopiaColor(String copiaColor) {
        this.copiaColor = copiaColor;
    }

    public String getCopiaBn() {
        return copiaBn;
    }

    public void setCopiaBn(String copiaBn) {
        this.copiaBn = copiaBn;
    }

    public String getScannerColor() {
        return scannerColor;
    }

    public void setScannerColor(String scannerColor) {
        this.scannerColor = scannerColor;
    }

    public String getScannerBn() {
        return scannerBn;
    }

    public void setScannerBn(String scannerBn) {
        this.scannerBn = scannerBn;
    }

    public String getA3Color() {
        return a3Color;
    }

    public void setA3Color(String a3Color) {
        this.a3Color = a3Color;
    }

    public String getB4Color() {
        return b4Color;
    }

    public void setB4Color(String b4Color) {
        this.b4Color = b4Color;
    }

    public String getA3Bn() {
        return a3Bn;
    }

    public void setA3Bn(String a3Bn) {
        this.a3Bn = a3Bn;
    }

    public String getB4Bn() {
        return b4Bn;
    }

    public void setB4Bn(String b4Bn) {
        this.b4Bn = b4Bn;
    }

    public String getMetro() {
        return metro;
    }

    public void setMetro(String metro) {
        this.metro = metro;
    }

    public String getDupl() {
        return dupl;
    }

    public void setDupl(String dupl) {
        this.dupl = dupl;
    }

    public String getNegro() {
        return negro;
    }

    public void setNegro(String negro) {
        this.negro = negro;
    }

    public String getCian() {
        return cian;
    }

    public void setCian(String cian) {
        this.cian = cian;
    }

    public String getMagenta() {
        return magenta;
    }

    public void setMagenta(String magenta) {
        this.magenta = magenta;
    }

    public String getAmarillo() {
        return amarillo;
    }

    public void setAmarillo(String amarillo) {
        this.amarillo = amarillo;
    }

    public String getImprColor() {
        return imprColor;
    }

    public void setImprColor(String imprColor) {
        this.imprColor = imprColor;
    }

    public String getImprBn() {
        return imprBn;
    }

    public void setImprBn(String imprBn) {
        this.imprBn = imprBn;
    }

   
    
    
   
    
}
