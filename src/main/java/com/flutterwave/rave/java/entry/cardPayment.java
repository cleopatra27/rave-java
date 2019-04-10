/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.FLWmetaModel;
import com.flutterwave.rave.java.payload.cardLoad;
import com.flutterwave.rave.java.payload.cardPayload;
import com.flutterwave.rave.java.payload.suggestedload;
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
public class cardPayment {

    @POST
    @Path("card/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String doflwcardpayment(cardLoad cardload) throws UnknownHostException {
        PaymentServices paymentservices = new PaymentServices();
        // ReferenceUtil referenceutil = new ReferenceUtil();
        InetAddress localhost = InetAddress.getLocalHost();
        cardload.setIP((localhost).toString());

        Date date = new Date();

        cardload.setTxRef("MC" + date);

        FLWmetaModel flwmetamodel = new FLWmetaModel();

        flwmetamodel.setMetaname(cardload.getMetaname());
        flwmetamodel.setMetavalue(cardload.getMetavalue());
        // service_payload.setCountry(users.);

        cardPayload cardpayload = new cardPayload();
        cardpayload.setAmount(cardload.getAmount());
        cardpayload.setCardno(cardload.getCardno());
        cardpayload.setCountry(cardload.getCountry());
        cardpayload.setCurrency(cardload.getCurrency());
        cardpayload.setCvv(cardload.getCvv());
        cardpayload.setDevice_fingerprint(cardload.getDevice_fingerprint());
        cardpayload.setEmail(cardload.getEmail());
        cardpayload.setExpirymonth(cardload.getExpirymonth());
        cardpayload.setExpiryyear(cardload.getExpiryyear());
        cardpayload.setFirstname(cardload.getFirstname());
        cardpayload.setIP(cardload.getIP());
        cardpayload.setLastname(cardload.getLastname());
//        cardpayload.setPBFPubKey(raveConfig.PUBLIC_KEY);
        cardpayload.setPBFPubKey(cardload.getPublic_key());
        cardpayload.setPhonenumber(cardload.getPhonenumber());
        cardpayload.setRedirect_url(cardload.getRedirect_url());
        cardpayload.setTxRef(cardload.getTxRef());
        cardpayload.setMeta(flwmetamodel);
        cardpayload.setPin(cardload.getPin());
        cardpayload.setSuggested_auth(cardload.getSuggested_auth());
        cardpayload.setBillingaddress(cardload.getBillingaddress());
        cardpayload.setBillingcity(cardload.getBillingcity());
        cardpayload.setBillingcountry(cardload.getBillingcountry());
        cardpayload.setBillingstate(cardload.getBillingstate());
        cardpayload.setBillingzip(cardload.getBillingzip());
        cardpayload.setEncryption_key(cardload.getEncryption_key());
        cardpayload.setTest(cardload.getTest());
        //  cardpayload.setSecret_key(cardload.getSecret_key());

        TripleDES tripledes = new TripleDES();
//       String encrytedsecretkey = tripledes.getKey(raveConfig.SECRET_KEY);

//       String payload = mobilemoneyPayload.toString();
        String payload = new JSONObject(cardpayload).toString();
        System.out.println("payload is ===>" + payload);

//        String Encryteddata = tripledes.encryptData(payload, raveConfig.ENCRYPTION_KEY);
        String Encryteddata = tripledes.encryptData(payload, cardpayload.getEncryption_key());
        System.out.println("Encryteddata is ===>" + Encryteddata);

        String response = paymentservices.doflwcardpayment(Encryteddata, cardpayload);

        JSONObject myObject = new JSONObject(response);
        JSONObject Object = myObject.optJSONObject("data");
        if (!"V-COMP".equals(myObject.optString("message")) ) {
            if (myObject.optString("status").equals("success") && Object.optString("suggested_auth").equals("PIN")) {
                suggestedload suggestedload = new suggestedload();
                suggestedload.setSuggested_auth("PIN");
                suggestedload.setRequest("please enter pin");
                response = new JSONObject(suggestedload).toString();
            } else if (myObject.optString("status").equals("success") && Object.optString("suggested_auth").equals("NOAUTH_INTERNATIONAL")) {
                suggestedload suggestedload = new suggestedload();
                suggestedload.setSuggested_auth("NOAUTH_INTERNATIONAL");
                suggestedload.setRequest("please enter billingzip, billingcity, billingaddress ,billingstate ,billingcountry");
                response = new JSONObject(suggestedload).toString();
            } else if (myObject.optString("status").equals("success") && Object.optString("authurl") != "N/A") {
                suggestedload suggestedload = new suggestedload();
                suggestedload.setSuggested_auth(Object.optString("authurl"));
                response = new JSONObject(suggestedload).toString();
            }
        }
        System.out.println("response ==>" + response);
        return response;
    }

}
