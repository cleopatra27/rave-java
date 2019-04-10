/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.bulkPayload;
import com.flutterwave.rave.java.payload.transferPayload;
import com.flutterwave.rave.java.service.transferServices;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;

/**
 *
 * @author cleopatradouglas
 */
public class transfers {
    
    @POST
    @Path("transfers/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String dotransfer(transferPayload transferPayload) {
        transferServices transferServices = new transferServices();
        
        transferPayload.setSeckey(raveConfig.SECRET_KEY);
        
        String payload = new JSONObject(transferPayload).toString();
        String response = transferServices.dotransfer(payload);
        return response;
    }
    
    @POST
    @Path("transfers/bulk/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String dobulktransfer(bulkPayload bulkPayload) {
        transferServices transferServices = new transferServices();
        
        bulkPayload.setSeckey(raveConfig.SECRET_KEY);
        
        String payload = new JSONObject(bulkPayload).toString();
        String response = transferServices.dobulktransfer(payload);
        return response;
    }
    
}
