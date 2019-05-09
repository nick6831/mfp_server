/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimacofi.ctr;

import com.dimacofi.DAO.HibernateUtil;
import com.dimacofi.DAO.ImpAprov;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author nvelasquez
 */
public class CtrlImpAprov {

    public CtrlImpAprov() {
    }

    //trae la informacion de una impresora
    /**
     * <p>
     * Obtiene una lista de equipos por su marca
     * </p>
     *
     * @param marca debe estar en mayuscula
     * @return Lista de Json con los valores de un equipo
     * @throws JsonProcessingException
     */
    public String printMarca(String marca) throws JsonProcessingException {

        String Json = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(formatter);

        List<ImpAprov> aprov = session.createCriteria(ImpAprov.class)
                .add(Restrictions.eq("marca", marca.toUpperCase())).list();

        Json = objectMapper.writeValueAsString(aprov);

        session.close();

        return Json;

    }
}
