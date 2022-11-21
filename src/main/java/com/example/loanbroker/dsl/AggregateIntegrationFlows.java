package com.example.loanbroker.dsl;

import com.example.loanbroker.config.AdapterConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.stereotype.Component;

@Component
public class AggregateIntegrationFlows {

    @Bean
    public IntegrationFlow aggregateResponse(AdapterConfig adapterConfig) {
        int activeBankCount = adapterConfig.getOutbound().getBank1().isEnabled() ? 1 : 0;
        activeBankCount += adapterConfig.getOutbound().getBank2().isEnabled() ? 1 : 0;
        int finalActiveBankCount = activeBankCount;
        return IntegrationFlows.from("loanInquiryBankResponseChannel")
                .aggregate(aggregatorSpec -> aggregatorSpec.correlationStrategy(m -> m.getHeaders().get("unique-id"))
                        .releaseStrategy(g -> g.size() == finalActiveBankCount)
                        .expireGroupsUponCompletion(true)
                )
                .channel("loanInquiryResponseChannel")
                .get();
    }
}
