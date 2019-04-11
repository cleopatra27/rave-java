/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.mobilemoneyPayload;
import com.flutterwave.rave.java.payload.mpesameta;
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
public class mobileMoney {

    @POST
    @Path("mobilemoney/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String domobilemoney(mobilemoneyPayload mobilemoneyPayload) throws UnknownHostException {
        PaymentServices paymentservices = new PaymentServices();
        // ReferenceUtil referenceutil = new ReferenceUtil();
        InetAddress localhost = InetAddress.getLocalHost();
        mobilemoneyPayload.setIP((localhost).toString());
        //System.out.println("IP is ===>" + localhost);

        Date date = new Date();
        //String ref = referenceutil.generateRandomString(10);

        if (mobilemoneyPayload.getTxRef() == null) {
            mobilemoneyPayload.setTxRef("MC" + date);
        }

        if (mobilemoneyPayload.getOrderRef() == null) {
            mobilemoneyPayload.setOrderRef("MC" + date);
        }

//        mobilemoneyPayload.setPBFPubKey(raveConfig.PUBLIC_KEY);
//        mobilemoneyPayload.setRedirect_url(raveConfig.REDIRECT_URL);
        mpesameta mpesameta = new mpesameta();
        mpesameta.setMetaname(mobilemoneyPayload.getMetaname());
        mpesameta.setMetavalue(mobilemoneyPayload.getMetavalue());

        if (null != mobilemoneyPayload.getPayment_type()) {
            switch (mobilemoneyPayload.getPayment_type()) {
                case "mobilemoneygh":
                    mobilemoneyPayload.setIs_mobile_money_gh(1);
                    break;
                case "mpesa":
                    mobilemoneyPayload.setIs_mpesa("1");
                    mobilemoneyPayload.setIs_mpesa_lipa(1);
                    break;
                case "mobilemoneyuganda":
                    mobilemoneyPayload.setIs_mobile_money_ug(1);
                    break;
                case "mobilemoneyzambia":
                    mobilemoneyPayload.setIs_mobile_money_ug(1);
                    break;
                default:
                    break;
            }
        }

        TripleDES tripledes = new TripleDES();
//       String encrytedsecretkey = tripledes.getKey(raveConfig.SECRET_KEY);

//       String payload = mobilemoneyPayload.toString();
        String payload = new JSONObject(mobilemoneyPayload).toString();
        //System.out.println("payload is ===>" + payload);

//        String Encryteddata = tripledes.encryptData(payload, raveConfig.ENCRYPTION_KEY);
        String Encryteddata = tripledes.encryptData(payload, mobilemoneyPayload.getEncryption_key());
        //System.out.println("Encryteddata is ===>" + Encryteddata);

        String response = paymentservices.doflwmobilemoney(Encryteddata, mobilemoneyPayload);
        //System.out.println("response ==>" + response);
        return response;

    }

}
