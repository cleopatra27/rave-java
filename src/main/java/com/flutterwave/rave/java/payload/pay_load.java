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
public class pay_load {

    /**
     * @return the PBFPubKey
     */
    public String getPBFPubKey() {
        return PBFPubKey;
    }

    /**
     * @param PBFPubKey the PBFPubKey to set
     */
    public void setPBFPubKey(String PBFPubKey) {
        this.PBFPubKey = PBFPubKey;
    }

    /**
     * @return the client
     */
    public String getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * @return the alg
     */
    public String getAlg() {
        return alg;
    }

    /**
     * @param alg the alg to set
     */
    public void setAlg(String alg) {
        this.alg = alg;
    }
    
    private String PBFPubKey;
    private String client;
    private String alg;
}
