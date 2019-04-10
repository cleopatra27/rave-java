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
public class transverifyPayload {

    /**
     * @return the txref
     */
    public String getTxref() {
        return txref;
    }

    /**
     * @param txref the txref to set
     */
    public void setTxref(String txref) {
        this.txref = txref;
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
    
//    {
//	"txref": "MC-09182829",
//	"SECKEY": "FLWSECK-e6db11d1f8a6208de8cb2f94e293450e-X"
//}
    
    private String txref;
    private String SECKEY;
    
}
