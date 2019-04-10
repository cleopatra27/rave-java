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
public class BillModel {

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

    /**
     * @return the Country
     */
    public String getCountry() {
        return Country;
    }

    /**
     * @param Country the Country to set
     */
    public void setCountry(String Country) {
        this.Country = Country;
    }

    /**
     * @return the CustomerId
     */
    public String getCustomerId() {
        return CustomerId;
    }

    /**
     * @param CustomerId the CustomerId to set
     */
    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }

    /**
     * @return the Reference
     */
    public String getReference() {
        return Reference;
    }

    /**
     * @param Reference the Reference to set
     */
    public void setReference(String Reference) {
        this.Reference = Reference;
    }

    /**
     * @return the Amount
     */
    public int getAmount() {
        return Amount;
    }

    /**
     * @param Amount the Amount to set
     */
    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    /**
     * @return the RecurringType
     */
    public int getRecurringType() {
        return RecurringType;
    }

    /**
     * @param RecurringType the RecurringType to set
     */
    public void setRecurringType(int RecurringType) {
        this.RecurringType = RecurringType;
    }

    /**
     * @return the IsAirtime
     */
    public boolean isIsAirtime() {
        return IsAirtime;
    }

    /**
     * @param IsAirtime the IsAirtime to set
     */
    public void setIsAirtime(boolean IsAirtime) {
        this.IsAirtime = IsAirtime;
    }

    private String secret_key;
    private String service;
    private String service_method;
    private String service_version;
    private String service_channel;
    private String Country;
    private String CustomerId;
    private String Reference;
    private int Amount;
    private int RecurringType;
    private boolean IsAirtime;
    private String test;
}
