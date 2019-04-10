/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.bankPayload;
import com.flutterwave.rave.java.service.PaymentServices;
import com.flutterwave.rave.java.util.TripleDES;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
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
public class bankPayments {
    
       @POST
    @Path("bank/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String doflwbankpayment(bankPayload bankpayload) throws UnknownHostException {
        PaymentServices paymentservices = new PaymentServices();
        // ReferenceUtil referenceutil = new ReferenceUtil();
        InetAddress localhost = InetAddress.getLocalHost();
        bankpayload.setIP((localhost).toString());
        
         Date date = new Date();
        //String ref = referenceutil.generateRandomString(10);

        bankpayload.setTxRef("MC" + date);
        bankpayload.setPBFPubKey(raveConfig.PUBLIC_KEY);
        
        TripleDES tripledes = new TripleDES();
       String encrytedsecretkey = tripledes.getKey(raveConfig.SECRET_KEY);

//       String payload = bankpayload.toString();
String payload = new JSONObject(bankpayload).toString();
        String Encryteddata = tripledes.encryptData(payload, encrytedsecretkey);

        String response = paymentservices.doflwbankpayment(Encryteddata);
        return response;

    }
    
}
