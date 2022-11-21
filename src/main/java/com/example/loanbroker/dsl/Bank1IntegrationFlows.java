package com.example.loanbroker.dsl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.stereotype.Component;

@Component
public class Bank1IntegrationFlows {

    @Bean
    @ConditionalOnProperty(prefix = "loan-broker.http-adapter.outbound.bank1", name = "enabled", havingValue = "true")
    public IntegrationFlow bank1LoanInquiryIntegrationFlows(
            @Qualifier("bank1InquiryOutboundGateway") HttpRequestExecutingMessageHandler bank1InquiryOutboundGateway
    ) {
        return IntegrationFlows.from("bank1InquiryChannel")
                .handle(bank1InquiryOutboundGateway)
                .log()
                .channel("loanInquiryBankResponseChannel")
                .get();
    }

}
