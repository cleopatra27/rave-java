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
public class splitaddPayload {

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the transaction_split_ratio
     */
    public String getTransaction_split_ratio() {
        return transaction_split_ratio;
    }

    /**
     * @param transaction_split_ratio the transaction_split_ratio to set
     */
    public void setTransaction_split_ratio(String transaction_split_ratio) {
        this.transaction_split_ratio = transaction_split_ratio;
    }
    
    private String id;
    private String transaction_split_ratio;
}
