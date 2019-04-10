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
public class withdrawcardpayload {

    /**
     * @return the test
     */
    public String getTest() {
        return test;
    }

    /**
     * @param test the test to set
     */
    public void setTest(String test) {
        this.test = test;
    }

    /**
     * @return the card_id
     */
    public String getCard_id() {
        return card_id;
    }

    /**
     * @param card_id the card_id to set
     */
    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
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
    
//    {
//	"card_id": "c7623008-c2d1-41ba-b5d7-3835fd76254b",
//	"amount": "9",
//	"secret_key": "FLWSECK-e6db11d1f8a6208de8cb2f94e293450e-X"
//}
    
    private String card_id;
    private String amount;
    private String secret_key;
    private String test;
    
}
