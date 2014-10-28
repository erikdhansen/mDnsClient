/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edhkle.mdns.client;

import java.io.Console;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

/**
 *
 * @author ehansen
 */
public class MDnsClient {
    
    static Console con = System.console();
    static MDnsClient client = null;
    
    static MDnsServer mDNSServer;
    
    JmDNS clientService;
    ServiceListener serviceListener;
    MDnsServiceDescriptor descriptor = new MDnsServiceDescriptor(MDnsServiceDescriptor.SERVICE_TYPE.PRINTING_PRINTER);
    
    public MDnsClient() throws Exception {
    }
    
    public void createMDnsService() throws IOException {
    }
    
    public void checkServiceInfo() {
        ServiceInfo[] infos = clientService.list(descriptor.getDnsSD());
        for(int i=0; i < infos.length; i++) {
            con.printf("ServiceInfo[%d]: %s\n", i, infos[i]);
        }
    }
    
    public void lookupService(String dnsSrv) throws IOException {
        JmDNS service = JmDNS.create("10.10.10.194");
        service.addServiceListener(dnsSrv, new MDnsServiceListener(service));
        ServiceInfo[] infos = service.list(dnsSrv);
        for(ServiceInfo info : infos) {
            con.printf("==> resolved service: %s at URL=%s", info.getName(), info.getURL());
        }
    }
    
    public void processCommand(String input) throws IOException {
        String[] cmd = input.split(" ");
        if(input.startsWith("list")) {
            if(cmd.length > 1) {
                String type = cmd[1];
                String dnsSrv = Rfc2782.lookupServiceType(type);
                if(dnsSrv == null) {
                    con.printf("No such service (%s)\n", type);
                    return;
                } else {
                    con.printf("Looking up service: %s = %s\n", type, dnsSrv);
                }
               lookupService(dnsSrv); 
            }
        }
    }
    
    public void run() throws Exception {
        boolean done = false;
        while(!done) {
            con.printf("%s> ", "mDNS");
            String input = con.readLine();
            if(input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit")) {
                System.exit(-1);
            } else {
                processCommand(input);
            }
        }        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Map<String,String> params = parseInput(args);
        try {
            // Start up a server...
            //mDNSServer = new MDnsServer();
            // Start up the client...
            client = new MDnsClient();
            client.run();
        } catch (Exception e) {
            e.printStackTrace();
            con.printf("%s", e.getMessage());
        }
        con.printf("Bye.\n");
    }
    
}
