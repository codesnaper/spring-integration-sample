package com.example.loanbroker.dsl;

import com.example.config.UUIDGenerator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.http.dsl.HttpRequestHandlerEndpointSpec;
import org.springframework.integration.json.ObjectToJsonTransformer;
import org.springframework.stereotype.Component;

@Component
public class InboundGatewayIntegrationFlow {

    @Bean
    @ConditionalOnProperty(prefix = "loan-broker.http-adapter.inbound.loanInquiry", name = "enabled", havingValue = "true")
    public IntegrationFlow loanInquiryIntegrationFlows(
            HttpRequestHandlerEndpointSpec inboundGateway
    ) {
        return IntegrationFlows.from(inboundGateway)
                .transform(Transformers.toJson(ObjectToJsonTransformer.ResultType.NODE, MediaType.APPLICATION_JSON_VALUE))
                .enrichHeaders(headerEnricherSpec -> headerEnricherSpec.header("unique-id", UUIDGenerator.generateType4UUID().toString()))
                .channel("loanInquiryChannel")
                .log()
                .get();
    }

}
