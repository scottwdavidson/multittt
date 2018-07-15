package com.swd.ttt.resources;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TttConfig extends ResourceConfig {

    public TttConfig() {
        register(TttResource.class);
    }
}
