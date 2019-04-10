/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.ebillpayload;
import com.flutterwave.rave.java.service.ebillServices;
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
@Path("/")
public class ebills {
    
     @POST
    @Path("ebills/create/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String doebillscreate(ebillpayload ebillpayload) {
        ebillServices ebillServices = new ebillServices();
        
//        ebillpayload.setSECKEY(raveConfig.SECRET_KEY);
        ebillpayload.setCountry("NG");
        
        String payload = new JSONObject(ebillpayload).toString();
        String response = ebillServices.doebillscreate(payload, ebillpayload);
        return response;
    }
    
     @POST
    @Path("ebills/update/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String doebillsupdate(ebillpayload ebillpayload) {
        ebillServices ebillServices = new ebillServices();
        
//        ebillpayload.setSECKEY(raveConfig.SECRET_KEY);
        ebillpayload.setCountry("NG");
        
        String payload = new JSONObject(ebillpayload).toString();
        String response = ebillServices.doebillsupdate(payload, ebillpayload);
        return response;
    }
    
}
