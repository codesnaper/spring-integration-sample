package com.example.loanbroker.adapter;

import com.example.loanbroker.config.AdapterConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.integration.http.dsl.Http;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.web.client.RestTemplate;

public class CreditBeauroOutboundGateway {

    @Bean
    @ConditionalOnProperty(prefix = "loan-broker.http-adapter.outbound.creditbeauro", name = "enabled", havingValue = "true")
    public HttpRequestExecutingMessageHandler bank1InquiryOutboundGateway(RestTemplate restTemplate, AdapterConfig adapterConfig) {
        return Http.outboundGateway(adapterConfig.getOutbound().getCreditbeauro().getUrl(), restTemplate)
                .httpMethod(HttpMethod.GET)
                .expectedResponseType(String.class)
                .uriVariable("pan", "headers[pan]")
                .get();
    }
}
