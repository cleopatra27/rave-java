/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.cardLoad;
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
        
        String expected = "{\"request\":\"please enter pin\",\"suggested_auth\":\"PIN\"}";
        String response = cardPayment.doflwcardpayment(cardload);
        
        assertEquals(expected,response);
    }

}
