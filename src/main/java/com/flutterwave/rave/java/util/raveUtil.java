/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.util;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author cleopatradouglas
 */
public class raveUtil {
    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456rtyuofnnWERRTGydryfr346666";

    public String generateUUID(int length) {
        String returnvalue = UUID.randomUUID().toString().replaceAll("-", "");
        return returnvalue;
    }

    public String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder(length);

        for (int i = 0; 1 < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }

    public String generateRef(int length) {
        return generateUUID(length);
    }

    
}
