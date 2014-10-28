/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edhkle.mdns.client;

/**
 *
 * @author ehansen
 */
public class MDnsServiceDescriptor {    
    
    public enum SERVICE_TYPE {
        PRINTING_PRINTER("._printer._http._tcp.local", "Qiana Printing Service", 6666, "printing service"),
        PRINTING_IPP("._printer._ipp._tcp.local", "Qiana Printing Service", 6667, "printing service"),
        PRINTING_HTTP("._printer._http._tcp.local", "Qiana Printing Service", 6668, "printing service"),
        RXLOOKUP("._rxlookup_http._tcp.local", "RX-Lookup-Service", 6669, "Rx lookup service");
        
        private final String dnsSD;
        private final String serviceDescription;
        private final int servicePort;
        private final String serviceText;
        
        SERVICE_TYPE(String dnsSD, String serviceDescription, int servicePort, String serviceText) {
            this.dnsSD = dnsSD;
            this.serviceDescription = serviceDescription;
            this.servicePort = servicePort;
            this.serviceText = serviceText;
        }
    }    
    
    SERVICE_TYPE type;
        
    public MDnsServiceDescriptor(SERVICE_TYPE type) {
        this.type = type;
    }
    
    public String getDnsSD() {
        return type.dnsSD;
    }
    
    public SERVICE_TYPE getServiceType() {
        return type;
    }
    
    public String getDescription() {
        return type.serviceDescription;
    }
    
    public int getPort() {
        return type.servicePort;
    }
    
    public String getText() {
        return type.serviceText;
    }
    
    @Override
    public String toString() {
        return type + "[" + getPort() + "][" + getDnsSD() + "] => " + getDescription();
    }
}
