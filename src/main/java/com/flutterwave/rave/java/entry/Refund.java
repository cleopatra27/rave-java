/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;


import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.refundPayload;
import com.flutterwave.rave.java.service.PaymentServices;
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
public class Refund {
    
      @POST
    @Path("refund/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String dorefund(refundPayload refundpayload) {
        PaymentServices paymentservices = new PaymentServices();

      // refundpayload.setSeckey(raveConfig.SECRET_KEY);

       String payload = new JSONObject(refundpayload).toString();
        String response = paymentservices.dorefund(payload, refundpayload);
        return response;
    }
}
