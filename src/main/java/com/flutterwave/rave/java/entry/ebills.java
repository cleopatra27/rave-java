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
public class ebills {
    
    public String doebillscreate(ebillpayload ebillpayload) {
        ebillServices ebillServices = new ebillServices();
        
        ebillpayload.setCountry("NG");
        
        String payload = new JSONObject(ebillpayload).toString();
        String response = ebillServices.doebillscreate(payload, ebillpayload);
        return response;
    }
    

    public String doebillsupdate(ebillpayload ebillpayload) {
        ebillServices ebillServices = new ebillServices();
        
        ebillpayload.setCountry("NG");
        
        String payload = new JSONObject(ebillpayload).toString();
        String response = ebillServices.doebillsupdate(payload, ebillpayload);
        return response;
    }
    
}
