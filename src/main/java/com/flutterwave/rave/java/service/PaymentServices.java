/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.service;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.FLWmetaModel;
import com.flutterwave.rave.java.payload.bankPayload;
import com.flutterwave.rave.java.payload.cardLoad;
import com.flutterwave.rave.java.payload.cardPayload;
import com.flutterwave.rave.java.payload.mobilemoneyPayload;
import com.flutterwave.rave.java.payload.pamentplancreatepayload;
import com.flutterwave.rave.java.payload.pay_load;
import com.flutterwave.rave.java.payload.paymentplanfetch;
import com.flutterwave.rave.java.payload.qrcodePayload;
import com.flutterwave.rave.java.payload.refundPayload;
import com.flutterwave.rave.java.payload.tokenChargePayload;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author cleopatradouglas
 */
public class PaymentServices {

    private static final Logger LOG = Logger.getLogger(PaymentServices.class);

    public String doflwbankpayment(String params, bankPayload bankpayload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpPost post = null;

            if ("1".equals(bankpayload.getTest())) {
                post = new HttpPost((raveConfig.SANDBOX_CHARGE_URL));
            } else {
                post = new HttpPost((raveConfig.LIVE_CHARGE_URL));
            }

            LOG.info("flwbankpayment response ::: " + params);
            //System.out.println("params ===>" + params);

            //    {
//  "PBFPubKey": "FLWPUBK-7adb6177bd71dd43c2efa3f1229e3b7f-X",
//  "client": "VodhvFFsni0CBeieHPq9HTuG5lbNPgmD5rbEw6Uxb0TD9eD9B3VM5uZ1B5lC3thQMbPypNBCAYwSybPo9pNJUIXSNhgdzsqG8eEggSJhWYv+4HToZxWamqsWrUqNUgvaCws3iPTAJOy0fPuHI53dSaMbq/EeHnGrdosfSuAGvm/L6joVVb6e7vyZ4bJl9bJyT73INhSN5glUAvHElup+AOYVoyQiQ1gN7PmW6I0DrUiiC1GSq87zk8rt7Xv31OBja7Ib+znEHBfcI/Ii36HbQF2MunOy2oAteyWIbr3cTyUuyERroRKL769f3NMxUQw5iQ39LU0KgmP2XvgMQONcuiPJWlJ9LzG8ngqCZNFGQ5yIvYrUiiufPowa7A8sAgaoIQQMt0OWGijfpJ4CeAA9/s1Bv03ZhhX2",
//  "alg": "3DES-24"
//}
            pay_load pay_load = new pay_load();
            pay_load.setPBFPubKey(raveConfig.PUBLIC_KEY);
            pay_load.setClient(params);
            pay_load.setAlg("alg");

            JSONObject requestJSON = new JSONObject();
            requestJSON.put("PBFPubKey", pay_load.getPBFPubKey());
            requestJSON.put("client", pay_load.getClient());
            requestJSON.put("alg", pay_load.getAlg());

            StringEntity input = new StringEntity(requestJSON.toString());
            input.setContentType("application/json");
            //System.out.println("input ===>" + input);
            post.setEntity(input);
            HttpResponse response = client.execute(post);

            LOG.info("flwbankpayment response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("flwbankpayment request" + result.toString());
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

    public String doflwmobilemoney(String params, mobilemoneyPayload mobilemoneyPayload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpPost post = null;

            if ("1".equals(mobilemoneyPayload.getTest())) {
                post = new HttpPost((raveConfig.SANDBOXMOBILEMONEY_CHARGE_URL));
            } else {
                post = new HttpPost((raveConfig.LIVE_CHARGE_URL));
            }

            LOG.info("doflwmobilemoney response ::: " + params);
            //System.out.println("params ===>" + params);

            pay_load pay_load = new pay_load();
//            pay_load.setPBFPubKey(raveConfig.PUBLIC_KEY);
            pay_load.setPBFPubKey(mobilemoneyPayload.getPublic_key());
            pay_load.setClient(params);
            pay_load.setAlg("alg");

            JSONObject requestJSON = new JSONObject();
//            requestJSON.put("PBFPubKey", raveConfig.PUBLIC_KEY);
            requestJSON.put("PBFPubKey", mobilemoneyPayload.getPublic_key());
            requestJSON.put("client", params);
            requestJSON.put("alg", raveConfig.alg);
            //System.out.println("requestJSON ==>" + requestJSON.toString());

            StringEntity input = new StringEntity(requestJSON.toString());
            input.setContentType("application/json");
            post.setEntity(input);
            HttpResponse response = client.execute(post);

            LOG.info("doflwmobilemoney response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("doflwmobilemoney request" + result.toString());
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

    public String doqrpayment(String params, qrcodePayload qrcodepayload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpPost post = null;

            if ("1".equals(qrcodepayload.getTest())) {
                post = new HttpPost((raveConfig.SANDBOX_CHARGE_URL));
            } else {
                post = new HttpPost((raveConfig.LIVE_CHARGE_URL));
            }

            LOG.info("doqrpayment response ::: " + params);
            //System.out.println("params ===>" + params);

            pay_load pay_load = new pay_load();
            pay_load.setPBFPubKey(raveConfig.PUBLIC_KEY);
            pay_load.setClient(params);
            pay_load.setAlg("3DES-24");

            JSONObject requestJSON = new JSONObject();
            requestJSON.put("PBFPubKey", pay_load.getPBFPubKey());
            requestJSON.put("client", pay_load.getClient());
            requestJSON.put("alg", pay_load.getAlg());

            StringEntity input = new StringEntity(requestJSON.toString());
            input.setContentType("application/json");
            //System.out.println("input ===>" + input);
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

    public String dorefund(String params, refundPayload refundpayload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpPost post = null;

            if ("1".equals(refundpayload.getTest())) {
                post = new HttpPost((raveConfig.SANDBOX_REFUND_URL));
            } else {
                post = new HttpPost((raveConfig.LIVE_REFUND_URL));
            }

            LOG.info("dorefund response ::: " + params);
            //System.out.println("params ===>" + params);

            StringEntity input = new StringEntity(params);
            input.setContentType("application/json");
            //System.out.println("input ===>" + input);
            post.setEntity(input);
            HttpResponse response = client.execute(post);

            LOG.info("dorefund response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("dorefund request" + result.toString());
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

    public String dopaymentplancreate(String params, pamentplancreatepayload pamentplancreatepayload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpPost post = null;

            if ("1".equals(pamentplancreatepayload.getTest())) {
                post = new HttpPost((raveConfig.PAYMENT_PLAN_CREATE_SANDBOX_URL));
            } else {
                post = new HttpPost((raveConfig.PAYMENT_PLAN_CREATE_LIVE_URL));
            }

            post.setHeader("ContentType", "application/json");

            LOG.info("dorefund response ::: " + params);
            //System.out.println("params ===>" + params);

            StringEntity input = new StringEntity(params);
            input.setContentType("application/json");
            //System.out.println("input ===>" + input);
            post.setEntity(input);
            HttpResponse response = client.execute(post);

            LOG.info("dorefund response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("dorefund request" + result.toString());
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

    public String dopaymentplanlist(String params, paymentplanfetch paymentplanfetch) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpPost post = null;

            if ("1".equals(paymentplanfetch.getTest())) {
                post = new HttpPost((raveConfig.PAYMENT_PLAN_SANDBOX_URL));
            } else {
                post = new HttpPost((raveConfig.PAYMENT_PLAN_LIVE_URL));
            }

            post.setHeader("ContentType", "application/json");

            LOG.info("dorefund response ::: " + params);
            //System.out.println("params ===>" + params);

            StringEntity input = new StringEntity(params);
            input.setContentType("application/json");
            //System.out.println("input ===>" + input);
            post.setEntity(input);
            HttpResponse response = client.execute(post);

            LOG.info("dorefund response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("dorefund request" + result.toString());
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

    public String dopaymentplanfetch(Map<String, String> sParaTemp) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            String id = sParaTemp.get("id");
            String q = sParaTemp.get("q");
            String seckey = raveConfig.SECRET_KEY;

            HttpPost post = null;

            if (id != null && q != null) {
                post = new HttpPost((raveConfig.PAYMENT_PLAN_SANDBOX_URL + seckey + id + q));
            } else if (id != null) {
                post = new HttpPost((raveConfig.PAYMENT_PLAN_SANDBOX_URL + seckey + id));
            } else if (q != null) {
                post = new HttpPost((raveConfig.PAYMENT_PLAN_SANDBOX_URL + seckey + q));
            } else {
                post = new HttpPost((raveConfig.PAYMENT_PLAN_SANDBOX_URL + seckey));
            }
            post.setHeader("Content-Type", "application/json");

            HttpResponse response = client.execute(post);

            LOG.info("dorefund response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("dorefund request" + result.toString());
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

    public String dopaymentplancancel(paymentplanfetch paymentplanfetch) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            String id = paymentplanfetch.getId();
            String seckey = raveConfig.SECRET_KEY;

            HttpPost post = null;

            if ("1".equals(paymentplanfetch.getTest())) {
                post = new HttpPost((raveConfig.PAYMENT_PLAN_CANCEL_SANDBOX_URL + id + "/cancel"));
            } else {
                post = new HttpPost((raveConfig.PAYMENT_PLAN_CANCEL_LIVE_URL + id + "/cancel"));
            }

            post.setHeader("ContentType", "application/json");

            JSONObject queryRequest = new JSONObject()
                    .put("seckey", raveConfig.SECRET_KEY);

            StringEntity input = new StringEntity(queryRequest.toString());
            input.setContentType("application/json");
            //System.out.println("input ===>" + input);
            post.setEntity(input);

            HttpResponse response = client.execute(post);

            LOG.info("dopaymentplancancel response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("dopaymentplancancel request" + result.toString());
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

//    public String dopaymentplancancel(Map<String, String> sParaTemp) {
//        StringBuilder result = new StringBuilder();
//        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
//            
//            String id = sParaTemp.get("id"); 
//            String seckey = raveConfig.SECRET_KEY;
//
//            HttpPost post = new HttpPost((raveConfig.PAYMENT_PLAN_CANCEL_SANDBOX_URL+id+"/cancel"));
//            post.setHeader("ContentType", "application/json");
//            
//
//            HttpResponse response = client.execute(post);
//
//            LOG.info("dopaymentplancancel response code ::: " + response.getStatusLine().getStatusCode());
//            BufferedReader rd = new BufferedReader(
//                    new InputStreamReader(response.getEntity().getContent()));
//
//            String line;
//            while ((line = rd.readLine()) != null) {
//                result.append(line);
//            }
//            LOG.info("dopaymentplancancel request" + result.toString());
//            if (!String.valueOf(response.getStatusLine().getStatusCode()).startsWith("2") && !response.getEntity().getContentType().getValue().contains("json")) {
//                return null;
//            }
//            if (response.getStatusLine().getStatusCode() == 500) {
//                return "there is an error with the data";
//            } else {
//                return result.toString();
//            }
//
//        } catch (UnsupportedEncodingException ex) {
//            LOG.error(Arrays.toString(ex.getStackTrace()));
//        } catch (IOException ex) {
//            LOG.error(Arrays.toString(ex.getStackTrace()));
//        }
//        return null;
//    }
    public String dopaymentplanedit(paymentplanfetch paymentplanfetch) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            String id = paymentplanfetch.getId();

            HttpPost post = null;

            if ("1".equals(paymentplanfetch.getTest())) {
                post = new HttpPost((raveConfig.PAYMENT_PLAN_CANCEL_SANDBOX_URL + id + "/edit"));
            } else {
                post = new HttpPost((raveConfig.PAYMENT_PLAN_CANCEL_LIVE_URL + id + "/edit"));
            }
            post.setHeader("ContentType", "application/json");

            JSONObject queryRequest = new JSONObject()
                    .put("seckey", raveConfig.SECRET_KEY)
                    .put("name", paymentplanfetch.getName())
                    .put("status", paymentplanfetch.getStatus());

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

//    public String dopaymentplanedit(Map<String, String> sParaTemp, String params) {
//        StringBuilder result = new StringBuilder();
//        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
//
//            String id = sParaTemp.get("id"); 
//            String seckey = raveConfig.SECRET_KEY;
//
//            HttpPost post = new HttpPost((raveConfig.PAYMENT_PLAN_CANCEL_SANDBOX_URL+id+"/cancel"));
//            post.setHeader("ContentType", "application/json");
//            
//            StringEntity input = new StringEntity(params);
//            input.setContentType("application/json");
//            //System.out.println("input ===>" + input);
//            post.setEntity(input);
//            
//            HttpResponse response = client.execute(post);
//
//            LOG.info("dopaymentplanedit response code ::: " + response.getStatusLine().getStatusCode());
//            BufferedReader rd = new BufferedReader(
//                    new InputStreamReader(response.getEntity().getContent()));
//
//            String line;
//            while ((line = rd.readLine()) != null) {
//                result.append(line);
//            }
//            LOG.info("dopaymentplanedit request" + result.toString());
//            if (!String.valueOf(response.getStatusLine().getStatusCode()).startsWith("2") && !response.getEntity().getContentType().getValue().contains("json")) {
//                return null;
//            }
//            if (response.getStatusLine().getStatusCode() == 500) {
//                return "there is an error with the data";
//            } else {
//                return result.toString();
//            }
//
//        } catch (UnsupportedEncodingException ex) {
//            LOG.error(Arrays.toString(ex.getStackTrace()));
//        } catch (IOException ex) {
//            LOG.error(Arrays.toString(ex.getStackTrace()));
//        }
//        return null;
//    }
    public String doflwcardpayment(String params, cardPayload cardpayload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpPost post = null;

            if ("1".equals(cardpayload.getTest())) {
                post = new HttpPost((raveConfig.SANDBOX_CHARGE_URL));
            } else {
                post = new HttpPost((raveConfig.LIVE_CHARGE_URL));
            }

            //System.out.println(params);
            LOG.info("doflwcardpayment query payment request ::: " + params);

            pay_load pay_load = new pay_load();
//            pay_load.setPBFPubKey(raveConfig.PUBLIC_KEY);
            pay_load.setPBFPubKey(cardpayload.getPBFPubKey());
            pay_load.setClient(params);
            pay_load.setAlg("alg");

            JSONObject requestJSON = new JSONObject();
            // requestJSON.put("PBFPubKey", raveConfig.PUBLIC_KEY);
            requestJSON.put("PBFPubKey", cardpayload.getPBFPubKey());
            requestJSON.put("client", params);
            requestJSON.put("alg", raveConfig.alg);

            StringEntity input = new StringEntity(requestJSON.toString());
            input.setContentType("application/json");
            post.setEntity(input);
            HttpResponse response = client.execute(post);

            LOG.info("doflwcardpayment query payment response code ::: " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            LOG.info("doflwcardpayment query payment response message " + result.toString());
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

    public String dotokencharge(String params, tokenChargePayload tokenchargepayload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpPost post = null;

            if ("1".equals(tokenchargepayload.getTest())) {
                post = new HttpPost((raveConfig.TOKENIZED_CHARGE_URL_SANDBOX));
            } else {
                post = new HttpPost((raveConfig.TOKENIZED_CHARGE_URL_LIVE));
            }

            LOG.info("doqrpayment response ::: " + params);
            //System.out.println("params ===>" + params);

            StringEntity input = new StringEntity(params);
            input.setContentType("application/json");
            //System.out.println("input ===>" + input);
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

    public String dotokenupdate(tokenChargePayload tokenchargepayload) {
        StringBuilder result = new StringBuilder();
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            String embed_token = tokenchargepayload.getToken();

            HttpPost post = null;

            if ("1".equals(tokenchargepayload.getTest())) {
                post = new HttpPost((raveConfig.TOKEN_UPDATE_URL_SANDBOX + embed_token + "/update_customer"));
            } else {
                post = new HttpPost((raveConfig.TOKEN_UPDATE_URL_LIVE + embed_token + "/update_customer"));
            }

            LOG.info("doqrpayment response ::: " + tokenchargepayload);
            //System.out.println("params ===>" + tokenchargepayload);

            JSONObject requestJSON = new JSONObject();
            requestJSON.put("email", tokenchargepayload.getEmail());
            requestJSON.put("secret_key", tokenchargepayload.getSECKEY());

            StringEntity input = new StringEntity(requestJSON.toString());
            input.setContentType("application/json");
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
