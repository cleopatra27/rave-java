/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.tokenChargePayload;
import com.flutterwave.rave.java.service.PaymentServices;
import java.net.InetAddress;
import java.net.UnknownHostException;
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
public class tokenCharge {
    
      @POST
    @Path("card/tokenized/charge/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String dotokenizedcharge(tokenChargePayload tokenchargepayload) throws UnknownHostException{
        
       // tokenchargepayload.setSECKEY(raveConfig.SECRET_KEY);
       
        InetAddress localhost = InetAddress.getLocalHost();
        tokenchargepayload.setIP((localhost).toString());
        
         String payload = new JSONObject(tokenchargepayload).toString();
        //System.out.println("payload is ===>" + payload);
        
        
        PaymentServices paymentservices = new PaymentServices();
        
        String response = paymentservices.dotokencharge(payload, tokenchargepayload);
        //System.out.println(response);
        return response;
    }
    
    
      @POST
    @Path("card/tokenized/update/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String doupdatetoken(tokenChargePayload tokenchargepayload){
        
        //tokenchargepayload.setSECKEY(raveConfig.SECRET_KEY);
        
        PaymentServices paymentservices = new PaymentServices();
        String response = paymentservices.dotokenupdate(tokenchargepayload);
        return response;
    }
    
}
