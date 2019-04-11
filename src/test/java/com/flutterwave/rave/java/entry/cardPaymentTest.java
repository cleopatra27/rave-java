/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.cardLoad;
import com.flutterwave.rave.java.payload.validateCardPayload;
import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cleopatradouglas
 */
public class cardPaymentTest {

    public cardPaymentTest() {
    }

    /**
     * Test of doflwcardpayment method, of class cardPayment.
     */
    @Test
    public void testDoflwcardpayment() throws Exception {

        cardPayment cardPayment = new cardPayment();
        cardLoad cardload = new cardLoad();
        cardload.setCardno("5531886652142950");
        cardload.setCvv("564");
        cardload.setExpirymonth("09");
        cardload.setCurrency("NGN");
        cardload.setCountry("NG");
        cardload.setAmount("10");
        cardload.setEmail("user@gmail.com");
        cardload.setPhonenumber("09054529482");
        cardload.setFirstname("temi");
        cardload.setLastname("desola");
        cardload.setMetaname("flightID");
        cardload.setMetavalue("123949494DC");
        cardload.setRedirect_url("https://rave-webhook.herokuapp.com/receivepayment");
        cardload.setDevice_fingerprint("69e6b7f0b72037aa8428b70fbe03986c");
        cardload.setEncryption_key("FLWSECK_TEST6d4fddc11a53");
        cardload.setExpiryyear("22");
        cardload.setPublic_key(raveConfig.PUBLIC_KEY);
        cardload.setTest("1");

        String response = cardPayment.doflwcardpayment(cardload);
        //System.out.println("response ==>" + response);

        JSONObject myObject = new JSONObject(response);
        //System.out.println("myObject ==>" + myObject);

        if (myObject.optString("suggested_auth").equals("PIN")) {
            //System.out.println("yekdmnkd ==>" );
            //get PIN fom customer
            cardload.setPin("3310");
            cardload.setSuggested_auth("PIN");
            String response_one = cardPayment.doflwcardpayment(cardload);

            JSONObject iObject = new JSONObject(response_one);
            JSONObject Object = iObject.optJSONObject("data");

            String transaction_reference = Object.optString("flwRef");
            //System.out.println("transaction_reference ==>" + transaction_reference);
  
            validateCardCharge validatecardcharge = new validateCardCharge();
            validateCardPayload validatecardpayload = new validateCardPayload();
            validatecardpayload.setPBFPubKey(raveConfig.PUBLIC_KEY);
            validatecardpayload.setTransaction_reference(transaction_reference);
            validatecardpayload.setOtp("12345");

            response = validatecardcharge.doflwcardvalidate(validatecardpayload);
            JSONObject Obdeject = new JSONObject(response);
            String er = Obdeject.optString("status");
            //System.out.println("response val==>" + er);

            String expected = "success";
            assertEquals(expected, er);
        }

    }
}
