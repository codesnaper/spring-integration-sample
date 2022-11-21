package com.example.loanbroker.transformer;

import com.example.loanbroker.config.AdapterConfig;
import com.example.loanbroker.spec.SpecLoader;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.transformer.AbstractPayloadTransformer;
import org.springframework.stereotype.Component;

@Component
public class LoanInquiryTransformer {

    @Bean
    @ConditionalOnProperty(prefix = "loan-broker.http-adapter.outbound.bank1", name = "enabled", havingValue = "true")
    @Transformer(inputChannel = "loanInquiryChannel", outputChannel = "bank1InquiryChannel")
    public AbstractPayloadTransformer transformBank1Payload(
            AdapterConfig adapterConfig
    ) {
        return new AbstractPayloadTransformer() {
            @Override
            protected Object transformPayload(Object payload) {
                return SpecLoader.chainr(adapterConfig.getOutbound().getBank1().getSpec(), () -> payload);
            }
        };
    }

    @Bean
    @ConditionalOnProperty(prefix = "loan-broker.http-adapter.outbound.bank2", name = "enabled", havingValue = "true")
    @Transformer(inputChannel = "loanInquiryChannel", outputChannel = "bank2InquiryChannel")
    public AbstractPayloadTransformer transformBank2Payload(
            AdapterConfig adapterConfig
    ) {
        return new AbstractPayloadTransformer() {
            @Override
            protected Object transformPayload(Object payload) {
                return SpecLoader.chainr(adapterConfig.getOutbound().getBank2().getSpec(), () -> payload);
            }
        };
    }

}
