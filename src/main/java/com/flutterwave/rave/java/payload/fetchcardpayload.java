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
public class fetchcardpayload {

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
     * @return the FromDate
     */
    public String getFromDate() {
        return FromDate;
    }

    /**
     * @param FromDate the FromDate to set
     */
    public void setFromDate(String FromDate) {
        this.FromDate = FromDate;
    }

    /**
     * @return the ToDate
     */
    public String getToDate() {
        return ToDate;
    }

    /**
     * @param ToDate the ToDate to set
     */
    public void setToDate(String ToDate) {
        this.ToDate = ToDate;
    }

    /**
     * @return the PageIndex
     */
    public String getPageIndex() {
        return PageIndex;
    }

    /**
     * @param PageIndex the PageIndex to set
     */
    public void setPageIndex(String PageIndex) {
        this.PageIndex = PageIndex;
    }

    /**
     * @return the PageSize
     */
    public String getPageSize() {
        return PageSize;
    }

    /**
     * @param PageSize the PageSize to set
     */
    public void setPageSize(String PageSize) {
        this.PageSize = PageSize;
    }

    /**
     * @return the CardId
     */
    public String getCardId() {
        return CardId;
    }

    /**
     * @param CardId the CardId to set
     */
    public void setCardId(String CardId) {
        this.CardId = CardId;
    }
    
//    		{
//      "FromDate": "2018-02-13",
//      "ToDate": "2019-12-21",
//      "PageIndex": 0,
//      "PageSize": 20,
//      "CardId": "105c55f1-b69f-4915-b8e1-d2f645cd9955"
//		}
    
    private String FromDate;
    private String ToDate;
    private String PageIndex;
    private String PageSize;
    private String CardId;
    private String test;
                
                
}
