/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.payload.transverifyPayload;
import com.flutterwave.rave.java.service.verificationServices;
import org.json.JSONObject;

/**
 *
 * @author cleopatradouglas
 */
public class transValidation {

    public String bvnvalidate(transverifyPayload transverifyPayload) {
        verificationServices verificationServices = new verificationServices();

         String payload = new JSONObject(transverifyPayload).toString();
        String response = verificationServices.dotransverify(payload, transverifyPayload);

        return new JSONObject(response).toString();
    }

}
