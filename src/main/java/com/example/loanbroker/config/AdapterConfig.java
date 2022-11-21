package com.example.loanbroker.config;

import com.example.loanbroker.modal.InboundProps;
import com.example.loanbroker.modal.OutboundProps;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "loan-broker.http-adapter")
@Data
@ToString
@EqualsAndHashCode
public class AdapterConfig {

    OutboundProps outbound;

    InboundProps inbound;
}



