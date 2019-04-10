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
public class bulkPayload {

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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the bulk_data
     */
    public bulkdataPayload getBulk_data() {
        return bulk_data;
    }

    /**
     * @param bulk_data the bulk_data to set
     */
    public void setBulk_data(bulkdataPayload bulk_data) {
        this.bulk_data = bulk_data;
    }
    
//    {
//  "seckey":"FLWSECK-0b1d6669cf375a6208db541a1d59adbb-X",
//  "title":"May Staff Salary",
//  "bulk_data":[
//  	{
//        "Bank":"044",
//        "Account Number": "0690000032",
//        "Amount":500,
//        "Currency":"NGN",
//        "Narration":"Bulk transfer 1",
//        "reference": "mk-82973029"
//    },
//    {
//        "Bank":"044",
//        "Account Number": "0690000034",
//        "Amount":500,
//        "Currency":"NGN",
//        "Narration":"Bulk transfer 2",
//        "reference": "mk-283874750"
//    }
//  ]
//}
    
    private String seckey;
    private String title;
    private bulkdataPayload bulk_data;
    
}
