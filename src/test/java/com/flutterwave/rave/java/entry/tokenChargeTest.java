/*
 * The MIT License
 *
 * Copyright 2019 cleopatradouglas.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.config.raveConfig;
import com.flutterwave.rave.java.payload.tokenChargePayload;
import java.net.UnknownHostException;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cleopatradouglas
 */
public class tokenChargeTest {

    public tokenChargeTest() {
    }

    /**
     * Test of dotokenizedcharge method, of class tokenCharge.
     */
    @Test
    public void testDotokenizedcharge() throws UnknownHostException {
        tokenCharge tokencharge = new tokenCharge();
        tokenChargePayload tokenchargepayload = new tokenChargePayload();
        tokenchargepayload.setCurrency("NGN");
        tokenchargepayload.setToken("flw-t0-db3e12d3a7938b72f243acfefe02f3db-m03k");
        tokenchargepayload.setAmount("1.00");
        tokenchargepayload.setEmail("user@gmail.com");
        tokenchargepayload.setFirstname("cleopatra");
        tokenchargepayload.setLastname("douglas");
          Date date = new Date();
        tokenchargepayload.setTxRef("MC" + date);
        tokenchargepayload.setSECKEY(raveConfig.SECRET_KEY);
        tokenchargepayload.setTest("1");

        String expected = "{\"status\":\"error\",\"message\":\"ERR\",\"data\":{\"is_error\":true,\"code\":\"That token has expired\",\"message\":\"ERR\"}}";
        String response = tokencharge.dotokenizedcharge(tokenchargepayload);
        
        assertEquals(expected,response);
    }

    /**
     * Test of doupdatetoken method, of class tokenCharge.
     */
    @Test
    public void testDoupdatetoken() {

    }

}
