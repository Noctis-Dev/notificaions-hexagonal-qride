package com.qride.notifications.infraestructure.external;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qride.notifications.domain.external.INotifyWhatsapp;
import com.qride.notifications.infraestructure.configurations.MetaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

@Component
public class MetaNotifyImpl implements INotifyWhatsapp {

    @Autowired
    private MetaConfig metaConfig;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void sendMessage(String to, String message) {
        HttpClient httpClient = HttpClient.newHttpClient();

        Map<String, Object> payload = new HashMap<>();
        payload.put("messaging_product", "whatsapp");
        payload.put("to", to);
        Map<String, Object> template = new HashMap<>();
        template.put("name", "soa_test");
        Map<String, String> language = new HashMap<>();
        language.put("code", "es_MX");
        template.put("language", language);
        payload.put("template", template);

        try {
            String requestBody = objectMapper.writeValueAsString(payload);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(metaConfig.getApiUrl()))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + metaConfig.getAuthToken())
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Error sending message");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error sending message", e);
        }
    }

}
