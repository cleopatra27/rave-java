/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.BillModel;
import com.flutterwave.rave.java.payload.billLoad;
import com.flutterwave.rave.java.payload.service_payload;
import com.flutterwave.rave.java.service.billPaymentServices;
import com.flutterwave.rave.java.util.raveUtil;
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
public class bills {

    @POST
    @Path("buyairtime/v1")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public String dobillpayment(BillModel billmodel) {
        billPaymentServices billpaymentservices = new billPaymentServices();

        service_payload service_payload = new service_payload();

        raveUtil referenceutil = new raveUtil();

        String ref = referenceutil.generateRef(10);

        service_payload.setAmount(billmodel.getAmount());

        service_payload.setBillerName(raveConfig.AIRTIME_BILLERNAME);
        service_payload.setCustomerId(billmodel.getCustomerId());
        service_payload.setRecurringType(billmodel.getRecurringType());
        service_payload.setIsAirtime(billmodel.isIsAirtime());
        service_payload.setIsAirtime(billmodel.isIsAirtime());
        service_payload.setReference(billmodel.getReference());
        service_payload.setCountry("NG");

        billLoad billload = new billLoad();
//            billload.setSecret_key(raveConfig.SECRET_KEY);
        billload.setSecret_key(billmodel.getSecret_key());
        billload.setService(raveConfig.BUY_SERVICE);
        billload.setService_channel(raveConfig.SERVICE_CHANNEL);
        billload.setService_method(raveConfig.SERVICE_METHOD_POST);
        billload.setService_version(raveConfig.SERVICE_VERSION);
        billload.setService_payload(service_payload);

        String payload = new JSONObject(billload).toString();

        String response = billpaymentservices.dobillpaymentflw(payload, billmodel);
        return response;
    }

}
