/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.payload.bvnload;
import com.flutterwave.rave.java.service.verificationServices;
import org.json.JSONObject;

/**
 *
 * @author cleopatradouglas
 */
public class bvnValidation {
    
     public String bvnvalidate(bvnload bvnload) {
         verificationServices verificationServices = new verificationServices();

         String response = verificationServices.doBvnVerification(bvnload);
       return new JSONObject(response).toString();
}
}
    