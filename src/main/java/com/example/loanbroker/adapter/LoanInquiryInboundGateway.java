package com.example.loanbroker.adapter;

import com.example.loanbroker.config.AdapterConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.integration.http.dsl.Http;
import org.springframework.integration.http.dsl.HttpRequestHandlerEndpointSpec;
import org.springframework.stereotype.Component;

@Component
public class LoanInquiryInboundGateway {

    @Bean
    @ConditionalOnProperty(prefix = "loan-broker.http-adapter.inbound.loanInquiry", name = "enabled", havingValue = "true")
    public HttpRequestHandlerEndpointSpec inboundGateway(
            AdapterConfig adapterConfig
    ){
        return Http.inboundGateway(adapterConfig.getInbound().getLoanInquiry().getUrl())
                .requestMapping(requestMappingSpec -> requestMappingSpec.methods(HttpMethod.POST))
                .errorChannel("loanInquiryErrorChannel")
                .replyChannel("loanInquiryResponseChannel");
    }
}
