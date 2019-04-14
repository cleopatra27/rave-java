/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.payload.validateCardPayload;
import com.flutterwave.rave.java.service.verificationServices;
import javax.ws.rs.Path;
import org.json.JSONObject;

/**
 *
 * @author cleopatradouglas
 */
public class validateCardCharge {
    
    public String doflwcardvalidate(validateCardPayload validatecardpayload){
        
         String payload = new JSONObject(validatecardpayload).toString();
        
        verificationServices verificationservices = new verificationServices();
        String response = verificationservices.docardvalidate(payload, validatecardpayload);
        
        return response;
    }
    
}
