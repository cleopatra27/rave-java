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
public class transferPayload {

    /**
     * @return the account_bank
     */
    public String getAccount_bank() {
        return account_bank;
    }

    /**
     * @param account_bank the account_bank to set
     */
    public void setAccount_bank(String account_bank) {
        this.account_bank = account_bank;
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
     * @return the seckey
     */
    public String getSeckey() {
        return seckey;
    }

    /**
     * @param seckey the seckey to set
     */
    public void setSeckey(String seckey) {
        this.seckey = seckey;
    }

    /**
     * @return the narration
     */
    public String getNarration() {
        return narration;
    }

    /**
     * @param narration the narration to set
     */
    public void setNarration(String narration) {
        this.narration = narration;
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

    /**
     * @return the meta
     */
    public metaTransferpayload getMeta() {
        return meta;
    }

    /**
     * @param meta the meta to set
     */
    public void setMeta(metaTransferpayload meta) {
        this.meta = meta;
    }

    /**
     * @return the beneficiary_name
     */
    public String getBeneficiary_name() {
        return beneficiary_name;
    }

    /**
     * @param beneficiary_name the beneficiary_name to set
     */
    public void setBeneficiary_name(String beneficiary_name) {
        this.beneficiary_name = beneficiary_name;
    }

    /**
     * @return the destination_branch_code
     */
    public String getDestination_branch_code() {
        return destination_branch_code;
    }

    /**
     * @param destination_branch_code the destination_branch_code to set
     */
    public void setDestination_branch_code(String destination_branch_code) {
        this.destination_branch_code = destination_branch_code;
    }
    
//    {
//  "account_bank": "044",
//  "account_number": "0690000044",
//  "amount": 500,
//  "seckey": "FLWSECK-e6db11d1f8a6208de8cb2f94e293450e-X",
//  "narration": "New transfer",
//  "currency": "NGN",
//  "reference": "mk-902837-jk",
//  "beneficiary_name": "Kwame Adew" // only pass this for non NGN 
//}
//    
//    {
//  "amount": 2000,
//  "seckey": "FLWSECK-e6db11d1f8a6208de8cb2f94e293450e-X",
//  "narration": "New transfer",
//  "currency": "USD",
//  "reference": "rave-transfer-15208080003460029376",
//  "beneficiary_name": "Mark Cuban"
//  "meta": [
//    {
//      "AccountNumber": "09182972BH",
//      "RoutingNumber": "0000000002993",
//      "SwiftCode": "ABJG190",
//      "BankName": "BANK OF AMERICA, N.A., SAN FRANCISCO, CA",
//      "BeneficiaryName": "Mark Cuban",
//      "BeneficiaryAddress": "San Francisco, 4 Newton",
//      "BeneficiaryCountry": "US"
//    }
//  ]
//}
    
//    {
//  "account_bank": "MPS",
//  "account_number": "2540782773934",
//  "amount": 50,
//  "seckey": "FLWSECK-e6db11d1f8a6208de8cb2f94e293450e-X",
//  "narration": "New transfer",
//  "currency": "KES",
//  "reference": "mk-902837-jk",
//  "beneficiary_name": "Kwame Adew" // only pass this for non NGN 
//}
    
    private String account_bank;
    private String account_number;
    private String amount;
    private String seckey;
    private String narration;
    private String currency;
    private String reference;
    private metaTransferpayload meta;
    private String beneficiary_name;
    private String destination_branch_code;

}
