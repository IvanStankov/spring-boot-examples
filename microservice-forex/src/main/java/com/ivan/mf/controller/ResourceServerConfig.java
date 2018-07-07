package com.ivan.mf.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("msf");
    }

    @Bean
    public ResourceServerTokenServices tokenService() {
        final RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setClientId("ivan");
        tokenServices.setClientSecret("ivan-secret");
        tokenServices.setCheckTokenEndpointUrl("http://localhost:8070/oauth/check_token");
        return tokenServices;
    }
}
