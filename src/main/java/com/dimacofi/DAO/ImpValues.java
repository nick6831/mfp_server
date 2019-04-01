/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimacofi.DAO;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

    public ImpValues() {
    }

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

    public int getContrato() {
        return contrato;
    }

    public void setContrato(int contrato) {
        this.contrato = contrato;
    }

    public Integer getCorte() {
        return corte;
    }

    public void setCorte(Integer corte) {
        this.corte = corte;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCodserie() {
        return codserie;
    }

    public void setCodserie(String codserie) {
        this.codserie = codserie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getHh() {
        return hh;
    }

    public void setHh(Integer hh) {
        this.hh = hh;
    }

    public Integer getCopiaColor() {
        return copiaColor;
    }

    public void setCopiaColor(Integer copiaColor) {
        this.copiaColor = copiaColor;
    }

    public Integer getCopiaBn() {
        return copiaBn;
    }

    public void setCopiaBn(Integer copiaBn) {
        this.copiaBn = copiaBn;
    }

    public Integer getScannerColor() {
        return scannerColor;
    }

    public void setScannerColor(Integer scannerColor) {
        this.scannerColor = scannerColor;
    }

    public Integer getScannerBn() {
        return scannerBn;
    }

    public void setScannerBn(Integer scannerBn) {
        this.scannerBn = scannerBn;
    }

    public Integer getA3Color() {
        return a3Color;
    }

    public void setA3Color(Integer a3Color) {
        this.a3Color = a3Color;
    }

    public Integer getB4Color() {
        return b4Color;
    }

    public void setB4Color(Integer b4Color) {
        this.b4Color = b4Color;
    }

    public Integer getA3Bn() {
        return a3Bn;
    }

    public void setA3Bn(Integer a3Bn) {
        this.a3Bn = a3Bn;
    }

    public Integer getB4Bn() {
        return b4Bn;
    }

    public void setB4Bn(Integer b4Bn) {
        this.b4Bn = b4Bn;
    }

    public Integer getMetro() {
        return metro;
    }

    public void setMetro(Integer metro) {
        this.metro = metro;
    }

    public Integer getDupl() {
        return dupl;
    }

    public void setDupl(Integer dupl) {
        this.dupl = dupl;
    }

    public Integer getImprColor() {
        return imprColor;
    }

    public void setImprColor(Integer imprColor) {
        this.imprColor = imprColor;
    }

    public Integer getImprBn() {
        return imprBn;
    }

    public void setImprBn(Integer imprBn) {
        this.imprBn = imprBn;
    }

    public Integer getNegro() {
        return negro;
    }

    public void setNegro(Integer negro) {
        this.negro = negro;
    }

    public Integer getCian() {
        return cian;
    }

    public void setCian(Integer cian) {
        this.cian = cian;
    }

    public Integer getMagenta() {
        return magenta;
    }

    public void setMagenta(Integer magenta) {
        this.magenta = magenta;
    }

    public Integer getAmarillo() {
        return amarillo;
    }

    public void setAmarillo(Integer amarillo) {
        this.amarillo = amarillo;
    }

    public Date getFechaMuestra() {
        return fechaMuestra;
    }

    public void setFechaMuestra(Date fechaMuestra) {
        this.fechaMuestra = fechaMuestra;
    }

    public int getIdValues() {
        return idValues;
    }

    public void setIdValues(int idValues) {
        this.idValues = idValues;
    }
    

}
