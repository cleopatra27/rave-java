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
public class virtualcardpayload {

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
     * @return the page
     */
    public String getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(String page) {
        this.page = page;
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
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
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
     * @return the billing_name
     */
    public String getBilling_name() {
        return billing_name;
    }

    /**
     * @param billing_name the billing_name to set
     */
    public void setBilling_name(String billing_name) {
        this.billing_name = billing_name;
    }

    /**
     * @return the billing_address
     */
    public String getBilling_address() {
        return billing_address;
    }

    /**
     * @param billing_address the billing_address to set
     */
    public void setBilling_address(String billing_address) {
        this.billing_address = billing_address;
    }

    /**
     * @return the billing_city
     */
    public String getBilling_city() {
        return billing_city;
    }

    /**
     * @param billing_city the billing_city to set
     */
    public void setBilling_city(String billing_city) {
        this.billing_city = billing_city;
    }

    /**
     * @return the billing_state
     */
    public String getBilling_state() {
        return billing_state;
    }

    /**
     * @param billing_state the billing_state to set
     */
    public void setBilling_state(String billing_state) {
        this.billing_state = billing_state;
    }

    /**
     * @return the billing_postal_code
     */
    public String getBilling_postal_code() {
        return billing_postal_code;
    }

    /**
     * @param billing_postal_code the billing_postal_code to set
     */
    public void setBilling_postal_code(String billing_postal_code) {
        this.billing_postal_code = billing_postal_code;
    }

    /**
     * @return the billing_country
     */
    public String getBilling_country() {
        return billing_country;
    }

    /**
     * @param billing_country the billing_country to set
     */
    public void setBilling_country(String billing_country) {
        this.billing_country = billing_country;
    }

    
    private String secret_key;
    private String currency;
    private String amount;
    private String billing_name;
    private String billing_address;
    private String billing_city;
    private String billing_state;
    private String billing_postal_code;
    private String billing_country;
    private String page;
    private String id;
     private String test;
    
}
