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
public class webhookEntityPayload {

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
     * @return the account_number
     */
    public String getAccount_number() {
        return account_number;
    }

    /**
     * @param account_number the account_number to set
     */
    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return the card6
     */
    public String getCard6() {
        return card6;
    }

    /**
     * @param card6 the card6 to set
     */
    public void setCard6(String card6) {
        this.card6 = card6;
    }

    /**
     * @return the card_last4
     */
    public String getCard_last4() {
        return card_last4;
    }

    /**
     * @param card_last4 the card_last4 to set
     */
    public void setCard_last4(String card_last4) {
        this.card_last4 = card_last4;
    }
    

    private String card6;
    private String card_last4;
    private String id;
    private String account_number;
    private String first_name;
    private String last_name;
    
}
