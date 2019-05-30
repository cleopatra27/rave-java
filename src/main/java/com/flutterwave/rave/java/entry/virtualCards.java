/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.fetchcardpayload;
import com.flutterwave.rave.java.payload.fundcardpayload;
import com.flutterwave.rave.java.payload.virtualcardpayload;
import com.flutterwave.rave.java.payload.withdrawcardpayload;
import com.flutterwave.rave.java.service.virtualcardServices;
import org.json.JSONObject;

/**
 *
 * @author cleopatradouglas
 */

public class virtualCards {

    public String dovirtualcardcreate(virtualcardpayload virtualcardpayload) {
        virtualcardServices virtualcardservices = new virtualcardServices();
        
        
        if (virtualcardpayload.getCurrency().equals("USD")){
            virtualcardpayload.setBilling_country("US");
        }
        else if(virtualcardpayload.getCurrency().equals("NGN")){
            virtualcardpayload.setBilling_country("NG");
        }
        
        String payload = new JSONObject(virtualcardpayload).toString();
        String response = virtualcardservices.dovirtualcardcreate(payload, virtualcardpayload);
        return response;
    }
    
    
    public String dovirtualcardsearch(virtualcardpayload virtualcardpayload) {
        virtualcardServices virtualcardservices = new virtualcardServices();
        
        
        String payload = new JSONObject(virtualcardpayload).toString();
        String response = virtualcardservices.dovirtualcardsearch(payload, virtualcardpayload);
        return response;
    }
    
    public String dovirtualcardget(virtualcardpayload virtualcardpayload) {
        virtualcardServices virtualcardservices = new virtualcardServices();
        
        
        String payload = new JSONObject(virtualcardpayload).toString();
        String response = virtualcardservices.dovirtualcardget(payload, virtualcardpayload);
        return response;
    }
    
    public String dovirtualcardterminate(virtualcardpayload virtualcardpayload) {
        virtualcardServices virtualcardservices = new virtualcardServices();
        
        
        String response = virtualcardservices.dovirtualcardterminate(virtualcardpayload);
        return response;
    }
    
    public String dovirtualcardfund(fundcardpayload fundcardpayload) {
        virtualcardServices virtualcardservices = new virtualcardServices();
        
        
        String payload = new JSONObject(fundcardpayload).toString();
        String response = virtualcardservices.dovirtualcardfund(payload, fundcardpayload);
        return response;
    }
    
    public String dovirtualcardfetchtrans(fetchcardpayload fetchcardpayload) {
        virtualcardServices virtualcardservices = new virtualcardServices();
        
        String payload = new JSONObject(fetchcardpayload).toString();
        String response = virtualcardservices.dovirtualcardfetchtrans(payload, fetchcardpayload);
        return response;
    }
    
    public String dovirtualcardfwithdraw(withdrawcardpayload withdrawcardpayload) {
        virtualcardServices virtualcardservices = new virtualcardServices();
        
        
        String payload = new JSONObject(withdrawcardpayload).toString();
        String response = virtualcardservices.dovirtualcardfwithdraw(payload, withdrawcardpayload);
        return response;
    }
    
}
