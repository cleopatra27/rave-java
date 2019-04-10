/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.payload.suscriptionfetch;
import com.flutterwave.rave.java.service.accountServices;
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
public class subscriptions {
    
    @POST
    @Path("subscriptions/list/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String dolistsubscriptions() {
        accountServices accountservices = new accountServices();

        String response = accountservices.dolistsubscriptions();
        return response;
    }
    
     @POST
    @Path("subscriptions/fetch/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String dofetchsubscriptions(suscriptionfetch suscriptionfetch) {
        accountServices accountservices = new accountServices();
        
        String response = accountservices.dofetchsubscription(suscriptionfetch);
        return response;
    }
    
    @POST
    @Path("subscriptions/cancel/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String docancelsubscriptions(suscriptionfetch suscriptionfetch) {
        accountServices accountservices = new accountServices();
        
        String response = accountservices.docancelsubscription(suscriptionfetch);
        return response;
    }
    
    @POST
    @Path("subscriptions/activate/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String doactivatesubscriptions(suscriptionfetch suscriptionfetch) {
        accountServices accountservices = new accountServices();
        
        String response = accountservices.doactivatesubscription(suscriptionfetch);
        return response;
    }
    
}
