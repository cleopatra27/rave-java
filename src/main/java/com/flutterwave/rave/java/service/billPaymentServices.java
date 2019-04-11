/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.service;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.BillModel;
import com.flutterwave.rave.java.payload.service_payload;
import com.flutterwave.rave.java.util.raveUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 *
 * @author cleopatradouglas
 */
public class billPaymentServices {
    
    private static final Logger LOG = Logger.getLogger(billPaymentServices.class);
    
     public String dobillpaymentflw(String params, BillModel billmodel) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpPost post = null;

            if ("1".equals(billmodel.getTest())) {
               post=  new HttpPost((raveConfig.SANBOX_URL));
            } else {
                post =  new HttpPost((raveConfig.SANBOX_URL));
            }

            LOG.info("dobillpaymentflw request ::: " + params);

            StringEntity input = new StringEntity(params.toString());
            input.setContentType("application/json");
            post.setEntity(input);
            HttpResponse response = client.execute(post);

            LOG.info("dobillpaymentflw response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info(" dobillpaymentflw response message " + result.toString());
            if (!String.valueOf(response.getStatusLine().getStatusCode()).startsWith("2") && !response.getEntity().getContentType().getValue().contains("json")) {
                return null;
            }
            return result.toString();

        } catch (UnsupportedEncodingException ex) {
            LOG.error(Arrays.toString(ex.getStackTrace()));
        } catch (IOException ex) {
            LOG.error(Arrays.toString(ex.getStackTrace()));
        }
        return null;
    }
    
}
