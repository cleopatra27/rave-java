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
public class suscriptionfetch {

    /**
     * @return the fetch_by_tx
     */
    public String getFetch_by_tx() {
        return fetch_by_tx;
    }

    /**
     * @param fetch_by_tx the fetch_by_tx to set
     */
    public void setFetch_by_tx(String fetch_by_tx) {
        this.fetch_by_tx = fetch_by_tx;
    }

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
     * @return the transaction_id
     */
    public String getTransaction_id() {
        return transaction_id;
    }

    /**
     * @param transaction_id the transaction_id to set
     */
    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }
    private String transaction_id;
    private String fetch_by_tx;
    private String id;
}
