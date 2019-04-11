/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.qrcodePayload;
import com.flutterwave.rave.java.service.PaymentServices;
import com.flutterwave.rave.java.util.TripleDES;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import org.json.JSONObject;

/**
 *
 * @author cleopatradouglas
 *
 */

public class qrPayments {

    public String doflwqrpayment(qrcodePayload qrcodepayload) throws UnknownHostException {
        PaymentServices paymentservices = new PaymentServices();
        // ReferenceUtil referenceutil = new ReferenceUtil();
        InetAddress localhost = InetAddress.getLocalHost();
        qrcodepayload.setIp((localhost).toString());

        Date date = new Date();
        //String ref = referenceutil.generateRandomString(10);

        qrcodepayload.setTxRef("MC" + date);
//        qrcodepayload.setPBFPubKey(raveConfig.PUBLIC_KEY);
        qrcodepayload.setPBFPubKey(qrcodepayload.getPublic_key());
        qrcodepayload.setIs_qr("qr");
        qrcodepayload.setCountry("NG");
        qrcodepayload.setPayment_type("pwc_qr");

        TripleDES tripledes = new TripleDES();
//       String encrytedsecretkey = tripledes.getKey(raveConfig.SECRET_KEY);

//       String payload = qrcodepayload.toString();
        String payload = new JSONObject(qrcodepayload).toString();
        String Encryteddata = tripledes.encryptData(payload, raveConfig.ENCRYPTION_KEY);

        String response = paymentservices.doqrpayment(Encryteddata, qrcodepayload);
        return response;

    }

}
