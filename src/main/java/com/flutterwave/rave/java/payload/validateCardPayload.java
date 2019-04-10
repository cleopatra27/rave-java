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
public class validateCardPayload {

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
     * @return the transaction_reference
     */
    public String getTransaction_reference() {
        return transaction_reference;
    }

    /**
     * @param transaction_reference the transaction_reference to set
     */
    public void setTransaction_reference(String transaction_reference) {
        this.transaction_reference = transaction_reference;
    }

    /**
     * @return the otp
     */
    public String getOtp() {
        return otp;
    }

    /**
     * @param otp the otp to set
     */
    public void setOtp(String otp) {
        this.otp = otp;
    }
    
    private String PBFPubKey;
    private String transaction_reference;
    private String otp;
    
}
