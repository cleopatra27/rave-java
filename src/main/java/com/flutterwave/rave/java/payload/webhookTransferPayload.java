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
public class webhookTransferPayload {

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
     * @return the bank_code
     */
    public String getBank_code() {
        return bank_code;
    }

    /**
     * @param bank_code the bank_code to set
     */
    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the date_created
     */
    public String getDate_created() {
        return date_created;
    }

    /**
     * @param date_created the date_created to set
     */
    public void setDate_created(String date_created) {
        this.date_created = date_created;
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
     * @return the fee
     */
    public String getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(String fee) {
        this.fee = fee;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
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
     * @return the approver
     */
    public String getApprover() {
        return approver;
    }

    /**
     * @param approver the approver to set
     */
    public void setApprover(String approver) {
        this.approver = approver;
    }

    /**
     * @return the complete_message
     */
    public String getComplete_message() {
        return complete_message;
    }

    /**
     * @param complete_message the complete_message to set
     */
    public void setComplete_message(String complete_message) {
        this.complete_message = complete_message;
    }

    /**
     * @return the requires_approval
     */
    public String getRequires_approval() {
        return requires_approval;
    }

    /**
     * @param requires_approval the requires_approval to set
     */
    public void setRequires_approval(String requires_approval) {
        this.requires_approval = requires_approval;
    }

    /**
     * @return the is_approved
     */
    public String getIs_approved() {
        return is_approved;
    }

    /**
     * @param is_approved the is_approved to set
     */
    public void setIs_approved(String is_approved) {
        this.is_approved = is_approved;
    }

    /**
     * @return the bank_name
     */
    public String getBank_name() {
        return bank_name;
    }

    /**
     * @param bank_name the bank_name to set
     */
    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }
    
    
    private String id;
    private String account_number;
    private String bank_code;
    private String fullname;
    private String date_created;
    private String currency;
    private String amount;
    private String fee;
    private String status;
    private String reference;
    private String narration;
    private String approver;
    private String complete_message;
    private String requires_approval;
    private String is_approved;
    private String bank_name;
    
}
