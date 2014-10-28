/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edhkle.mdns.client;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;

/**
 *
 * @author ehansen
 */
public class MDnsServiceListener implements ServiceListener {
    JmDNS server;
    
    public MDnsServiceListener(JmDNS server) {
        this.server = server;
    }
    
    public void serviceAdded(ServiceEvent event) {
        MDnsServiceDescriptor desc = new MDnsServiceDescriptor(MDnsServiceDescriptor.SERVICE_TYPE.PRINTING_PRINTER);
        server.requestServiceInfo(desc.getDnsSD(), event.getName());
        System.console().printf("Service Added! ==> %s\n", event.getName());
    }
    
    public void serviceRemoved(ServiceEvent serviceEvent) {
        
    }
    
    public void serviceResolved(ServiceEvent serviceEvent) {
        String serviceUrl = serviceEvent.getInfo().getURL();
    }
}
