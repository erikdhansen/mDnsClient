/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edhkle.mdns.client;

import java.io.IOException;
import java.net.InetAddress;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

/**
 *
 * @author ehansen
 */
public class MDnsServiceImpl implements MDnsService {

    MDnsServiceDescriptor descriptor;
    JmDNS service;
    ServiceInfo info;
    
    public MDnsServiceImpl(MDnsServiceDescriptor.SERVICE_TYPE type) throws IOException {
        descriptor = new MDnsServiceDescriptor(type);
        service = JmDNS.create(InetAddress.getLocalHost());
        System.console().printf("Creating service info with descriptor: " + descriptor.toString());
        info = ServiceInfo.create(descriptor.getDnsSD(), descriptor.getDescription(), descriptor.getPort(), descriptor.getText());
        service.registerService(info);
        System.console().printf("Starting up mDNS service...", descriptor);
    }
    
    public MDnsServiceDescriptor getServiceInfo() {
        return descriptor;
    }
    
    public JmDNS getJmDnsService() {
        return service;
    }
}
