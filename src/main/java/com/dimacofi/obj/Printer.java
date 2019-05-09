/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimacofi.obj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author nvelasquez
 */
public class Printer {
    @JsonProperty("codserie")
    private String codserie;
    @JsonProperty("ip")
    private String ip;
    @JsonProperty("code")
    private Codes code;

    /**
     *
     * @param codserie
     * @param ip
     * @param val
     */
    public Printer(String codserie, String ip, Codes val) {
        this.codserie = codserie;
        this.ip = ip;
        this.code = val;
    }

    /**
     *
     */
    public Printer() {
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
    public String getIp() {
        return ip;
    }

    /**
     *
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     *
     * @return
     */
    public Codes getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(Codes code) {
        this.code = code;
    }


    
    
}
