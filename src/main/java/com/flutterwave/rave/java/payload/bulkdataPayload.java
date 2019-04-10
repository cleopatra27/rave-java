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
public class bulkdataPayload {

    /**
     * @return the Bank
     */
    public String getBank() {
        return Bank;
    }

    /**
     * @param Bank the Bank to set
     */
    public void setBank(String Bank) {
        this.Bank = Bank;
    }

    /**
     * @return the Account_number
     */
    public String getAccount_number() {
        return Account_number;
    }

    /**
     * @param Account_number the Account_number to set
     */
    public void setAccount_number(String Account_number) {
        this.Account_number = Account_number;
    }

    /**
     * @return the Amount
     */
    public String getAmount() {
        return Amount;
    }

    /**
     * @param Amount the Amount to set
     */
    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    /**
     * @return the Currency
     */
    public String getCurrency() {
        return Currency;
    }

    /**
     * @param Currency the Currency to set
     */
    public void setCurrency(String Currency) {
        this.Currency = Currency;
    }

    /**
     * @return the Narration
     */
    public String getNarration() {
        return Narration;
    }

    /**
     * @param Narration the Narration to set
     */
    public void setNarration(String Narration) {
        this.Narration = Narration;
    }

    /**
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }
    
//    "bulk_data":[
//  	{
//        "Bank":"044",
//        "Account Number": "0690000032",
//        "Amount":500,
//        "Currency":"NGN",
//        "Narration":"Bulk transfer 1",
//        "reference": "mk-82973029"
//    },
    
    private String Bank;
    private String Account_number;
    private String Amount;
    private String Currency;
    private String Narration;
    private String reference;
    
}
