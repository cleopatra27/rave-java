/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.payload;

/**
 *
 * @author cleopatradouglas
 */
public class billLoad {

    /**
     * @return the service_payload
     */
    public service_payload getService_payload() {
        return service_payload;
    }

    /**
     * @param service_payload the service_payload to set
     */
    public void setService_payload(service_payload service_payload) {
        this.service_payload = service_payload;
    }


    /**
     * @return the secret_key
     */
    public String getSecret_key() {
        return secret_key;
    }

    /**
     * @param secret_key the secret_key to set
     */
    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    /**
     * @return the service
     */
    public String getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     * @return the service_method
     */
    public String getService_method() {
        return service_method;
    }

    /**
     * @param service_method the service_method to set
     */
    public void setService_method(String service_method) {
        this.service_method = service_method;
    }

    /**
     * @return the service_version
     */
    public String getService_version() {
        return service_version;
    }

    /**
     * @param service_version the service_version to set
     */
    public void setService_version(String service_version) {
        this.service_version = service_version;
    }

    /**
     * @return the service_channel
     */
    public String getService_channel() {
        return service_channel;
    }

    /**
     * @param service_channel the service_channel to set
     */
    public void setService_channel(String service_channel) {
        this.service_channel = service_channel;
    }
  
            private String secret_key;
            private String service;
            private String service_method;
            private String service_version;
            private String service_channel;
            private service_payload service_payload;
}
