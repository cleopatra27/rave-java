/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.service;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.paymentplanfetch;
import com.flutterwave.rave.java.payload.suscriptionfetch;
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
public class accountServices {
    
     private static final Logger LOG = Logger.getLogger(accountServices.class);
    
     public String dolistsubscriptions() {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            
            String seckey = raveConfig.SECRET_KEY;

            HttpPost post = new HttpPost((raveConfig.SUSCRIPTION_LIST_SANDBOX_URL+seckey));
            post.setHeader("ContentType", "application/json");
            HttpResponse response = client.execute(post);

            LOG.info("dolistsubscriptions response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("dolistsubscriptions request" + result.toString());
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
     
      public String dofetchsubscription(suscriptionfetch suscriptionfetch) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            
             String transaction_id = suscriptionfetch.getTransaction_id();
             String seckey = raveConfig.SECRET_KEY;

            HttpPost post = new HttpPost((raveConfig.SUSCRIPTION_LIST_SANDBOX_URL+seckey+transaction_id));
            post.setHeader("ContentType", "application/json");
             
            HttpResponse response = client.execute(post);

            LOG.info("dofetchsubscription response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("dofetchsubscription request" + result.toString());
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
      
      public String docancelsubscription(suscriptionfetch suscriptionfetch) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            
              String id = suscriptionfetch.getId();
              String fetch_by_tx = suscriptionfetch.getFetch_by_tx();

            HttpPost post = new HttpPost((raveConfig.SUSCRIPTION_SANDBOX_URL+id+"/cancel"+fetch_by_tx));
            post.setHeader("ContentType", "application/json");
            
            JSONObject queryRequest = new JSONObject()
                    .put("seckey", raveConfig.SECRET_KEY);
            
            StringEntity input = new StringEntity(queryRequest.toString());
            input.setContentType("application/json");
            //System.out.println("input ===>" + input);
            post.setEntity(input);
            
            HttpResponse response = client.execute(post);

            LOG.info("dopaymentplanedit response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("dopaymentplanedit request" + result.toString());
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
      
      public String doactivatesubscription(suscriptionfetch suscriptionfetch) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            
              String id = suscriptionfetch.getId();
              String fetch_by_tx = suscriptionfetch.getFetch_by_tx();

            HttpPost post = new HttpPost((raveConfig.SUSCRIPTION_SANDBOX_URL+id+"/activate"+fetch_by_tx));
            post.setHeader("ContentType", "application/json");
            
            JSONObject queryRequest = new JSONObject()
                    .put("seckey", raveConfig.SECRET_KEY);
            
            StringEntity input = new StringEntity(queryRequest.toString());
            input.setContentType("application/json");
            //System.out.println("input ===>" + input);
            post.setEntity(input);
            
            HttpResponse response = client.execute(post);

            LOG.info("doactivatesubscription response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("doactivatesubscription request" + result.toString());
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
