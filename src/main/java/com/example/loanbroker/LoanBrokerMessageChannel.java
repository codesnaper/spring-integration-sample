package com.example.loanbroker;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public class LoanBrokerMessageChannel {

    @Bean
    public MessageChannel loanInquiryChannel() {
        return MessageChannels.publishSubscribe().get();
    }

    @Bean
    public MessageChannel bank1InquiryChannel() {
        return MessageChannels.direct().get();
    }

    @Bean
    public MessageChannel bank2InquiryChannel() {
        return MessageChannels.direct().get();
    }

    @Bean
    public MessageChannel loanInquiryBankResponseChannel() {
        return MessageChannels.queue().get();
    }

    @Bean
    public MessageChannel loanInquiryResponseChannel() {
        return MessageChannels.direct().get();
    }

    @Bean
    public MessageChannel creditBeauroRequestChannel() {
        return MessageChannels.direct().get();
    }

    @Bean
    public MessageChannel creditBeauroResponseChannel() {
        return MessageChannels.direct().get();
    }

    @Bean
    public MessageChannel loanInquiryErrorChannel() {
        return MessageChannels.direct().get();
    }

    @Bean
    public MessageChannel creditScoreChannel() {
        return MessageChannels.direct().get();
    }

}
