/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edhkle.mdns.client;

import java.util.HashMap;

/**
 *
 * @author ehansen
 */
public class Rfc2782 {
    
    static HashMap<String,String> serviceTypes = new HashMap<String,String>();
    static {
        serviceTypes.put("AFPOVERTCP", "._afpovertcp._tcp.local");
        serviceTypes.put("IPP", "._ipp._tcp.local");
        serviceTypes.put("HTTP", "._http._tcp.local");
        serviceTypes.put("SSH", "._ssh._tcp.local");
    }
    
    public static String lookupServiceType(String dnsSrv) {
        String serviceType = null;
        serviceType = serviceTypes.get(dnsSrv.toUpperCase());
        return serviceType;
    }
}
