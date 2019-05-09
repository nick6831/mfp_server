package com.dimacofi.DAO;
// Generated 18-04-2019 13:35:06 by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * ContratosMfp generated by hbm2java
 */
public class ContratosMfp  implements java.io.Serializable {


    
    @Id
    @JsonProperty("contrato") 
     private int contrato;
     private Integer corte;
     private String rut;
     private String cliente;
     private String nombreHolding;
     
     @JsonIgnore
     @OneToMany(mappedBy="impresoras")
     private Set impresoras = new HashSet(0);

    /**
     *
     */
    public ContratosMfp() {
    }

    /**
     *
     * @param contrato
     */
    public ContratosMfp(int contrato) {
        this.contrato = contrato;
    }

    /**
     *
     * @param contrato
     * @param corte
     * @param rut
     * @param cliente
     * @param nombreHolding
     * @param impresoras
     */
    public ContratosMfp(int contrato, Integer corte, String rut, String cliente, String nombreHolding, Set impresoras) {
       this.contrato = contrato;
       this.corte = corte;
       this.rut = rut;
       this.cliente = cliente;
       this.nombreHolding = nombreHolding;
       this.impresoras = impresoras;
    }
   
    /**
     *
     * @return
     */
    public int getContrato() {
        return this.contrato;
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
        return this.corte;
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
        return this.rut;
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
        return this.cliente;
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
    public String getNombreHolding() {
        return this.nombreHolding;
    }
    
    /**
     *
     * @param nombreHolding
     */
    public void setNombreHolding(String nombreHolding) {
        this.nombreHolding = nombreHolding;
    }

    /**
     *
     * @return
     */
    public Set getImpresoras() {
        return this.impresoras;
    }
    
    /**
     *
     * @param impresoras
     */
    public void setImpresoras(Set impresoras) {
        this.impresoras = impresoras;
    }




}


