/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edhkle.mdns.client;

import com.edhkle.mdns.client.MDnsServiceDescriptor.SERVICE_TYPE;
import java.io.IOException;
import javax.jmdns.JmDNS.Delegate;

/**
 *
 * @author ehansen
 */
public class MDnsServer {
    SERVICE_TYPE type;
    MDnsService service;
    
    public MDnsServer() throws IOException {
        service = addService(SERVICE_TYPE.PRINTING_PRINTER);
        //Delegate delegate = service.getJmDnsService().
    }
    
    private MDnsService addService(SERVICE_TYPE type) throws IOException {
        this.type = type;
        return MDnsServiceFactory.getService(type);
    }
    
    public MDnsService getService() {
        return service;
    }
}
