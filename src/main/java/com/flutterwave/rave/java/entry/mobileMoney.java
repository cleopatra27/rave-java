/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.payload.mobilemoneyPayload;
import com.flutterwave.rave.java.payload.mpesameta;
import com.flutterwave.rave.java.payload.splitaddPayload;
import com.flutterwave.rave.java.service.PaymentServices;
import com.flutterwave.rave.java.util.TripleDES;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author cleopatradouglas
 */
public class mobileMoney {

    public String domobilemoney(mobilemoneyPayload mobilemoneyPayload) throws UnknownHostException {
        PaymentServices paymentservices = new PaymentServices();
        InetAddress localhost = InetAddress.getLocalHost();
        mobilemoneyPayload.setIP((localhost).toString());

        Date date = new Date();

        if (mobilemoneyPayload.getTxRef() == null) {
            mobilemoneyPayload.setTxRef("MC" + date);
        }

        if (mobilemoneyPayload.getOrderRef() == null) {
            mobilemoneyPayload.setOrderRef("MC" + date);
        }

        if (mobilemoneyPayload.getSubaccounts() != null) {

            JSONArray array = new JSONArray(mobilemoneyPayload.getSubaccounts());

            List<splitaddPayload> list = new ArrayList<>();

            if (array != null) {

                for (int i = 0; i < array.length(); i++) {
                    JSONObject recordJSON = array.getJSONObject(i);

                    splitaddPayload splitaddPayload = new splitaddPayload();
                    splitaddPayload.setId(recordJSON.optString("id"));
                    splitaddPayload.setTransaction_split_ratio(recordJSON.optString("transaction_split_ratio"));

                    list.add(splitaddPayload);
                }

            }
            mobilemoneyPayload.setSubaccounts(list);
        }

        mpesameta mpesameta = new mpesameta();
        mpesameta.setMetaname(mobilemoneyPayload.getMetaname());
        mpesameta.setMetavalue(mobilemoneyPayload.getMetavalue());

        if (null != mobilemoneyPayload.getPayment_type()) {
            switch (mobilemoneyPayload.getPayment_type()) {
                case "mobilemoneygh":
                    mobilemoneyPayload.setIs_mobile_money_gh(1);
                    break;
                case "mpesa":
                    mobilemoneyPayload.setIs_mpesa("1");
                    mobilemoneyPayload.setIs_mpesa_lipa(1);
                    break;
                case "mobilemoneyuganda":
                    mobilemoneyPayload.setIs_mobile_money_ug(1);
                    break;
                case "mobilemoneyzambia":
                    mobilemoneyPayload.setIs_mobile_money_ug(1);
                    break;
                default:
                    break;
            }
        }

        TripleDES tripledes = new TripleDES();

        String payload = new JSONObject(mobilemoneyPayload).toString();

        String Encryteddata = tripledes.encryptData(payload, mobilemoneyPayload.getEncryption_key());

        String response = paymentservices.doflwmobilemoney(Encryteddata, mobilemoneyPayload);
        return response;

    }

}
