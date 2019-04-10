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
public class service_payload {

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
     * @return the BillerName
     */
    public String getBillerName() {
        return BillerName;
    }

    /**
     * @param BillerName the BillerName to set
     */
    public void setBillerName(String BillerName) {
        this.BillerName = BillerName;
    }

    private String Country;
    private String CustomerId;
    private String Reference;
    private int Amount;
    private int RecurringType;
    private boolean IsAirtime;
    private String BillerName;
}
