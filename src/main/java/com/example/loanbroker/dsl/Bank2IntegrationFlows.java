package com.example.loanbroker.dsl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.stereotype.Component;

@Component
public class Bank2IntegrationFlows {

    @Bean
    @ConditionalOnProperty(prefix = "loan-broker.http-adapter.outbound.bank2", name = "enabled", havingValue = "true")
    public IntegrationFlow bank2LoanInquiryIntegrationFlows(
            @Qualifier("bank2InquiryOutboundGateway") HttpRequestExecutingMessageHandler bank2InquiryOutboundGateway
    ) {
        return IntegrationFlows.from("bank2InquiryChannel")
                .handle(bank2InquiryOutboundGateway)
                .channel("loanInquiryBankResponseChannel")
                .log()
                .get();
    }

}
