package com.dimacofi.DAO;
// Generated 13-03-2019 14:36:21 by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.OneToMany;

/**
 * TypeDevice generated by hbm2java
 */
public class TypeDevice  implements java.io.Serializable {


  private short type;
     private String descripcion;
     
     @JsonIgnore
     @OneToMany(mappedBy="monitorDevices")
     private Set monitorDevices = new HashSet(0);

    public TypeDevice() {
    }

	
    public TypeDevice(short type, String descripcion) {
        this.type = type;
        this.descripcion = descripcion;
    }
    public TypeDevice(short type, String descripcion, Set monitorDevices) {
       this.type = type;
       this.descripcion = descripcion;
       this.monitorDevices = monitorDevices;
    }
   
    public short getType() {
        return this.type;
    }
    
    public void setType(short type) {
        this.type = type;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getMonitorDevices() {
        return this.monitorDevices;
    }
    
    public void setMonitorDevices(Set monitorDevices) {
        this.monitorDevices = monitorDevices;
    }




}


