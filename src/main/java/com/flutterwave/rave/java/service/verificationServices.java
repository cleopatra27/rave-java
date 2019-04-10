/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.service;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.bvnload;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

/**
 *
 * @author cleopatradouglas
 */
public class verificationServices {

    private static final Logger LOG = Logger.getLogger(verificationServices.class);

    public String doBvnVerification(bvnload bvnload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            String seckey = raveConfig.SECRET_KEY;
            String bvn = bvnload.getBvn();
            HttpGet httpGet = null;

            if ("1".equals(bvnload.getTest())) {
               httpGet= new HttpGet(raveConfig.BVN_SANDBOX + "/" + bvn + "?seckey=" + seckey + "");
            } else {
                httpGet = new HttpGet(raveConfig.BVN_LIVE + "/" + bvn + "?seckey=" + seckey + "");
            }
            
            httpGet.setHeader("Content-Type", "application/json");

            HttpResponse response = client.execute(httpGet);

            LOG.info("doBvnVerification response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info(" doBvnVerification response message " + result.toString());
            if (!String.valueOf(response.getStatusLine().getStatusCode()).startsWith("2") && !response.getEntity().getContentType().getValue().contains("json")) {
                return null;
            }
            return result.toString();

        } catch (UnsupportedEncodingException ex) {
            LOG.error(Arrays.toString(ex.getStackTrace()));
        } catch (IOException ex) {
            LOG.error(Arrays.toString(ex.getStackTrace()));
        } catch (Exception ex) {
            LOG.error(Arrays.toString(ex.getStackTrace()));
        }
        return null;
    }

    public String dotransverify(String params) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpPost post = new HttpPost((raveConfig.TRANSACTION_VERIFICATION_URL));

            LOG.info("dotransverify response ::: " + params);
            System.out.println("params ===>" + params);

            StringEntity input = new StringEntity(params);
            input.setContentType("application/json");
            System.out.println("input ===>" + input);
            post.setEntity(input);
            HttpResponse response = client.execute(post);

            LOG.info("dotransverify response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("dotransverify request" + result.toString());
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

     public String docardvalidate(String params) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpPost post = new HttpPost((raveConfig.VALIDATE_CHARGE_URL_SANDBOX));

            LOG.info("docardvalidate response ::: " + params);
            System.out.println("params ===>" + params);

            StringEntity input = new StringEntity(params);
            input.setContentType("application/json");
            System.out.println("input ===>" + input);
            post.setEntity(input);
            HttpResponse response = client.execute(post);

            LOG.info("docardvalidate response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("docardvalidate request" + result.toString());
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
