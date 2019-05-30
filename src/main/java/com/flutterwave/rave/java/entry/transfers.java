/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.bulkPayload;
import com.flutterwave.rave.java.payload.transferPayload;
import com.flutterwave.rave.java.service.transferServices;
import java.util.Date;
import org.json.JSONObject;

/**
 *
 * @author cleopatradouglas
 */
public class transfers {

    public String dotransfer(transferPayload transferPayload) {
        transferServices transferServices = new transferServices();

        if (transferPayload.getReference() == null) {
            Date date = new Date();
            transferPayload.setReference("MC" + date);
        }

        String payload = new JSONObject(transferPayload).toString();
        String response = transferServices.dotransfer(payload);
        return response;
    }

    public String dobulktransfer(bulkPayload bulkPayload) {
        transferServices transferServices = new transferServices();

        bulkPayload.setSeckey(raveConfig.SECRET_KEY);

        String payload = new JSONObject(bulkPayload).toString();
        String response = transferServices.dobulktransfer(payload);
        return response;
    }

}
