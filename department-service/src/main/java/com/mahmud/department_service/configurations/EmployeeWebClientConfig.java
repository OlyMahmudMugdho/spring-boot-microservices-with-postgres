package com.mahmud.department_service.configurations;

import com.mahmud.department_service.clients.EmployeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.service.invoker.HttpExchangeAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import org.springframework.web.reactive.function.client.support.WebClientAdapter;

@Configuration
public class EmployeeWebClientConfig {

    @Autowired
    public LoadBalancedExchangeFilterFunction loadBalancedExchangeFilterFunction;

    @Bean
    public WebClient employeeWebClient() {
        return WebClient.builder()
                .baseUrl("http://employee-service")
                .filter(loadBalancedExchangeFilterFunction)
                .build();
    }

    @Bean
    public EmployeeClient employeeClient() {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory
                        .builder()
                        .exchangeAdapter(WebClientAdapter.create(employeeWebClient()))
                        .build();
        return httpServiceProxyFactory.createClient(EmployeeClient.class);
    }
}
