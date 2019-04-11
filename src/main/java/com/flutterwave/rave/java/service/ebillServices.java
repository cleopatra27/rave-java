/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.service;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.ebillpayload;
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

/**
 *
 * @author cleopatradouglas
 */
public class ebillServices {
    
     private static final Logger LOG = Logger.getLogger(ebillServices.class);
    
     public String doebillscreate(String params, ebillpayload ebillpayload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

             HttpPost post = null;

            if ("1".equals(ebillpayload.getTest())) {
                post =  new HttpPost((raveConfig.EBILLS_URL+"generateorder/"));
            } else {
                post = new HttpPost((raveConfig.EBILLS_URL+"generateorder/"));
            }

            LOG.info("doqrpayment response ::: " + params);
            //System.out.println("params ===>" + params);


            StringEntity input = new StringEntity(params);
            input.setContentType("application/json");
            //System.out.println("input ===>" + input);
            post.setEntity(input);
            HttpResponse response = client.execute(post);

            LOG.info("doebillscreate response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("doebillscreate request" + result.toString());
            if (!String.valueOf(response.getStatusLine().getStatusCode()).startsWith("2") && !response.getEntity().getContentType().getValue().contains("json")) {
                return null;
            }
            if (response.getStatusLine().getStatusCode() == 500) {
                return "there is an error with the data";
            } else {
                return result.toString();
            }

        } catch (UnsupportedEncodingException ex) {
            LOG.error(Arrays.toString(ex.getStackTrace()));
        } catch (IOException ex) {
            LOG.error(Arrays.toString(ex.getStackTrace()));
        }
        return null;
    }
     
     
     public String doebillsupdate(String params, ebillpayload ebillpayload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

             HttpPost post = null;

            if ("1".equals(ebillpayload.getTest())) {
                post =  new HttpPost((raveConfig.EBILLS_URL+"update/"));
            } else {
                post = new HttpPost((raveConfig.EBILLS_LIVE_URL+"update/"));
            }

            LOG.info("doqrpayment response ::: " + params);
            //System.out.println("params ===>" + params);


            StringEntity input = new StringEntity(params);
            input.setContentType("application/json");
            //System.out.println("input ===>" + input);
            post.setEntity(input);
            HttpResponse response = client.execute(post);

            LOG.info("doebillsupdate response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("doebillsupdate request" + result.toString());
            if (!String.valueOf(response.getStatusLine().getStatusCode()).startsWith("2") && !response.getEntity().getContentType().getValue().contains("json")) {
                return null;
            }
            if (response.getStatusLine().getStatusCode() == 500) {
                return "there is an error with the data";
            } else {
                return result.toString();
            }

        } catch (UnsupportedEncodingException ex) {
            LOG.error(Arrays.toString(ex.getStackTrace()));
        } catch (IOException ex) {
            LOG.error(Arrays.toString(ex.getStackTrace()));
        }
        return null;
    }
    
}
