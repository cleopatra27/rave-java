/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.bankPayload;
import com.flutterwave.rave.java.payload.qrcodePayload;
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
 *
 */
@Path("/")

public class qrPayments {

    @POST
    @Path("qrpay/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
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
