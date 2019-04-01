/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimacofi.server_mfp;

import com.dimacofi.DAO.ImpValues;
import com.dimacofi.ctr.Controller;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import com.dimacofi.ora_process.PrinterBD;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author practicati2
 */

// Habilito las opcion para realizar tareas programadas
@Configuration
@EnableScheduling

//Configuracion de REST
@RequestMapping(value = "/")
@RestController
@ResponseBody
public class PrintRestController {

    // inject via application.properties
    
    @Scheduled(cron = "0 30 7 ? * MON-FRI")
    @PostMapping("/oraPorcess")
    // obtiene  informacion de los contratos de SAI y los almacena en una tabla interna
    public void addData() throws IOException, InterruptedException, SQLException {

        PrinterBD printbd = new PrinterBD();

        printbd.addData();

    }

    @RequestMapping(value = "/catcher", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public void catchJson(@RequestBody String data) throws ParseException, IOException {

        Controller con = new Controller();

        con.insertVal(data);

    }

    @RequestMapping(value = "/hhVal/{hh}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> hhVal(@PathVariable("hh") int hh) throws JsonProcessingException {

        Controller con = new Controller();

        String json = con.valHhAll(hh);
        if (json != null) {
            return ResponseEntity.ok(json);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay");
        }
    }

    @RequestMapping(value = "/diaCorteNow", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> diaCorteNow() throws JsonProcessingException {

        Controller con = new Controller();
        String json = con.contDiaCorteNow();
        if (json != null) {
            return ResponseEntity.ok(json);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay");
        }
    }

    @RequestMapping(value = "/diaCorte/{dia}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> diaCorte(@PathVariable("dia") int dia) throws JsonProcessingException {

        Controller con = new Controller();

        String json = con.contDiaCorte(dia);
        if (json != null) {
            return ResponseEntity.ok(json);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay");
        }
    }

    @RequestMapping(value = "/contrato/{contrato}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> contratoVal(@PathVariable("contrato") int contrato) throws JsonProcessingException {

        Controller con = new Controller();

        String json = con.valContrato(contrato);
        if (json != null) {
            return ResponseEntity.ok(json);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay");
        }
    }

    @RequestMapping(value = "/printers/{hh}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> printersAll(@PathVariable("hh") int hh) throws JsonProcessingException {

        Controller con = new Controller();

        String json = con.printerData(hh);
        if (json != null) {
            return ResponseEntity.ok(json);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay");
        }
    }

   

    @RequestMapping(value = "/csvsai/{contrato}", method = RequestMethod.GET, produces = {"text/csv"})
    @ResponseStatus(code = HttpStatus.OK)
    public Response csvSai(@PathVariable("contrato") int contrato, @Context HttpServletResponse response) throws JsonProcessingException, IOException {

        Controller con = new Controller();

        List<ImpValues> val = con.csvSai(contrato);

        response.setHeader("Content-Disposition", "attachment; filename=" + "contadores_" + System.currentTimeMillis() + ".csv");
        response.setContentType("text/csv");
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withDelimiter(';').withRecordSeparator("\n");
        try (OutputStreamWriter osw = new OutputStreamWriter(response.getOutputStream(), "UTF-8")) {
            try (CSVPrinter csvFilePrinter = new CSVPrinter(osw, csvFileFormat)) {
                csvFilePrinter.printRecord("HH", "COPIA B/N", "COPIA COLOR", "A3 B/N", "A3 COLOR", "B4 B/N", "B4 COLOR", "DUPL", "METRO", "SCANNER B/N", "SCANNER COLOR", "COMENTARIO", "FECHA", "ORDEN DE COMPRA");
                
                Integer copiaBn = 0;
                Integer copiaColor = 0;
                for (ImpValues item : val) {
                    List<String> row = new ArrayList<>();

                    row.add(item.getHh().toString());
                    copiaBn = item.getCopiaBn()+item.getImprBn();
                    row.add(copiaBn.toString());
                    copiaColor = item.getCopiaColor() +item.getImprColor();
                    row.add(copiaColor.toString());
                    row.add(item.getA3Bn().toString());
                    row.add(item.getA3Color().toString());
                    row.add(item.getB4Bn().toString());
                    row.add(item.getB4Color().toString());
                    row.add(item.getDupl().toString());
                    row.add(item.getMetro().toString());
                    row.add(item.getScannerBn().toString());
                    row.add(item.getScannerColor().toString());
                    row.add("Contadores obtenidos automaticamente");
                    row.add(item.getFechaMuestra().toString());
                    row.add("0");

                    csvFilePrinter.printRecord(row);

                }
                csvFilePrinter.flush();
            }
            osw.flush();
        }

        return Response.ok().build();

    }

    @RequestMapping(value = "/sendConfig/{Mac}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> sendConfig(@PathVariable("Mac") String mac) throws JsonProcessingException {

        Controller con = new Controller();

        String json = con.sendConfig(mac);
        if (json != null) {
            return ResponseEntity.ok(json);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay");
        }
    }

    @RequestMapping(value = "/validate/{Mac}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(code = HttpStatus.OK)
    public void validate(@PathVariable("Mac") String mac) throws JsonProcessingException, ParseException {

        Controller con = new Controller();

        con.validator(mac);

    }
    
    
    @RequestMapping(value = "/allprinters", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> printersAll() throws JsonProcessingException {
        
        Controller proc = new Controller();
        
        String json = proc.printersAll();
        
        if (json != null) {
            return ResponseEntity.ok(json);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay");
        }
        
    }
    
    
    @RequestMapping(value = "/allValues", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> valuesAll() throws JsonProcessingException {
        
        Controller proc = new Controller();
        
        String json = proc.impValuesAll();
        
        if (json != null) {
            return ResponseEntity.ok(json);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay");
        }
        
    }
    
    
     @RequestMapping(value = "/allProv", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> provAll() throws JsonProcessingException {
        
        Controller proc = new Controller();
        
        String json = proc.aprovAll();
        
        if (json != null) {
            return ResponseEntity.ok(json);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay");
        }
        
    }
    
    

}
