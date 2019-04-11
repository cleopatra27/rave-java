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
public class bankPayload {

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
     * @return the SECKEY
     */
    public String getSECKEY() {
        return SECKEY;
    }

    /**
     * @param SECKEY the SECKEY to set
     */
    public void setSECKEY(String SECKEY) {
        this.SECKEY = SECKEY;
    }

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
     * @return the accountbank
     */
    public String getAccountbank() {
        return accountbank;
    }

    /**
     * @param accountbank the accountbank to set
     */
    public void setAccountbank(String accountbank) {
        this.accountbank = accountbank;
    }

    /**
     * @return the accountnumber
     */
    public String getAccountnumber() {
        return accountnumber;
    }

    /**
     * @param accountnumber the accountnumber to set
     */
    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
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
     * @return the payment_type
     */
    public String getPayment_type() {
        return payment_type;
    }

    /**
     * @param payment_type the payment_type to set
     */
    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the passcode
     */
    public String getPasscode() {
        return passcode;
    }

    /**
     * @param passcode the passcode to set
     */
    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    /**
     * @return the bvn
     */
    public String getBvn() {
        return bvn;
    }

    /**
     * @param bvn the bvn to set
     */
    public void setBvn(String bvn) {
        this.bvn = bvn;
    }

    /**
     * @return the phonenumber
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * @param phonenumber the phonenumber to set
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the IP
     */
    public String getIP() {
        return IP;
    }

    /**
     * @param IP the IP to set
     */
    public void setIP(String IP) {
        this.IP = IP;
    }

    /**
     * @return the txRef
     */
    public String getTxRef() {
        return txRef;
    }

    /**
     * @param txRef the txRef to set
     */
    public void setTxRef(String txRef) {
        this.txRef = txRef;
    }

    /**
     * @return the device_fingerprint
     */
    public String getDevice_fingerprint() {
        return device_fingerprint;
    }

    /**
     * @param device_fingerprint the device_fingerprint to set
     */
    public void setDevice_fingerprint(String device_fingerprint) {
        this.device_fingerprint = device_fingerprint;
    }

    /**
     * @return the redirect_url
     */
    public String getRedirect_url() {
        return redirect_url;
    }

    /**
     * @param redirect_url the redirect_url to set
     */
    public void setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
    }
 
    private String PBFPubKey;
    private String accountbank;
    private String accountnumber;
    private String currency;
    private String payment_type;
    private String country;
    private String amount;
    private String email;
    private String passcode;
    private String bvn;
    private String phonenumber;
    private String firstname;
    private String lastname;
    private String IP;
    private String txRef;
    private String device_fingerprint;
    private String redirect_url;
    private String SECKEY;
    private String test;
}
