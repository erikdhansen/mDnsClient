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
public class MDnsServicePrinting extends MDnsServiceImpl {
    
    public MDnsServicePrinting() throws IOException {
        super(SERVICE_TYPE.PRINTING_PRINTER);
    }
    
}
