/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;


import com.flutterwave.rave.java.payload.refundPayload;
import com.flutterwave.rave.java.service.PaymentServices;
import org.json.JSONObject;

/**
 *
 * @author cleopatradouglas
 */
public class Refund {
    

    public String dorefund(refundPayload refundpayload) {
        PaymentServices paymentservices = new PaymentServices();

      // refundpayload.setSeckey(raveConfig.SECRET_KEY);

       String payload = new JSONObject(refundpayload).toString();
        String response = paymentservices.dorefund(payload, refundpayload);
        return response;
    }
}
