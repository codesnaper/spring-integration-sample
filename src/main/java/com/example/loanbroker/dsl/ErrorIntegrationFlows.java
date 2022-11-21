package com.example.loanbroker.dsl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ErrorIntegrationFlows {

    @Bean
    public IntegrationFlow errorLoanInquiryIntegrationFlows() {
        return IntegrationFlows.from("loanInquiryErrorChannel")
                .log(LoggingHandler.Level.ERROR, message -> message.getPayload())
                .log()
                .nullChannel();
    }

}
