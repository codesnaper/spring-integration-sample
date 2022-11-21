package com.example.loanbroker.adapter;

import com.example.loanbroker.config.AdapterConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.integration.http.dsl.Http;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LoanInquiryOutboundGateway {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @ConditionalOnProperty(prefix = "loan-broker.http-adapter.outbound.bank1", name = "enabled", havingValue = "true")
    public HttpRequestExecutingMessageHandler bank1InquiryOutboundGateway(RestTemplate restTemplate, AdapterConfig adapterConfig) {
        return defaultOutboundGateway(adapterConfig.getOutbound().getBank1().getUrl(), restTemplate);
    }

    @Bean
    @ConditionalOnProperty(prefix = "loan-broker.http-adapter.outbound.bank2", name = "enabled", havingValue = "true")
    public HttpRequestExecutingMessageHandler bank2InquiryOutboundGateway(RestTemplate restTemplate, AdapterConfig adapterConfig) {
        return defaultOutboundGateway(adapterConfig.getOutbound().getBank2().getUrl(), restTemplate);
    }

    private HttpRequestExecutingMessageHandler defaultOutboundGateway(String outboundUrl, RestTemplate restTemplate) {
        return Http.outboundGateway(outboundUrl, restTemplate)
                .httpMethod(HttpMethod.POST)
                .expectedResponseType(String.class)
                .get();
    }

}
