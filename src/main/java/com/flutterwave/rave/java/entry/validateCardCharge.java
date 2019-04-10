/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.validateCardPayload;
import com.flutterwave.rave.java.service.verificationServices;
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
public class validateCardCharge {
    
     @POST
    @Path("card/verify/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String doflwcardvalidate(validateCardPayload validatecardpayload){
        
        validatecardpayload.setPBFPubKey(raveConfig.PUBLIC_KEY);
        
         String payload = new JSONObject(validatecardpayload).toString();
        System.out.println("payload is ===>" + payload);
        
        verificationServices verificationservices = new verificationServices();
        String response = verificationservices.docardvalidate(payload);
        
        return response;
    }
    
}
