package com.dimacofi.DAO;
// Generated 13-03-2019 14:36:21 by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.OneToMany;
import org.springframework.data.annotation.Id;

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

    public ContratosMfp() {
    }

	
    public ContratosMfp(int contrato) {
        this.contrato = contrato;
    }
    public ContratosMfp(int contrato, Integer corte, String rut, String cliente, String nombreHolding, Set impresoras) {
       this.contrato = contrato;
       this.corte = corte;
       this.rut = rut;
       this.cliente = cliente;
       this.nombreHolding = nombreHolding;
       this.impresoras = impresoras;
    }
   
    public int getContrato() {
        return this.contrato;
    }
    
    public void setContrato(int contrato) {
        this.contrato = contrato;
    }
    public Integer getCorte() {
        return this.corte;
    }
    
    public void setCorte(Integer corte) {
        this.corte = corte;
    }
    public String getRut() {
        return this.rut;
    }
    
    public void setRut(String rut) {
        this.rut = rut;
    }
    public String getCliente() {
        return this.cliente;
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public String getNombreHolding() {
        return this.nombreHolding;
    }
    
    public void setNombreHolding(String nombreHolding) {
        this.nombreHolding = nombreHolding;
    }
    public Set getImpresoras() {
        return this.impresoras;
    }
    
    public void setImpresoras(Set impresoras) {
        this.impresoras = impresoras;
    }




}

