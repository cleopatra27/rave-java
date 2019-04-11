/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.payload.suscriptionfetch;
import com.flutterwave.rave.java.service.accountServices;

/**
 *
 * @author cleopatradouglas
 */
public class subscriptions {
    
    public String dolistsubscriptions() {
        accountServices accountservices = new accountServices();

        String response = accountservices.dolistsubscriptions();
        return response;
    }
    
    public String dofetchsubscriptions(suscriptionfetch suscriptionfetch) {
        accountServices accountservices = new accountServices();
        
        String response = accountservices.dofetchsubscription(suscriptionfetch);
        return response;
    }
    
    public String docancelsubscriptions(suscriptionfetch suscriptionfetch) {
        accountServices accountservices = new accountServices();
        
        String response = accountservices.docancelsubscription(suscriptionfetch);
        return response;
    }
    
    public String doactivatesubscriptions(suscriptionfetch suscriptionfetch) {
        accountServices accountservices = new accountServices();
        
        String response = accountservices.doactivatesubscription(suscriptionfetch);
        return response;
    }
    
}
