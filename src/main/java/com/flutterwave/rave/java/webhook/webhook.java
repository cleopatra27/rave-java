/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.webhook;

import com.flutterwave.rave.java.payload.webhookPayload;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author cleopatradouglas
 */
@Path("/")
public class webhook {
    
    @POST
    @Path("webhook/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public webhookPayload dowebhook(webhookPayload webhookpayload){  

        return webhookpayload;
    }
 
}
