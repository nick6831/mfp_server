/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimacofi.ora_process;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.hibernate.Session;
import com.dimacofi.DAO.HibernateUtil;
import com.dimacofi.DAO.ContratosMfp;
import com.dimacofi.DAO.Impresora;
import com.dimacofi.DAO.MonitorDevice;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author apracticati1
 */
public class PrinterBD {

    private String marca, modelo, holding_name, holding_rut, client_name, client_rut, fecha, oid_name, oid_value;
    private int hh, dia_corte;

    public PrinterBD(String marca, String modelo, String holding_name, String holding_rut, String client_name, String client_rut, String fecha, String oid_name, String oid_value, int hh, int dia_corte) {
        this.marca = marca;
        this.modelo = modelo;
        this.holding_name = holding_name;
        this.holding_rut = holding_rut;
        this.client_name = client_name;
        this.client_rut = client_rut;
        this.fecha = fecha;
        this.oid_name = oid_name;
        this.oid_value = oid_value;
        this.hh = hh;
        this.dia_corte = dia_corte;
    }

    public PrinterBD() {

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

    public String getHolding_name() {
        return holding_name;
    }

    public void setHolding_name(String holding_name) {
        this.holding_name = holding_name;
    }

    public String getHolding_rut() {
        return holding_rut;
    }

    public void setHolding_rut(String holding_rut) {
        this.holding_rut = holding_rut;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_rut() {
        return client_rut;
    }

    public void setClient_rut(String client_rut) {
        this.client_rut = client_rut;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getOid_name() {
        return oid_name;
    }

    public void setOid_name(String oid_name) {
        this.oid_name = oid_name;
    }

    public String getOid_value() {
        return oid_value;
    }

    public void setOid_value(String oid_value) {
        this.oid_value = oid_value;
    }

    public int getHh() {
        return hh;
    }

    public void setHh(int hh) {
        this.hh = hh;
    }

    public int getDia_corte() {
        return dia_corte;
    }

    public void setDia_corte(int dia_corte) {
        this.dia_corte = dia_corte;
    }

    public void addData() throws SQLException, IOException {

        Connection dbORA = SingletonORA.getInstance().getConnection();
        Statement stmORA = dbORA.createStatement();

        ResultSet rs = stmORA.executeQuery("SELECT c.id contrato,  c.DIA_CORTE corte, cl.customer_numeric RUT,       cl.CUSTOMER_NAME cliente, HO.NOMBRE_HOLDING, HO.RUT_HOLDING  FROM SAIAPP_CONTRATO c, SAIAPP_CLIENTEV cl, SAIAPP_HOLDINGS HO WHERE c.cliente_ID = cl.customer_id     AND c.estado = 'VALIDADO'       AND cl.customer_numeric = ho.rut_cliente(+)");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        while (rs.next()) {

            ContratosMfp mfp = new ContratosMfp();
            int contrato = rs.getInt("contrato");
            int corte = rs.getInt("corte");
            String rut = rs.getString("rut");
            String cliente = rs.getString("cliente");
            String holName = rs.getString("NOMBRE_HOLDING");
            String holRut = rs.getString("RUT_HOLDING");

            mfp.setCorte(corte);
            mfp.setRut(holRut);
            mfp.setNombreHolding(holName);
            mfp.setCliente(cliente);
            mfp.setRut(rut);
            mfp.setContrato(contrato);

            session.saveOrUpdate(mfp);

        }

        ResultSet rs2 = stmORA.executeQuery("SELECT c.id contrato, ep.HH,  ep.DESCRIPCION,  ep.serie, ep.MARCA FROM SAIAPP_CONTRATO c, SAIAPP_CLIENTEV cl, sai_mif_v ep, SAIAPP_HOLDINGS HO WHERE c.cliente_ID = cl.customer_id AND c.estado = 'VALIDADO' AND c.id = ep.contrato AND cl.customer_numeric = ho.rut_cliente(+) and ep.serie is not null");
        while (rs2.next()) {

            Impresora imp = new Impresora();
            int contrato = rs2.getInt("CONTRATO");
            int hhs = rs2.getInt("HH");
            String descripcion = rs2.getString("DESCRIPCION");
            String serie = rs2.getString("SERIE");
            String marcas = rs2.getString("MARCA");

            ContratosMfp con = (ContratosMfp) session.get(ContratosMfp.class, contrato);

            //Query q = session.createQuery("from Impresora where contrato = :contrato");
            // q.setParameter("contrato", con);
            Impresora dev = (Impresora) session.createCriteria(Impresora.class)
                    .add(Restrictions.eq("hh", hhs)).setMaxResults(1).uniqueResult();

            MonitorDevice de = (MonitorDevice) session.get(MonitorDevice.class, 1);

            if (con != null) {
                imp.setCodserie(serie);
                imp.setHh(hhs);
                imp.setModelo(descripcion);
                imp.setMarca(marcas);
                imp.setContratosMfp(con);
                if (dev != null) {
                    imp.setMonitorDevice(dev.getMonitorDevice());
                } else {
                    imp.setMonitorDevice(de);
                }

                session.saveOrUpdate(imp);
            }
        }

        session.getTransaction().commit();

    }

}
