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
public class virtualCards {
    
    @POST
    @Path("virtualcard/create/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String dovirtualcardcreate(virtualcardpayload virtualcardpayload) {
        virtualcardServices virtualcardservices = new virtualcardServices();
        
//        virtualcardpayload.setSecret_key(raveConfig.SECRET_KEY);
        
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
    
    
     @POST
    @Path("virtualcard/search/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String dovirtualcardsearch(virtualcardpayload virtualcardpayload) {
        virtualcardServices virtualcardservices = new virtualcardServices();
        
//        virtualcardpayload.setSecret_key(raveConfig.SECRET_KEY);
        
        String payload = new JSONObject(virtualcardpayload).toString();
        String response = virtualcardservices.dovirtualcardsearch(payload, virtualcardpayload);
        return response;
    }
    
    @POST
    @Path("virtualcard/get/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String dovirtualcardget(virtualcardpayload virtualcardpayload) {
        virtualcardServices virtualcardservices = new virtualcardServices();
        
//        virtualcardpayload.setSecret_key(raveConfig.SECRET_KEY);
        
        String payload = new JSONObject(virtualcardpayload).toString();
        String response = virtualcardservices.dovirtualcardget(payload, virtualcardpayload);
        return response;
    }
    
    @POST
    @Path("virtualcard/terminate/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String dovirtualcardterminate(virtualcardpayload virtualcardpayload) {
        virtualcardServices virtualcardservices = new virtualcardServices();
        
//        virtualcardpayload.setSecret_key(raveConfig.SECRET_KEY);
        
        String response = virtualcardservices.dovirtualcardterminate(virtualcardpayload);
        return response;
    }
    
    @POST
    @Path("virtualcard/fund/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String dovirtualcardfund(fundcardpayload fundcardpayload) {
        virtualcardServices virtualcardservices = new virtualcardServices();
        
//        fundcardpayload.setSecret_key(raveConfig.SECRET_KEY);
        
        String payload = new JSONObject(fundcardpayload).toString();
        String response = virtualcardservices.dovirtualcardfund(payload, fundcardpayload);
        return response;
    }
    
     @POST
    @Path("virtualcard/trans/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String dovirtualcardfetchtrans(fetchcardpayload fetchcardpayload) {
        virtualcardServices virtualcardservices = new virtualcardServices();
        
        String payload = new JSONObject(fetchcardpayload).toString();
        String response = virtualcardservices.dovirtualcardfetchtrans(payload, fetchcardpayload);
        return response;
    }
    
     @POST
    @Path("virtualcard/withdraw/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String dovirtualcardfwithdraw(withdrawcardpayload withdrawcardpayload) {
        virtualcardServices virtualcardservices = new virtualcardServices();
        
        withdrawcardpayload.setSecret_key(raveConfig.SECRET_KEY);
        
        String payload = new JSONObject(withdrawcardpayload).toString();
        String response = virtualcardservices.dovirtualcardfwithdraw(payload, withdrawcardpayload);
        return response;
    }
    
}
