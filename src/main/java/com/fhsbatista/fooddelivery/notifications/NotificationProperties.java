package com.fhsbatista.fooddelivery.notifications;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("notificator.email")
public class NotificationProperties {
    private String hostServer;
    private String portServer;

    public String getHostServer() {
        return hostServer;
    }

    public String getPortServer() {
        return portServer;
    }

    public void setHostServer(String hostServer) {
        this.hostServer = hostServer;
    }

    public void setPortServer(String portServer) {
        this.portServer = portServer;
    }
}
