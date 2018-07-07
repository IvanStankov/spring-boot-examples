package com.ivan.mf.controller;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
@EnableOAuth2Sso
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("mf");
    }

//    @Bean
//    public ResourceServerTokenServices tokenService() {
//        final RemoteTokenServices tokenServices = new RemoteTokenServices();
//        tokenServices.setClientId("ivan");
//        tokenServices.setClientSecret("ivan-secret");
//        tokenServices.setCheckTokenEndpointUrl("http://localhost:8070/oauth/check_token");
//        return tokenServices;
//    }
}
