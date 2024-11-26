package com.qride.notifications.infraestructure.configurations;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "meta")
public class MetaConfig {
    private String authToken;
    private String apiUrl;
}
