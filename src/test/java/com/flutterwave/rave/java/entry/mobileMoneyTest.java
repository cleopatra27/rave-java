/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.mobilemoneyPayload;
import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cleopatradouglas
 */
public class mobileMoneyTest {

    public mobileMoneyTest() {
    }

    /**
     * Test of domobilemoney method, of class mobileMoney.
     */
    @Test
    public void testDomobilemoney() throws Exception {

        mobileMoney mobileMoney = new mobileMoney();
        mobilemoneyPayload mobilemoneyPayload = new mobilemoneyPayload();
        mobilemoneyPayload.setPBFPubKey(raveConfig.PUBLIC_KEY);
        mobilemoneyPayload.setCurrency("ZMW");
        mobilemoneyPayload.setAmount("50");
        mobilemoneyPayload.setPhonenumber("054709929220");
        mobilemoneyPayload.setEmail("user@example.com");
        mobilemoneyPayload.setFirstname("temi");
        mobilemoneyPayload.setLastname("desola");
        mobilemoneyPayload.setNetwork("MTN");
        mobilemoneyPayload.setCountry("NG");
        mobilemoneyPayload.setDevice_fingerprint("69e6b7f0b72037aa8428b70fbe03986c");
        mobilemoneyPayload.setPayment_type("mobilemoneyzambia");
        mobilemoneyPayload.setEncryption_key("FLWSECK_TEST6d4fddc11a53");
        mobilemoneyPayload.setPublic_key(raveConfig.PUBLIC_KEY);
        mobilemoneyPayload.setTest("1");
//set test to 1 if sandbox and 0 if live

        String expected = "success";
        String response = mobileMoney.domobilemoney(mobilemoneyPayload);
        JSONObject RES = new JSONObject(response);
        String status = RES.optString("status");

        assertEquals(expected, status);
    }

}
