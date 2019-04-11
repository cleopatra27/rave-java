/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.payload.subaccountpayload;
import com.flutterwave.rave.java.service.accountServices;

/**
 *
 * @author cleopatradouglas
 */
public class subaccounts {
    public String dosubaccountslist(subaccountpayload subaccountpayload){
        
        accountServices accountservices = new accountServices();
        String response = accountservices.dolistsubaccounts(subaccountpayload);
        return response;
    }
    
    public String dosubaccountsget(subaccountpayload subaccountpayload){
        
        accountServices accountservices = new accountServices();
        String response = accountservices.dogetsubaccounts(subaccountpayload);
        return response;
    }
    
    public String dosubaccountscreate(subaccountpayload subaccountpayload){
        
        accountServices accountservices = new accountServices();
        String response = accountservices.docreatesubaccounts(subaccountpayload);
        return response;
    }
    
    public String dosubaccountsdelete(subaccountpayload subaccountpayload){
        
        accountServices accountservices = new accountServices();
        String response = accountservices.dodeletesubaccounts(subaccountpayload);
        return response;
    }
    
}
