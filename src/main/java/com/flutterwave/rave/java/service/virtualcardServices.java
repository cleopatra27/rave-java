/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.service;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.fetchcardpayload;
import com.flutterwave.rave.java.payload.fundcardpayload;
import com.flutterwave.rave.java.payload.pay_load;
import com.flutterwave.rave.java.payload.virtualcardpayload;
import com.flutterwave.rave.java.payload.withdrawcardpayload;
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
public class virtualcardServices {
    private static final Logger LOG = Logger.getLogger(virtualcardServices.class);
    
     public String dovirtualcardcreate(String params, virtualcardpayload virtualcardpayload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpPost post = null;

            if ("1".equals(virtualcardpayload.getTest())) {
                post = new HttpPost((raveConfig.VIRTUAL_CARD_CREATE_URL+"new"));
            } else {
                post = new HttpPost((raveConfig.LIVE_VIRTUAL_CARD_CREATE_URL+"new"));
            }

            LOG.info("doqrpayment response ::: " + params);
            System.out.println("params ===>" + params);


            StringEntity input = new StringEntity(params);
            input.setContentType("application/json");
            System.out.println("input ===>" + input);
            post.setEntity(input);
            HttpResponse response = client.execute(post);

            LOG.info("doqrpayment response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("doqrpayment request" + result.toString());
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
     
     public String dovirtualcardsearch(String params, virtualcardpayload virtualcardpayload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpPost post = null;

            if ("1".equals(virtualcardpayload.getTest())) {
                post = new HttpPost((raveConfig.VIRTUAL_CARD_CREATE_URL+"search"));
            } else {
                post = new HttpPost((raveConfig.LIVE_VIRTUAL_CARD_CREATE_URL+"search"));
            }

            LOG.info("dovirtualcardsearch response ::: " + params);
            System.out.println("params ===>" + params);


            StringEntity input = new StringEntity(params);
            input.setContentType("application/json");
            System.out.println("input ===>" + input);
            post.setEntity(input);
            HttpResponse response = client.execute(post);

            LOG.info("doqrpayment response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("doqrpayment request" + result.toString());
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
     
     public String dovirtualcardget(String params, virtualcardpayload virtualcardpayload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            
             HttpPost post = null;

            if ("1".equals(virtualcardpayload.getTest())) {
                post = new HttpPost((raveConfig.VIRTUAL_CARD_CREATE_URL+"get"));
            } else {
                post = new HttpPost((raveConfig.LIVE_VIRTUAL_CARD_CREATE_URL+"get"));
            }

            LOG.info("doqrpayment response ::: " + params);
            System.out.println("params ===>" + params);

            StringEntity input = new StringEntity(params);
            input.setContentType("application/json");
            System.out.println("input ===>" + input);
            post.setEntity(input);
            HttpResponse response = client.execute(post);

            LOG.info("doqrpayment response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("doqrpayment request" + result.toString());
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
     
      public String dovirtualcardterminate(virtualcardpayload virtualcardpayload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            
            String id = virtualcardpayload.getId();
            
             HttpPost post = null;

            if ("1".equals(virtualcardpayload.getTest())) {
                post = new HttpPost((raveConfig.VIRTUAL_CARD_CREATE_URL+id+"terminate"));
            } else {
                post = new HttpPost((raveConfig.LIVE_VIRTUAL_CARD_CREATE_URL+id+"terminate"));
            }

            JSONObject requestJSON = new JSONObject();
            requestJSON.put("secret_key", raveConfig.SECRET_KEY);

            StringEntity input = new StringEntity(requestJSON.toString());
            input.setContentType("application/json");
            post.setEntity(input);

            HttpResponse response = client.execute(post);

            LOG.info("dovirtualcardterminate response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("dovirtualcardterminate request" + result.toString());
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
      
        public String dovirtualcardfetchtrans(String params, fetchcardpayload fetchcardpayload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            
            HttpPost post = null;

            if ("1".equals(fetchcardpayload.getTest())) {
                post = new HttpPost((raveConfig.VIRTUAL_CARD_CREATE_URL+"transactions"));
            } else {
                post = new HttpPost((raveConfig.LIVE_VIRTUAL_CARD_CREATE_URL+"transactions"));
            }

            LOG.info("doqrpayment response ::: " + params);
            System.out.println("params ===>" + params);

            StringEntity input = new StringEntity(params);
            input.setContentType("application/json");
            System.out.println("input ===>" + input);
            post.setEntity(input);
            HttpResponse response = client.execute(post);

            LOG.info("doqrpayment response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("doqrpayment request" + result.toString());
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
        
         public String dovirtualcardfwithdraw(String params, withdrawcardpayload withdrawcardpayload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            
             HttpPost post = null;

            if ("1".equals(withdrawcardpayload.getTest())) {
                post = new HttpPost((raveConfig.VIRTUAL_CARD_CREATE_URL+"withdraw"));
            } else {
                post = new HttpPost((raveConfig.LIVE_VIRTUAL_CARD_CREATE_URL+"withdraw"));
            }

            LOG.info("doqrpayment response ::: " + params);
            System.out.println("params ===>" + params);

            StringEntity input = new StringEntity(params);
            input.setContentType("application/json");
            System.out.println("input ===>" + input);
            post.setEntity(input);
            HttpResponse response = client.execute(post);

            LOG.info("doqrpayment response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("doqrpayment request" + result.toString());
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
         
         public String dovirtualcardfund(String params,fundcardpayload fundcardpayload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            
            HttpPost post = null;

            if ("1".equals(fundcardpayload.getTest())) {
                post = new HttpPost((raveConfig.VIRTUAL_CARD_FUND_URL));
            } else {
                post = new HttpPost((raveConfig.LIVE_VIRTUAL_CARD_FUND_URL));
            }


            LOG.info("doqrpayment response ::: " + params);
            System.out.println("params ===>" + params);

            StringEntity input = new StringEntity(params);
            input.setContentType("application/json");
            System.out.println("input ===>" + input);
            post.setEntity(input);
            HttpResponse response = client.execute(post);

            LOG.info("doqrpayment response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("doqrpayment request" + result.toString());
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
