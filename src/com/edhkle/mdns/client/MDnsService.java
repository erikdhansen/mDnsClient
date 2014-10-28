/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edhkle.mdns.client;

import javax.jmdns.JmDNS;

/**
 *
 * @author ehansen
 */
public interface MDnsService {
 
    public MDnsServiceDescriptor getServiceInfo();
    public JmDNS getJmDnsService();
}
