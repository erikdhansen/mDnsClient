/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edhkle.mdns.client;

import com.edhkle.mdns.client.MDnsServiceDescriptor.SERVICE_TYPE;
import java.io.IOException;

/**
 *
 * @author ehansen
 */
public class MDnsServiceFactory {
    
    private final static MDnsServiceFactory _factory = new MDnsServiceFactory();
    
    private MDnsServiceFactory() {
        
    }
    
    public static MDnsService getService(SERVICE_TYPE serviceType) throws IOException {
        MDnsService service = null;
        switch(serviceType) {
            case
            PRINTING_PRINTER:
                service = (MDnsService) new MDnsServicePrinting();
                break;
            default:
        }
        return service;
    }
}
