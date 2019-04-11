/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.transverifyPayload;
import com.flutterwave.rave.java.service.verificationServices;
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
public class transValidation {

    @POST
    @Path("transvalidate/v1")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String bvnvalidate(transverifyPayload transverifyPayload) {
        verificationServices verificationServices = new verificationServices();

//        transverifyPayload.setSECKEY(raveConfig.SECRET_KEY);
        
         String payload = new JSONObject(transverifyPayload).toString();
        String response = verificationServices.dotransverify(payload, transverifyPayload);
//        return response;
        return new JSONObject(response).toString();
    }

}
