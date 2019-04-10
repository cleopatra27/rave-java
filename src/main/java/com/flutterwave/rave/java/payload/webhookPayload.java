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
public class webhookPayload {

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the charged_amount
     */
    public double getCharged_amount() {
        return charged_amount;
    }

    /**
     * @param charged_amount the charged_amount to set
     */
    public void setCharged_amount(double charged_amount) {
        this.charged_amount = charged_amount;
    }

    /**
     * @return the id
     */
    public double getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(double id) {
        this.id = id;
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
     * @return the flwRef
     */
    public String getFlwRef() {
        return flwRef;
    }

    /**
     * @param flwRef the flwRef to set
     */
    public void setFlwRef(String flwRef) {
        this.flwRef = flwRef;
    }

    /**
     * @return the orderRef
     */
    public String getOrderRef() {
        return orderRef;
    }

    /**
     * @param orderRef the orderRef to set
     */
    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    /**
     * @return the paymentPlan
     */
    public String getPaymentPlan() {
        return paymentPlan;
    }

    /**
     * @param paymentPlan the paymentPlan to set
     */
    public void setPaymentPlan(String paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

    /**
     * @return the createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
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
     * @return the customer
     */
    public webhookCustomerPayload getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(webhookCustomerPayload customer) {
        this.customer = customer;
    }

    /**
     * @return the entity
     */
    public webhookEntityPayload getEntity() {
        return entity;
    }

    /**
     * @param entity the entity to set
     */
    public void setEntity(webhookEntityPayload entity) {
        this.entity = entity;
    }

    /**
     * @return the transfer
     */
    public webhookTransferPayload getTransfer() {
        return transfer;
    }

    /**
     * @param transfer the transfer to set
     */
    public void setTransfer(webhookTransferPayload transfer) {
        this.transfer = transfer;
    }

    private double id;
    private String txRef;
    private String flwRef;
    private String orderRef;
    private String paymentPlan;
    private String createdAt;
    private double amount;
    private double charged_amount;
    private String status;
    private String IP;
    private String currency;
    private webhookCustomerPayload customer;
    private webhookEntityPayload entity;
//    private String event.type;
    private webhookTransferPayload transfer;
    
}
