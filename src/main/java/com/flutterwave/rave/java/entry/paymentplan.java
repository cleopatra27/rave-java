/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.rave.java.entry;

import com.flutterwave.rave.java.payload.pamentplancreatepayload;
import com.flutterwave.rave.java.payload.paymentplanfetch;
import com.flutterwave.rave.java.service.PaymentServices;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import org.json.JSONObject;

/**
 *
 * @author cleopatradouglas
 */
public class paymentplan {

    public String docreatepayment(pamentplancreatepayload pamentplancreatepayload) {
        PaymentServices paymentservices = new PaymentServices();
        
//        pamentplancreatepayload.setSeckey(raveConfig.SECRET_KEY);
        
        String payload = new JSONObject(pamentplancreatepayload).toString();
        String response = paymentservices.dopaymentplancreate(payload, pamentplancreatepayload);
        return response;
    }
    

    public String dolistpayment(paymentplanfetch paymentplanfetch) {
        PaymentServices paymentservices = new PaymentServices();
        
//        String seckey = raveConfig.SECRET_KEY;
//        paymentplanfetch.setSeckey(seckey);
        
        String payload = new JSONObject(paymentplanfetch).toString();
        String response = paymentservices.dopaymentplanlist(payload, paymentplanfetch);
        return response;
    }
    
    public String dofetchpayment(@Context HttpServletRequest request) {
        PaymentServices paymentservices = new PaymentServices();
        
//        String seckey = raveConfig.SECRET_KEY;
       String id = null;
         try {
		 id = new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException ex) {
            Logger.getLogger(paymentplan.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         String q = null;
         try {
		 q = new String(request.getParameter("q").getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException ex) {
            Logger.getLogger(paymentplan.class.getName()).log(Level.SEVERE, null, ex);
        }
         
          String seckey = null;
         try {
		 seckey = new String(request.getParameter("seckey").getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException ex) {
            Logger.getLogger(paymentplan.class.getName()).log(Level.SEVERE, null, ex);
        }
        Map<String, String> sParaTemp = new HashMap<String, String>();
        sParaTemp.put("seckey", seckey);
        sParaTemp.put("id", id);
        sParaTemp.put("q", q);
        
        String response = paymentservices.dopaymentplanfetch(sParaTemp);
        return response;
    }
    

    public String docancelpayment(paymentplanfetch paymentplanfetch) {
        PaymentServices paymentservices = new PaymentServices();

        String response = paymentservices.dopaymentplancancel(paymentplanfetch);
        return response;
    }
    
//    @POST
//    @Path("paymentplan/cancel/v1")
//    @Consumes({MediaType.APPLICATION_JSON})
//    @Produces(MediaType.APPLICATION_JSON)
//    public String docancelpayment(@Context HttpServletRequest request) {
//        PaymentServices paymentservices = new PaymentServices();
//        
//        String seckey = raveConfig.SECRET_KEY;
//       String id = null;
//         try {
//		 id = new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
//		} catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(paymentplan.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         
//        Map<String, String> sParaTemp = new HashMap<String, String>();
//        sParaTemp.put("seckey", seckey);
//        sParaTemp.put("id", id);
//        String response = paymentservices.dopaymentplancancel(sParaTemp);
//        return response;
//    }
    
//     @POST
//    @Path("paymentplan/edit/v1")
//    @Consumes({MediaType.APPLICATION_JSON})
//    @Produces(MediaType.APPLICATION_JSON)
//    public String doeditpayment(paymentplanfetch paymentplanfetch, @Context HttpServletRequest request) {
//        PaymentServices paymentservices = new PaymentServices();
//        
//         String seckey = raveConfig.SECRET_KEY;
//       String id = null;
//         try {
//		 id = new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
//		} catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(paymentplan.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         
//        Map<String, String> sParaTemp = new HashMap<String, String>();
//        sParaTemp.put("seckey", seckey);
//        sParaTemp.put("id", id);
//        
//        paymentplanfetch.setSeckey(seckey);
//        
//        paymentplanfetch.getName();
//        paymentplanfetch.getSeckey();
//        paymentplanfetch.getStatus();
//        
//        String payload = new JSONObject(paymentplanfetch).toString();
//        
//        String response = paymentservices.dopaymentplanedit(sParaTemp, payload);
//        return response;
//    }
    

    public String doeditpayment(paymentplanfetch paymentplanfetch) {
        PaymentServices paymentservices = new PaymentServices();

        String response = paymentservices.dopaymentplanedit(paymentplanfetch);
        return response;
    }
    
    
}
