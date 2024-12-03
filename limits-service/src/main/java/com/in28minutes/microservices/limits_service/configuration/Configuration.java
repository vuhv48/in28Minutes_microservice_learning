package com.in28minutes.microservices.limits_service.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class Configuration {
    private int minimum;
    private int maximum;
}
