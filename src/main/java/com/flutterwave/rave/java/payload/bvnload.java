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
public class bvnload {

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
    private String bvn;
    private String test;
    
}
