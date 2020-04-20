package com.github.thamirestissot.sw_devops_test;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.github.thamirestissot.sw_devops_test.controller.Metrics;
import com.github.thamirestissot.sw_devops_test.service.Processor;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.ws.rs.ext.RuntimeDelegate;

@Configuration
public class AppConfig {

    @Bean(destroyMethod = "shutdown")
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean
    @DependsOn("cxf")
    public Server jaxRSServer() {
        final JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint(controller(), JAXRSServerFactoryBean.class);
        factory.setServiceBean(controller());
        factory.setProvider(jsonProvider());
        return factory.create();
    }

    @Bean
    public JacksonJsonProvider jsonProvider() {
        return new JacksonJsonProvider();
    }

    @Bean
    public Metrics controller() {
        return new Metrics();
    }

    @Bean
    public Processor processor() {
        return new Processor();
    }
}
