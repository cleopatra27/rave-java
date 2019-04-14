/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.payload.tokenChargePayload;
import com.flutterwave.rave.java.service.PaymentServices;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.json.JSONObject;

/**
 *
 * @author cleopatradouglas
 */

public class tokenCharge {
    

    public String dotokenizedcharge(tokenChargePayload tokenchargepayload) throws UnknownHostException{
        
       
        InetAddress localhost = InetAddress.getLocalHost();
        tokenchargepayload.setIP((localhost).toString());
        
         String payload = new JSONObject(tokenchargepayload).toString();
        
        PaymentServices paymentservices = new PaymentServices();
        
        String response = paymentservices.dotokencharge(payload, tokenchargepayload);
        return response;
    }
    
    
    public String doupdatetoken(tokenChargePayload tokenchargepayload){
        
        PaymentServices paymentservices = new PaymentServices();
        String response = paymentservices.dotokenupdate(tokenchargepayload);
        return response;
    }
    
}
