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
public class mpesameta {

    /**
     * @return the metaname
     */
    public String getMetaname() {
        return metaname;
    }

    /**
     * @param metaname the metaname to set
     */
    public void setMetaname(String metaname) {
        this.metaname = metaname;
    }

    /**
     * @return the metavalue
     */
    public String getMetavalue() {
        return metavalue;
    }

    /**
     * @param metavalue the metavalue to set
     */
    public void setMetavalue(String metavalue) {
        this.metavalue = metavalue;
    }
    private String metaname;
    private String metavalue;
      
}
