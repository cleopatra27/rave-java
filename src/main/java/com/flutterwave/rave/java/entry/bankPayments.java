/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.payload.bankPayload;
import com.flutterwave.rave.java.service.PaymentServices;
import com.flutterwave.rave.java.util.TripleDES;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import org.json.JSONObject;

/**
 *
 * @author cleopatradouglas
 */
public class bankPayments {


    public String doflwbankpayment(bankPayload bankpayload) throws UnknownHostException {
        PaymentServices paymentservices = new PaymentServices();
        // ReferenceUtil referenceutil = new ReferenceUtil();
        InetAddress localhost = InetAddress.getLocalHost();
        bankpayload.setIP((localhost).toString());

        Date date = new Date();
        //String ref = referenceutil.generateRandomString(10);

        if (bankpayload.getTxRef() == null) {
            bankpayload.setTxRef("MC" + date);
        }

//        bankpayload.setPBFPubKey(raveConfig.PUBLIC_KEY);
        TripleDES tripledes = new TripleDES();
//       String encrytedsecretkey = tripledes.getKey(raveConfig.SECRET_KEY);
        String encrytedsecretkey = tripledes.getKey(bankpayload.getSECKEY());

//       String payload = bankpayload.toString();
        String payload = new JSONObject(bankpayload).toString();
        String Encryteddata = tripledes.encryptData(payload, encrytedsecretkey);

        String response = paymentservices.doflwbankpayment(Encryteddata, bankpayload);
        return response;

    }

}
