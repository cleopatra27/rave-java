/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.config;

/**
 *
 * @author cleopatradouglas
 */
public class raveConfig {

    public static final String LIVE_URL = "https://api.ravepay.co/v2/services/confluence";
    public static final String CAPTURE_URL = "https://api.ravepay.co/flwv3-pug/getpaidx/api/capture";
    public static final String VOID_URL = "https://api.ravepay.co/flwv3-pug/getpaidx/api/refundorvoid";
    public static final String BUY_SERVICE = "fly_buy";
    public static final String SERVICE_METHOD_POST = "post";
    public static final String EBILLS_URL = "https://api.ravepay.co/flwv3-pug/getpaidx/api/ebills/";
    public static final String SERVICE_METHOD_GET = "get";
    public static final String SERVICE_VERSION = "v1";
    public static final String SERVICE_CHANNEL = "rave";
    public static final String AIRTIME_BILLERNAME = "AIRTIME";
    public static final String DSTV_BILLERNAME = "DSTV";
    public static final String DSTV_BOX_OFFICE_BILLERNAME = "DSTV BOX OFFICE";
    public static final String LIVE_CHARGE_URL = "https://api.ravepay.co/flwv3-pug/getpaidx/api/charge";
    public static final String REDIRECT_URL = "";
    public static final String alg = "3DES-24";
    public static final String SUSCRIPTION_LIST_URL = "https://api.ravepay.co/v2/gpx/subscriptions/query";
    public static final String SUSCRIPTION_URL = "https://api.ravepay.co/v2/gpx/subscriptions/";
    public static final String LIVE_REFUND_URL = "https://api.ravepay.co/gpx/merchant/transactions/refund";
    public static final String PAYMENT_PLAN_CREATE_LIVE_URL = "https://api.ravepay.co/v2/gpx/paymentplans/create";
    public static final String PAYMENT_PLAN_LIVE_URL = "https://api.ravepay.co/v2/gpx/paymentplans/query";
    public static final String PAYMENT_PLAN_CANCEL_LIVE_URL = "https://api.ravepay.co/v2/gpx/paymentplans/";
    public static final String BVN_LIVE = "https://api.ravepay.co/v2/kyc/bvn";
    public static final String LIVE_VIRTUAL_CARD_CREATE_URL = "https://api.ravepay.co/v2/services/virtualcards/new";
    public static final String LIVE_VIRTUAL_CARD_FUND_URL = "https://api.ravepay.co/v2/services/virtualcards/fund";
    public static final String EBILLS_LIVE_URL = "https://api.ravepay.co/flwv3-pug/getpaidx/api/ebills/";
    public static final String SUBACCOUNT_LIST_URL = "https://api.ravepay.co/v2/gpx/subaccounts";
//    public static final String SETTLEMENT_URL_LIVE = "https://ravesandboxapi.flutterwave.com/v2/merchant/settlements";
    public static final String TRANSACTION_VERIFICATION_URL_LIVE = "https://api.ravepay.co/flwv3-pug/getpaidx/api/v2/verify";
    public static final String TRANSFER_URL = "https://api.ravepay.co/v2/gpx/transfers/";
    public static final String VALIDATE_CHARGE_URL = "https://api.ravepay.co/flwv3-pug/getpaidx/api/validatecharge";
    public static final String TOKENIZED_CHARGE_URL_LIVE = "https://api.ravepay.co/flwv3-pug/getpaidx/api/tokenized/charge";
    public static final String TOKEN_UPDATE_URL_LIVE = "https://api.ravepay.co/flwv3-pug/getpaidx/api/tokenized/update_customer";

}
