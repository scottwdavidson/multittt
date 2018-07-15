package com.swd.boot.web.resources;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
public class DemoConfig extends ResourceConfig {

    public DemoConfig() {
        register(DemoResource.class);
    }
}
